#include <iostream>
#include <string>
#include <cstdio>
#include "Documento.hpp"
#include "FilaDeImpressao.hpp"

using namespace std;

int main() {
    int escolha;

    FilaDeImpressao *fila = new FilaDeImpressao();

    do {
        cout
            << endl
            << "Escolha uma opcao do menu (1 = ADICIONAR DOCUMENTO, 2 = CONSULTAR DOCUMENTO POR ID, "
               "3 = LISTAR TODOS OS DOCUMENTOS DA FILA, 4 = REMOVER UM DOCUMENTO DA FILA, "
               "5 = ALTERAR INFORMACOES DE UM DOCUMENTO, -1 = SAIR): ";
        cin >> escolha;

        switch (escolha) {
            case 1: {
                string nomeArquivo;
                int numPaginas, prioridade;
                cout << endl << "---------------------CADASTRO DE DOCUMENTOS---------------------" << endl;
                cin.ignore(1000, '\n');
                cout << endl << "NOME DO DOCUMENTO: ";
                getline(cin, nomeArquivo);
                cout << endl << "NUMERO DE PAGINAS DO DOCUMENTO: ";
                cin >> numPaginas;
                cout << endl << "PRIORIDADE DO DOCUMENTO: ";
                cin >> prioridade;
                
                Documento *novoDocumento = new Documento(nomeArquivo, numPaginas, prioridade);
                
                fila->inserirDocumento(novoDocumento, "cadastrado");

                cout << endl << "----------------------------------------------------------------" << endl;
                
                break;
            }
            case 2: {
                int id;
                cout << endl << "---------------------CONSULTA DE DOCUMENTOS---------------------" << endl;

                if(fila->vazia()){
                    cout << endl << "Impossivel buscar documentos de uma lista vazia!" << endl;
                    cout << endl << "----------------------------------------------------------------" << endl;
                    break;
                }
                cout << endl << "ID DO DOCUMENTO: ";
                cin >> id;
                if(!fila->existe(id)){
                    cout << endl << "Documento nao encontrado!" << endl;
                    cout << endl << "----------------------------------------------------------------" << endl;
                    break;
                } else {
                    fila->buscarDocumento(id);
                }

                cout << endl << "----------------------------------------------------------------" << endl;
                
                break;
            }
            case 3: {
                cout << endl << "---------------------LISTA DE DOCUMENTOS---------------------" << endl;

                if(fila->vazia()){
                    cout << endl << "Lista vazia!" << endl;
                    cout << endl << "----------------------------------------------------------------" << endl;
                    break;
                }
                fila->mostrarFilaDeImpressao();

                cout << endl << "-------------------------------------------------------------" << endl;
                
                break;
            }
            case 4: {
                int id;
                cout << endl << "---------------------REMOCAO DE DOCUMENTOS---------------------"  << endl;

                if(fila->vazia()){
                    cout << endl << "Impossivel remover documentos de uma lista vazia!" << endl;
                    cout << endl << "----------------------------------------------------------------" << endl;
                    break;
                }
                cout << endl << "ID DO DOCUMENTO: ";
                cin >> id;
                
                if(!fila->existe(id)){
                    cout << endl << "Documento nao encontrado!" << endl;
                    cout << endl << "----------------------------------------------------------------" << endl;
                    break;
                } else {
                    fila->remover(id);
                }
                cout << endl << "----------------------------------------------------------------" << endl;

                break;
            }
            case 5: {
                int id;
                cout << endl << "---------------------ALTERACAO DE DOCUMENTOS---------------------" << endl;
                

                if(fila->vazia()){
                    cout << endl << "Impossivel alterar documentos de uma lista vazia!" << endl;
                    cout << endl << "----------------------------------------------------------------" << endl;
                    break;
                } 
                cout << endl << "ID DO DOCUMENTO: ";
                cin >> id;
                if(!fila->existe(id)){
                    cout << endl << "Documento nao encontrado!" << endl;
                    cout << endl << "----------------------------------------------------------------" << endl;
                    break;
                } else {
                    fila->alterar(id);    
                }

                cout << endl << "----------------------------------------------------------------" << endl;
                
                break;
            }
            case -1: {
                cout << endl << "Saindo do programa...";
                break;
            }
            default: {
                cout << endl << "Caso invalido!";
                break;
            }
        }

    } while (escolha != -1);
}