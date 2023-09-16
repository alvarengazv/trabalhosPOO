#include "Documento.hpp"

using namespace std;

int Documento::contDocumentos=0; 
Documento::Documento() {}

Documento::Documento(string nomeArquivo, int numPaginas, int prioridade) {
    this->nomeArquivo = nomeArquivo;
    this->numPaginas = numPaginas;
    this->prioridade = prioridade;
    this->prox = NULL;

    this->contDocumentos++;

    this->id = this->contDocumentos;
}

int Documento::getId() { 
    return this->id; 
}

int Documento::getNumPaginas() { 
    return this->numPaginas; 
}
void Documento::setNumPaginas(int numPaginas) { 
    this->numPaginas = numPaginas; 
}

int Documento::getPrioridade() { 
    return this->prioridade; 
}
void Documento::setPrioridade(int prioridade) { 
    this->prioridade = prioridade;
}

string Documento::getNomeArquivo() { 
    return this->nomeArquivo; 
}
void Documento::setNomeArquivo(string nomeArquivo) { 
    this->nomeArquivo = nomeArquivo;
}

Documento* Documento::getProx() { 
    return this->prox; 
}
void Documento::setProx(Documento* p) { 
    this->prox = p; 
}
