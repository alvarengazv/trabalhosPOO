#include "ClienteBanco.hpp"

using namespace std;

int ClienteBanco::contClientesBanco=0;

ClienteBanco::ClienteBanco() {
    this->contClientesBanco++;
    this->numeroDaConta = to_string(contClientesBanco);
}

ClienteBanco::ClienteBanco(bool prioridade, string nome, string cpf, string agencia): Pessoa(nome, cpf) {
    this->prioridade = prioridade;
    this->agencia = agencia;
    this->prox = NULL;

    this->contClientesBanco++;

    this->numeroDaConta = to_string(contClientesBanco);

}

string ClienteBanco::getNumeroDaConta() {
    return this->numeroDaConta;
}

string ClienteBanco::getAgencia() {
    return this->agencia;
}

void ClienteBanco::setAgencia(string agencia) {
    this->agencia = agencia;
}

bool ClienteBanco::getPrioridade() {
    return this->prioridade;
}

void ClienteBanco::setPrioridade(bool prioridade) {
    this->prioridade = prioridade;
}

ClienteBanco* ClienteBanco::getProx() {
    return this->prox;
}

void ClienteBanco::setProx(ClienteBanco* p) {
    this->prox = p;
}