#ifndef DOCUMENTO_HPP
#define DOCUMENTO_HPP

#include <iostream>
#include "Documento.hpp"

using namespace std;
class Documento {
   private:
    int id;
    int numPaginas;
    int prioridade;
    string nomeArquivo;
    static int contDocumentos;
    Documento* prox;

   public:
    Documento();
    Documento(string nomeArquivo, int numPaginas, int prioridade);
    
    int getId();
    int getNumPaginas();
    void setNumPaginas(int numPaginas);
    int getPrioridade();
    void setPrioridade(int prioridade);
    string getNomeArquivo();
    void setNomeArquivo(string nomeArquivo);
    Documento* getProx();
    void setProx(Documento* p);
    
};

#endif