#include "Aluno.hpp"
#include "Pessoa.hpp"

using namespace std;

int Aluno::contAlunos=0;

Aluno::Aluno() {
    this->contAlunos++;
    this->numeroMatricula = this->contAlunos;
}

Aluno::Aluno(string curso, string nome, string cpf): Pessoa(nome, cpf) {
    this->curso = curso;

    this->contAlunos++;

    this->numeroMatricula = this->contAlunos;
}

int Aluno::getNumeroMatricula() {
    return this->numeroMatricula;
}

string Aluno::getCurso() {
    return this->curso;
}

void Aluno::setCurso(string curso) {
    this->curso = curso;
}

void Aluno::imprimeDados() {
    cout << "Nome: " << this->getNome() << endl;
    cout << "CPF: " << this->getCpf() << endl;
    cout << "Curso: " << this->getCurso() << endl;
    cout << "Número de matrícula: " << this->getNumeroMatricula() << endl;
}
