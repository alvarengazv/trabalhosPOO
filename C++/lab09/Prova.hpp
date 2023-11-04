#ifndef PROVA_HPP
#define PROVA_HPP

#include <iostream>
#include <string>
#include "Prova.hpp"
#include "Aluno.hpp"

using namespace std;
class Prova{
   private:
    string disciplina;
    string codigoDaProva;
    float nota;
    Aluno aluno;
    static int contProvas;
    Prova* abaixo;

   public:
    Prova();
    Prova(string disciplina, float nota, Aluno aluno);

    string getDisciplina();
    void setDisciplina(string disciplina);
    string getCodigoDaProva();
    void setCodigoDaProva(string codigoDaProva);
    float getNota();
    void setNota(float nota);
    Aluno getAluno();
    void setAluno(Aluno aluno);
    Prova* getAbaixo();
    void setAbaixo(Prova* p);
    void imprimeProva();

};

#endif