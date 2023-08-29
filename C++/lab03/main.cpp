#include <iostream>
#include <string>

#include "Classes/Autor.hpp"
#include "Classes/Livro.hpp"
#include "Classes/Biblioteca.hpp"

using namespace std;

int main()
{
    Autor a1("Guilherme", "28/07/2004");
    Autor a2("Guilherme", "28/07/2004");

    cout << "------------------------TESTES---------------------------" << endl
         << endl;

    cout << a1.getNome() << " nasceu em: " << a1.getDataNascimento() << endl;

    a1.setNome("Rafael");
    a1.setDataNascimento("31/07/2000");

    cout << a1.getNome() << " nasceu em: " << a1.getDataNascimento() << endl;

    Livro l1("Livro tal", a1, "123-45-678-9123-4");

    cout << l1.getTitulo() << " eh um livro escrito por " << l1.getAutor().getNome() << " com o ISBN: " << l1.getISBN() << endl;

    l1.setTitulo("Livro tal 2");
    l1.setISBN("432-19-876-5432-1");
    l1.setAutor(a2);

    cout << l1.getTitulo() << " agora mudou de nome e foi escrito por " << l1.getAutor().getNome() << " com o ISBN: " << l1.getISBN() << endl
         << endl;

    cout << "-------------------------FIM-----------------------------" << endl;

    int escolha = 4;

    Biblioteca b;
    Autor a;
    Livro l;
    string titulo, isbn, nomeAutor, dataNascAutor;

    do
    {   
        
        cout << "-------------------------MENU----------------------------" << endl;
        cout << "1 - Adicionar livro na biblioteca" << endl;
        cout << "2 - Procurar um livro" << endl;
        cout << "3 - Mostrar livros da biblioteca" << endl;
        cout << "0 - Sair do programa" << endl;
        cout << "Escolha uma opcao: ";

        cin >> escolha;
        switch (escolha)
        {
        case 1:
            cout << "Titulo do livro: ";
            cin >> titulo;
            cout << "ISBN do livro: ";
            cin >> isbn;
            cout << "Nome do autor do livro: ";
            cin >> nomeAutor;
            cout << "Data de nascimento do autor do livro: ";
            cin >> dataNascAutor;

            a.setNome(nomeAutor); 
            a.setDataNascimento(dataNascAutor);
            l.setTitulo(titulo);
            l.setAutor(a);
            l.setISBN(isbn);

            b.adicionarLivro(l);
            break;
        case 2:
            cout << "Titulo do livro: ";
            cin >> titulo;
            cout << "Nome do autor do livro: ";
            cin >> nomeAutor;
            cout << "Data de nascimento do autor do livro: ";
            cin >> dataNascAutor;

            a.setNome(nomeAutor); 
            a.setDataNascimento(dataNascAutor);
            l = b.buscarLivro(titulo, a);

            if(l.getTitulo() != ""){
                cout << "Titulo do livro: " << l.getTitulo() << endl;
                cout << "ISBN do livro: " << l.getISBN() << endl;
                cout << "Nome do autor do livro: " << l.getAutor().getNome() << endl;
                cout << "Data de nascimento do autor do livro: " << l.getAutor().getDataNascimento() << endl << endl;
            }

            break;
        case 3:
            b.mostrarLivros();
            break;
        case 0:
            cout << "Saindo..." << endl;
            break;
        default:
            cout << "Opcao invalida!" << endl;
            break;
        }
        cout << "---------------------------------------------------------" << endl;
    } while (escolha != 0);
}