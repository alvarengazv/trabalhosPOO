#include "PilhaProvas.hpp"

PilhaProvas::PilhaProvas() {
    this->topo = NULL;
    this->qtdProvas = 0;
}

PilhaProvas::PilhaProvas(Prova *p) {
    this->topo = p;
    this->qtdProvas = 1;
}

PilhaProvas::~PilhaProvas() {
    Prova *p = this->topo;
    while (p != NULL) {
        Prova *t = p->getAbaixo();
        delete p;
        p = t;
    }
}

void *PilhaProvas::getTopo() {
    if(this->estaVazia()) {
        cout << "Pilha vazia!" << endl << endl;
    } else {
        this->topo->imprimeProva();
    }
}

void PilhaProvas::empilha(Prova *p) {
    p->setAbaixo(this->topo);
    this->topo = p;
    this->qtdProvas++;
    cout << "Prova empilhada: " << endl;
    p->imprimeProva();
    cout << "Quantidade de provas na pilha: " << this->qtdProvas << endl << endl;
}

void *PilhaProvas::desempilha() {
    if (this->estaVazia()) {
        cout << "Pilha vazia!" << endl << endl;
    } else {
        Prova *p = this->topo;
        this->topo = p->getAbaixo();
        cout << "Prova desempilhada: " << endl;
        p->imprimeProva();
        delete p;
        this->qtdProvas--;
        if(!this->estaVazia()){ 
            cout << endl << "Provas empilhadas: " << endl << endl;    
            this->imprimePilha();
        }
        cout << "Quantidade de provas na pilha: " << this->qtdProvas << endl << endl;
    }
}

bool PilhaProvas::estaVazia() {
    return this->topo == NULL;
}

void PilhaProvas::imprimePilha() {
    Prova *p = this->topo;
    while (p != NULL) {
        p->imprimeProva();
        p = p->getAbaixo();
    }
    cout << endl;
}