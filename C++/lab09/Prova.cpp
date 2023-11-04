#include "Prova.hpp"

using namespace std;

int Prova::contProvas=0;

Prova::Prova() {
    this->contProvas++;
    this->codigoDaProva = to_string(contProvas);
}

Prova::Prova(string disciplina, float nota, Aluno aluno) {
    this->disciplina = disciplina;
    this->contProvas++;
    this->codigoDaProva = to_string(contProvas);
    this->nota = nota;
    this->aluno = aluno;
}

string Prova::getDisciplina() {
    return this->disciplina;
}

void Prova::setDisciplina(string disciplina) {
    this->disciplina = disciplina;
}

string Prova::getCodigoDaProva() {
    return this->codigoDaProva;
}

void Prova::setCodigoDaProva(string codigoDaProva) {
    this->codigoDaProva = codigoDaProva;
}

float Prova::getNota() {
    return this->nota;
}

void Prova::setNota(float nota) {
    this->nota = nota;
}

Aluno Prova::getAluno() {
    return this->aluno;
}

void Prova::setAluno(Aluno aluno) {
    this->aluno = aluno;
}

Prova* Prova::getAbaixo() {
    return this->abaixo;
}

void Prova::setAbaixo(Prova* p) {
    this->abaixo = p;
}

void Prova::imprimeProva() {
    cout << "Disciplina: " << this->disciplina << endl;
    cout << "Codigo da prova: " << this->codigoDaProva << endl;
    cout << "Nota: " << this->nota << endl;
    cout << "Aluno: " << endl;
    this->aluno.imprimeDados();
    cout << endl;
}
