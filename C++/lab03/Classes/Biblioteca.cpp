#include "Biblioteca.hpp"

Biblioteca::Biblioteca(){
    this->livros = list<Livro>();
}

void Biblioteca::adicionarLivro(Livro livro){
    this->livros.push_front(livro);
}

Livro Biblioteca::buscarLivro(string titulo, Autor autor){
    for(Livro i : this->livros){
        if(i.getAutor().getNome() == autor.getNome() && i.getAutor().getDataNascimento() == autor.getDataNascimento() && i.getTitulo() == titulo){
            cout << endl << "Livro encontrado!" << endl;
            return i;
        }
    }
    cout << endl << "Livro nao encontrado!" << endl << endl;
    Autor a;
    Livro l("", a, "");
    return l;
}

void Biblioteca::mostrarLivros(){
    if(!this->livros.empty()){
        cout << "Lista de livros:" << endl;
        int u = 0;
        for(Livro i : this->livros){
            cout << endl << "Livro " << ++u << endl << "Titulo: " << i.getTitulo() << endl << "Nome do autor: " << i.getAutor().getNome() << endl << "Data de nascimento do autor: " << i.getAutor().getDataNascimento() << endl << "ISBN: " << i.getISBN() << endl;
        }
    } else {
        cout << "Biblioteca vazia!";
    }
}