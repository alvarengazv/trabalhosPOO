#include <iostream>
#include <locale>

#include "Headers/Autor.hpp"
#include "Headers/Livro.hpp"
#include "Headers/Biblioteca.hpp"

using namespace std;

int main(){
    setlocale(LC_ALL, "");
    Autor a1("Guilherme", "28/07/2004");
    Autor a2("Guilherme", "28/07/2004");

    cout << "------------------------TESTES---------------------------";

    cout << a1.getNome() << " nasceu em: " << a1.getDataNascimento() << endl;

    a1.setNome("Rafael");
    a1.setDataNascimento("31/07/2000");

    cout << a1.getNome() << " nasceu em: " << a1.getDataNascimento() << endl;

    Livro l1("Livro tal", a1, "123-45-678-9123-4");

    cout << l1.getTitulo() << " eh um livro escrito por " << l1.getAutor().getNome() << " com o ISBN: " << l1.getISBN() << endl;

    l1.setTitulo("Livro tal 2");
    l1.setISBN("432-19-876-5432-1");
    l1.setAutor(a2);

    cout << l1.getTitulo() << " agora mudou de nome e foi escrito por " << l1.getAutor().getNome() << " com o ISBN: " << l1.getISBN() << endl << endl;

    cout << "-------------------------FIM-----------------------------";

    cout << "-------------------------MENU----------------------------";

    

    cout << "-------------------------FIM-----------------------------";


}