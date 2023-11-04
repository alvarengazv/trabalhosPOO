#ifndef PESSOA_HPP
#define PESSOA_HPP

#include <iostream>
#include <string>
#include "Pessoa.hpp"

using namespace std;
class Pessoa {
   private:
    string nome;
    string cpf;

   public:
    Pessoa();
    Pessoa(string nome, string cpf);
    
    string getNome();
    void setNome(string nome);
    string getCpf();
    void setCpf(string cpf);
    
};

#endif