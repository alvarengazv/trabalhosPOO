#ifndef FilaDeImpressao_HPP
#define FilaDeImpressao_HPP

#include "Documento.hpp"

using namespace std;
class FilaDeImpressao {
   private:
    Documento *cabeca;
    Documento *cauda;
    int qtdDocumentos;

   public:
    FilaDeImpressao();
    FilaDeImpressao(Documento *d);
    virtual ~FilaDeImpressao();
    void mostrarFilaDeImpressao();
    bool vazia();
    void inserirDocumento(Documento *p, string palavraChave);
    int getQtdDocumentos();
    void buscarDocumento(int id);
    bool existe(int id);
    void remover(int id);

    void alterar(int id);
    void maiorPrioridade();
};
#endif
