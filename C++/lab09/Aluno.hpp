#ifndef ALUNO_HPP
#define ALUNO_HPP

#include <iostream>
#include <string>
#include "Aluno.hpp"
#include "Pessoa.hpp"

using namespace std;
class Aluno: public Pessoa {
   private:
    int numeroMatricula;
    string curso;
    static int contAlunos;

   public:
    Aluno();
    Aluno(string curso, string nome, string cpf);
    
    int getNumeroMatricula();
    string getCurso();
    void setCurso(string curso);
    void imprimeDados();
};

#endif