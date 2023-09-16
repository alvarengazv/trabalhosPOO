#include <iostream>
#include <string>

#include "Classes/Documento.hpp"
#include "Classes/FilaDeImpressao.hpp"

using namespace std;

int main() {
    int escolha;

    do {
        cout
            << endl
            << "Escolha uma opcao do menu (1 = CONSULTAR DOCUMENTO, "
               "2 = NUMERO DE PAGINAS, 3 = PRIORIDADE, -1 = SAIR): ";
        cin >> escolha;

        // switch (escolha) {
        //     case 1: {
        //         cout << endl << "Digite o novo nome do documento: ";
        //         cin >> dadoString;
        //         pAlterado->setNomeArquivo(dadoString);

        //         cout << "Nome do documento " << pAlterado->getId()
        //              << "alterado!" << endl;
        //         break;
        //     }
        //     case 2: {
        //         cout << endl
        //              << "Digite o novo numero de paginas do documento: ";
        //         cin >> dadoInt;
        //         pAlterado->setNumPaginas(dadoInt);

        //         cout << "Numero de paginas do documento " << pAlterado->getId()
        //              << "alterado!" << endl;
        //         break;
        //     }
        //     case 3: {
        //         this->maiorPrioridade();
        //         cout << endl << "Digite a nova prioridade do documento: ";
        //         cin >> dadoInt;
        //         pAlterado->setPrioridade(dadoInt);

        //         cout << "Prioridade do documento " << pAlterado->getId()
        //              << "alterado!" << endl;
        //         break;
        //     }
        //     case -1: {
        //         printf("\nSaindo da edicao de cadastro...");
        //         break;
        //     }
        //     default: {
        //         printf("\nCaso invalido!");
        //         break;
        //     }
        // }

    } while (escolha != -1);
}