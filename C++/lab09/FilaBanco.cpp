#include "FilaBanco.hpp"

FilaBanco::FilaBanco() {
    cabeca = NULL;
    cauda = NULL;
    this->qtdClientesBanco = 0;
}

FilaBanco::FilaBanco(ClienteBanco *d) {
    this->qtdClientesBanco = 0;
    cabeca = d;
    cauda = cabeca;
}

FilaBanco::~FilaBanco() {
    ClienteBanco *aux = cabeca;
    while (aux != NULL) {
        cabeca = cabeca->getProx();
        delete aux;
        aux = cabeca;
    }
}

void FilaBanco::enfileira(ClienteBanco *d) {
    if (estaVazia()) {
        cabeca = d;
        cauda = cabeca;
    } else {
        cauda->setProx(d);
        cauda = d;
    }
    cout << "Ha " << this->qtdClientesBanco << " clientes na frente de " << d->getNome() << "!" << endl << endl;
    this->qtdClientesBanco++;
}

void FilaBanco::desenfileira() {
    if (estaVazia()) {
        cout << "Fila vazia!" << endl << endl;
    } else {
        ClienteBanco *aux = cabeca;
        cabeca = cabeca->getProx();
        this->qtdClientesBanco--;
        cout << "Cliente " << aux->getNome() << " desenfileirado!" << endl;
        cout << "Restam " << this->qtdClientesBanco << " clientes na fila!" << endl << endl;

        delete aux;
    }
}

void FilaBanco::imprime() {
    ClienteBanco *aux = cabeca;
    if(estaVazia()) {
        cout << "Fila vazia!" << endl << endl;
        return;
    }

    int i = 0;
    string teste;
    cin.ignore(1000, '\n');

    while (aux != NULL) {
        i++;
        cout << "Cliente " << i << ": " << endl;
        cout << "Nome: " << aux->getNome() << endl;
        cout << "Prioritario: " << (!aux->getPrioridade() ? "Nao" : "Sim") << endl;
        cout << "CPF: " << aux->getCpf() << endl;
        cout << "Agencia: " << aux->getAgencia() << endl;
        cout << "Numero da conta: " << aux->getNumeroDaConta() << endl;
        cout << endl;
        aux = aux->getProx();
        cout << "Aperte enter para " << (aux != NULL ? "ver o próximo cliente..." : "sair...") << endl;
        getline(cin, teste);
    }
    cout << endl;
}

int FilaBanco::getQtdClientesBanco() {
    return this->qtdClientesBanco;
}

void FilaBanco::enfileiraPrioritario(ClienteBanco *d) {
    d->setPrioridade(true);
    int i = 0;
    if (estaVazia()) {
        cabeca = d;
        cauda = cabeca;
    } else {
        ClienteBanco *aux = cabeca;
        ClienteBanco *ant = NULL;
        while (aux != NULL && aux->getPrioridade() == true) {
            i++;
            ant = aux;
            aux = aux->getProx();
        }
        if (ant == NULL) {
            d->setProx(cabeca);
            cabeca = d;
        } else {
            d->setProx(aux);
            ant->setProx(d);
        }
    }
    cout << "Ha " << i << " clientes na frente de " << d->getNome() << "!" << endl << endl;
    this->qtdClientesBanco++;
}

int FilaBanco::estaVazia() {
    return cabeca == NULL;
}

ClienteBanco *FilaBanco::getCabeca() { return this->cabeca; }

void FilaBanco::setCabeca(ClienteBanco *c) {
    this->cabeca = c;
}

ClienteBanco* FilaBanco::getCauda() {
    return this->cauda;
}

void FilaBanco::setCauda(ClienteBanco *c) {
    this->cauda = c;
}

bool FilaBanco::cpfExiste(string cpf) { 
    ClienteBanco *aux = cabeca;
    while(aux != NULL) {
        if(aux->getCpf() == cpf) {
            return true;
        }
        aux = aux->getProx();
    }
    return false;
}
