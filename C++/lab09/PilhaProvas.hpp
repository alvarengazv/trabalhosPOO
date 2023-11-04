#ifndef PilhaProvas_HPP
#define PilhaProvas_HPP

#include "Prova.hpp"
#include "Aluno.hpp"

#include <iostream>

using namespace std;

class PilhaProvas {
   private:
    Prova* topo;
    int qtdProvas;

   public:
    PilhaProvas();
    PilhaProvas(Prova *p);
    ~PilhaProvas();

    void *getTopo();
    void empilha(Prova *p);
    void *desempilha();
    bool estaVazia();
    void imprimePilha();
};
#endif
