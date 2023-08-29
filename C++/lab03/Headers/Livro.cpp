#include "Livro.hpp"

using namespace std;

Livro::Livro(string titulo, Autor autor, string ISBN) {
    this->titulo = titulo;
    this->autor = autor;
    this->ISBN = ISBN;
}

string Livro::getTitulo() {
    return this->titulo;
}

void Livro::setTitulo(string titulo) {
    this->titulo = titulo;
}

string Livro::getISBN() {
    return this->ISBN;
}

void Livro::setISBN(string ISBN) {
    this->ISBN = ISBN;
}

Autor Livro::getAutor() {
    return this->autor;
}

void Livro::setAutor(Autor autor) {
    this->autor = autor;
}