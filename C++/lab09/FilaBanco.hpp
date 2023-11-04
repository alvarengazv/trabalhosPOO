#ifndef FilaDeBanco_HPP
#define FilaDeBanco_HPP

#include "ClienteBanco.hpp"
#include <iostream>

using namespace std;

class FilaBanco {
   private:
    ClienteBanco *cabeca;
    ClienteBanco *cauda;
    int qtdClientesBanco;

   public:
    FilaBanco();
    FilaBanco(ClienteBanco *d);
    ~FilaBanco();

    void enfileira(ClienteBanco *d);
    void desenfileira();
    void imprime();
    int getQtdClientesBanco();
    void enfileiraPrioritario(ClienteBanco *d);
    int estaVazia();
    ClienteBanco* getCabeca();
    ClienteBanco* getCauda();
    void setCabeca(ClienteBanco *c);
    void setCauda(ClienteBanco *c);
    bool cpfExiste(string cpf);

};
#endif
