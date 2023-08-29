#ifndef __Biblioteca_HPP
#define __Biblioteca_HPP
#include <string>
#include <list>
#include <iostream>
using namespace std;

#include "Livro.hpp"
using namespace std;
class Biblioteca {
   private:
    list<Livro> livros;

   public:
    Biblioteca();
    void adicionarLivro(Livro livro);
    Livro buscarLivro(string titulo, Autor autor);
    void mostrarLivros();
};
#endif