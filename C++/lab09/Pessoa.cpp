#include "Pessoa.hpp"

using namespace std;

Pessoa::Pessoa() {}

Pessoa::Pessoa(string nome, string cpf) {
    this->nome = nome;
    this->cpf = cpf;
}

string Pessoa::getNome() {
    return this->nome;
}

void Pessoa::setNome(string nome) {
    this->nome = nome;
}

string Pessoa::getCpf() {
    return this->cpf;
}

void Pessoa::setCpf(string cpf) {
    this->cpf = cpf;
}