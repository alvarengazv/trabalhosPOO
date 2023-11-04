#include <iostream>
#include <string>
#include <cstdio>
#include <random>

#include "ClienteBanco.hpp"
#include "FilaBanco.hpp"
#include "Prova.hpp"
#include "PilhaProvas.hpp"
#include "Aluno.hpp"

using namespace std;

#define MAX 25

void limpaConsole(){
    system("cls||clear");
}

void menuInicial(){
    cout << "---------------------MENU PRINCIPAL---------------------" << endl << endl;
    cout << "1 - Gerenciar fila do banco" << endl;
    cout << "2 - Gerenciar pilha de provas" << endl;
    cout << "3 - Sair" << endl << endl;
    cout << "Digite a opcao desejada: ";
}

void menuProva(){
    cout << "---------------------GERENCIAMENTO DE PILHA DE PROVAS---------------------" << endl << endl;
    cout << "1 - Empilhar prova na pilha" << endl;
    cout << "2 - Desempilhar prova da pilha" << endl;
    cout << "3 - Mostrar prova do topo" << endl;
    cout << "4 - Verificar se a pilha esta vazia" << endl;
    cout << "5 - Sair" << endl << endl;
    cout << "Digite a opcao desejada: ";
}

void menuBanco(){
    cout << "---------------------GERENCIAMENTO DE FILA DE BANCO---------------------" << endl << endl;
    cout << "1 - Inserir cliente na fila" << endl;
    cout << "2 - Atender cliente" << endl;
    cout << "3 - Mostrar fila" << endl;
    cout << "4 - Verificar se a fila esta vazia" << endl;
    cout << "5 - Inserir cliente prioritario" << endl;
    cout << "6 - Sair" << endl << endl;
    cout << "Digite a opcao desejada: ";
}

ClienteBanco* enfileiraCliente(FilaBanco *filaBanco){
    string nome, cpf, agencia;
    cin.ignore(1000, '\n');
    cout << endl << "NOME DO CLIENTE: ";
    getline(cin, nome);
    cout << endl << "CPF DO CLIENTE: ";
    cin >> cpf;
    cin.ignore(1000, '\n');
    while(filaBanco->cpfExiste(cpf)){
        cout << endl << "CPF ja cadastrado! Digite novamente: ";
        cin >> cpf;
        cin.ignore(1000, '\n');
    }

    cout << endl << "AGENCIA DO CLIENTE: ";
    cin >> agencia;
    cin.ignore(1000, '\n');

    return new ClienteBanco(false, nome, cpf, agencia);
}

int main() {
    Aluno alunos[15];

    alunos[0] = Aluno("ADS", "Joao", "1");
    alunos[1] = Aluno("ADS", "Maria", "2");
    alunos[2] = Aluno("ADS", "Jose", "3");
    alunos[3] = Aluno("ADS", "Pedro", "4");
    alunos[4] = Aluno("ADS", "Ana", "5");
    alunos[5] = Aluno("ADS", "Paulo", "6");
    alunos[6] = Aluno("ADS", "Lucas", "7");
    alunos[7] = Aluno("ADS", "Marcos", "8");
    alunos[8] = Aluno("ADS", "Lucia", "9");
    alunos[9] = Aluno("ADS", "Julia", "10");
    alunos[10] = Aluno("ADS", "Ana", "11");
    alunos[11] = Aluno("ADS", "Paulo", "12");
    alunos[12] = Aluno("ADS", "Lucas", "13");
    alunos[13] = Aluno("ADS", "Marcos", "14");
    alunos[14] = Aluno("ADS", "Lucia", "15");

    limpaConsole();
    int escolha;
    FilaBanco *filaBanco = new FilaBanco();
    PilhaProvas *pilhaProvas = new PilhaProvas();

    do {
        menuInicial();
        cin >> escolha;
        limpaConsole();

        switch (escolha) {
            case 1: {
                int escolhaBanco;
                do {
                    menuBanco();
                    cin >> escolhaBanco;
                    limpaConsole();
                    switch (escolhaBanco) {
                        case 1: {
                            string nome, cpf, agencia;
                            cout << endl << "---------------------ENFILEIRAMENTO DE CLIENTES---------------------" << endl;
                            
                            filaBanco->enfileira(enfileiraCliente(filaBanco));
                            break;
                        }
                        case 2: {
                            filaBanco->desenfileira();
                            break;
                        }
                        case 3: {
                            filaBanco->imprime();
                            break;
                        }
                        case 4: {
                            limpaConsole();
                            if(filaBanco->estaVazia()){
                                cout << "Fila vazia!" << endl << endl;
                            } else {
                                cout << "Fila nao esta vazia!" << endl << endl;
                            }
                            break;
                        }
                        case 5: {
                            string nome, cpf, agencia;
                            cout << endl << "---------------------ENFILEIRAMENTO DE CLIENTES PRIORITÁRIOS---------------------" << endl;
                            
                            filaBanco->enfileiraPrioritario(enfileiraCliente(filaBanco));
                            break;
                        }
                        case 6: {
                            limpaConsole();
                            break;
                        }
                        default: {
                            cout << "Opcao invalida!" << endl << endl;
                            break;
                        }
                    }
                } while (escolhaBanco != 6);
                break;
            }
            case 2: {
                int escolhaProva;
                do {
                    menuProva();
                    cin >> escolhaProva;
                    limpaConsole();
                    switch (escolhaProva) {
                        case 1: {
                            string disciplina, cpf, nome, curso;
                            float nota;
                            cout << endl << "---------------------EMPILHAMENTO DE PROVAS---------------------" << endl;
                            cin.ignore(1000, '\n');
                            cout << endl << "DISCIPLINA: ";
                            getline(cin, disciplina);

                            cout << endl << "NOTA: ";
                            cin >> nota;
                            
                            random_device rd;
                            mt19937 rng(rd());
                            uniform_int_distribution<mt19937::result_type> dist(0, 14);
                            int random = dist(rng);
                            
                            Prova *novaProva = new Prova(disciplina, nota, alunos[random]);
                            pilhaProvas->empilha(novaProva);
                            break;
                        }
                        case 2: {
                            pilhaProvas->desempilha();
                            break;
                        }
                        case 3: {
                            pilhaProvas->getTopo();
                            break;
                        }
                        case 4: {
                            if(pilhaProvas->estaVazia()){
                                cout << "Pilha vazia!" << endl << endl;
                            } else {
                                cout << "Pilha nao esta vazia!" << endl << endl;
                            }
                            break;
                        }
                        case 5: {
                            limpaConsole();
                            break;
                        }
                        default: {
                            cout << "Opcao invalida!" << endl << endl;
                            break;
                        }
                    }
                } while (escolhaProva != 5);
                break;
            }
            case 3: {
                limpaConsole();
                break;
            }
            default: {
                cout << "Opcao invalida!" << endl << endl;
                break;
            }
        }
    } while (escolha != 3);
}

