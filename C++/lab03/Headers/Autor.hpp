#ifndef __Autor_HPP
#define __Autor_HPP
#include <string>
#include <iostream>

using namespace std;
class Autor {
   private:
    string nome, dataNascimento;

   public:
    Autor();
    Autor(string nome, string dataNascimento);
    string getNome();
    void setNome(string nome);
    string getDataNascimento();
    void setDataNascimento(string dataNascimento);
};
#endif