#include "FilaDeImpressao.hpp"

#include <iostream>

FilaDeImpressao::FilaDeImpressao() {
    cabeca = NULL;
    cauda = NULL;
    this->qtdDocumentos = 0;
}
FilaDeImpressao::FilaDeImpressao(string nomeArquivo, int numPaginas,
                                 int prioridade) {
    this->qtdDocumentos = 0;
    cabeca = new Documento(nomeArquivo, numPaginas, prioridade);
    cauda = cabeca;
    this->qtdDocumentos++;
}
FilaDeImpressao::~FilaDeImpressao() {
    Documento *atual = cabeca;
    while (atual != NULL) {
        Documento *temp = atual;
        atual = atual->getProx();
        delete temp;
    }
}

void FilaDeImpressao::mostrarFilaDeImpressao() {
    cout << "\nImprimindo todos os elementos...\n";
    Documento *c = cabeca;
    if (vazia())
        cout << "A Fila De Impressao NÃO possui elementos !!\n";
    else {
        while (c) {
            cout << "Documento " << c->getId() << endl;
            cout << "Nome do Documento: " << c->getNomeArquivo() << endl;
            cout << "Numero de paginas do Documento " << c->getNumPaginas()
                 << endl;
            cout << "Prioridade do Documento " << c->getPrioridade() << endl;
            c = c->getProx();
        }
        cout << endl;
    }
}

bool FilaDeImpressao::vazia() { return (cabeca == NULL); }

void FilaDeImpressao::inserirDocumento(Documento *p, string palavraChave) {
    Documento *pAux, *pAnterior, *novo;
    int cont = 0;
    if (!vazia()) {
        for(pAux = this->cabeca; pAux != NULL; pAnterior = pAux, pAux = pAux->getProx(), cont++){
			if(pAux->getPrioridade() < p->getPrioridade()){
				if(!cont){
					novo = p;
					novo->setProx(pAux);
					this->cabeca = novo;
					cout << endl << "Ha " << cont << "documentos na frente do documento " << palavraChave << endl;
					break;
				} else {
					novo = p;
					novo->setProx(pAux);
					pAnterior->setProx(novo);
					cout << endl << "Ha " << cont << "documentos na frente do documento " << palavraChave << endl;
					break;
				}
			} else if(pAux->getProx() == NULL){
				cont++;
				novo = p;
				novo->setProx(NULL);
				pAux->setProx(novo);
				cout << endl << "Ha " << cont << "documentos na frente do documento " << palavraChave << endl;
				break;
			}
		}
    } else {
        cabeca = p;
        cauda = p;
    }
    this->qtdDocumentos++;
}

int FilaDeImpressao::size() {
    if (vazia()) return 0;
    Documento *c = cabeca;
    int tam = 0;
    do {
        c = c->getProx();
        tam++;
    } while (c);
    return tam;
}

void FilaDeImpressao::buscarDocumento(int id) {
    Documento *c = cabeca;
    if (vazia())
        cout << "A Fila De Impressao NÃO possui elementos !!\n";
    else {
        while (c) {
            if (c->getId() == id) {
                cout << "Documento " << c->getId() << endl;
                cout << "Nome do Documento: " << c->getNomeArquivo() << endl;
                cout << "Numero de paginas do Documento " << c->getNumPaginas()
                     << endl;
                cout << "Prioridade do Documento " << c->getPrioridade()
                     << endl;
                break;
            }
            c = c->getProx();
        }
        cout << endl;
    }
}

bool FilaDeImpressao::existe(int id) {
    Documento *c = cabeca;
    while (c) {
        if (c->getId() == id) return true;
        c = c->getProx();
    }
    return false;
}

void FilaDeImpressao::remover(int id) {    
    if (!vazia()) {
        Documento *pAux, *pAnterior;
        int cont = 0;
        for (pAux = this->cabeca; pAux != NULL; pAnterior = pAux, pAux = pAux->getProx()) {
            if(pAux->getId() == id){
                if(pAux == this->cabeca){
                    this->cabeca = pAux->getProx();
                }else {
                    pAnterior->setProx(pAux->getProx());
                }
                cout << "Este documento saiu da lista: " << endl;
                cout << "Documento " << pAux->getId() << endl;
                cout << "Nome do Documento: " << pAux->getNomeArquivo() << endl;
                cout << "Numero de paginas do Documento " << pAux->getNumPaginas() << endl;
                cout << "Prioridade do Documento " << pAux->getPrioridade() << endl;
                this->qtdDocumentos--;
                cout << "Resta(m)" << this->qtdDocumentos <<  "documento(s) na fila de impressao." << endl;
                this->mostrarFilaDeImpressao();
                cont++;
                delete pAux;
                
                break;
            }
		}
        if(!cont){
			 cout << endl << "CPF nao encontrado!" << endl;
		}
    } else {
		cout << endl << "Impossivel remover documentos de uma lista vazia!" << endl;
	}
}

void FilaDeImpressao::alterar(int id){
	if(!vazia()){
		int cont = 0, novaP;
		Documento *pAlterado, *pAnterior;
		
		for (pAlterado = this->cabeca; pAlterado != NULL; pAnterior = pAlterado, pAlterado = pAlterado->getProx()) {
			if(pAlterado->getId() == id){
				cont++;
                if(!(pAlterado == this->cabeca)){
					pAnterior->setProx(pAlterado->getProx());
				} else {
					 this->cabeca = pAlterado->getProx();
				}
				break;
			}
		}
		
		if(cont){
            int escolha, dadoInt;
            string dadoString;
			do{
				cout << "Documento " << pAlterado->getId() << endl;
                cout << "Nome do Documento: " << pAlterado->getNomeArquivo() << endl;
                cout << "Numero de paginas do Documento " << pAlterado->getNumPaginas() << endl;
                cout << "Prioridade do Documento " << pAlterado->getPrioridade() << endl;
                
				cout << endl << "Escolha o dado que voce deseja alterar (1 = NOME DO DOCUMENTO, 2 = NUMERO DE PAGINAS, 3 = PRIORIDADE, -1 = SAIR): ";
				cin >> escolha;
				
				switch(escolha){
					case 1: {
					    cout << endl << "Digite o novo nome do documento: ";
						cin >> dadoString;
						pAlterado->setNomeArquivo(dadoString);


						cout << "Nome do documento " << pAlterado->getId() <<  "alterado!" << endl;
						break;
					}
					case 2: {
						cout << endl << "Digite o novo numero de paginas do documento: ";
						cin >> dadoInt;
						pAlterado->setNumPaginas(dadoInt);

						cout << "Numero de paginas do documento " << pAlterado->getId() <<  "alterado!" << endl;
						break;
					}
					case 3: {
                        this->maiorPrioridade();
                        cout << endl << "Digite a nova prioridade do documento: ";
                        cin >> dadoInt;
                        pAlterado->setPrioridade(dadoInt);
        
						cout << "Prioridade do documento " << pAlterado->getId() <<  "alterado!" << endl;
						break;
					}
					case -1: {
						printf("\nSaindo da edicao de cadastro...");
						break;
					}
					default: {
						printf("\nCaso invalido!");
						break;
					}
				}
				
			} while(escolha != -1);
            this->inserirDocumento(pAlterado, "alterada");
		} else {
			cout << endl << "CPF nao encontrado!" << endl;
		}
	} else {
		cout << endl << "Impossivel alterar documentos de uma lista vazia!" << endl;
	}
}

void FilaDeImpressao::maiorPrioridade(){
	if(vazia()){
		cout << endl << "Nao ha documentos na lista, portanto nao ha maior prioridade!" << endl;
	} else {
		cout << endl << "A maior prioridade eh: " << this->cabeca->getPrioridade() << endl;
	}
}
