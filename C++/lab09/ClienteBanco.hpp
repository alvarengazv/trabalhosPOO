#ifndef CLIENTEBANCO_HPP
#define CLIENTEBANCO_HPP

#include <iostream>
#include <string>
#include "Pessoa.hpp"

using namespace std;
class ClienteBanco: public Pessoa {
   private:
    string numeroDaConta;
    string agencia;
    bool prioridade;
    ClienteBanco* prox;
    static int contClientesBanco;

   public:
    ClienteBanco();
    ClienteBanco(bool prioridade, string nome, string cpf, string agencia);
    
    string getNumeroDaConta();
    string getAgencia();
    void setAgencia(string agencia);
    bool getPrioridade();
    void setPrioridade(bool prioridade);
    ClienteBanco* getProx();
    void setProx(ClienteBanco* p);
    
};

#endif