#ifndef __Livro_HPP
#define __Livro_HPP
#include <iostream>
#include "Autor.hpp"

using namespace std;
class Livro {
   private:
    string titulo, ISBN;
    Autor autor;

   public:
    Livro(string titulo, Autor autor, string ISBN);
    string getTitulo();
    void setTitulo(string titulo);
    string getISBN();
    void setISBN(string ISBN);
    Autor getAutor();
    void setAutor(Autor autor);
};
#endif