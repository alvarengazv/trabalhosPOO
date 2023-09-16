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
    FilaDeImpressao(string nomeArquivo, int numPaginas, int prioridade);
    virtual ~FilaDeImpressao();
    void mostrarFilaDeImpressao();
    void mostrarTodos();
    bool vazia();
    void inserirDocumento(Documento *p, string palavraChave);
    int size();
    void buscarDocumento(int id);
    bool existe(int id);
    void remover(int id);

    void alterar(int id);
    void maiorPrioridade();
};
#endif
