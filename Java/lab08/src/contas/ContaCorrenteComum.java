package contas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaCorrenteComum {
    protected int numeroConta;
    protected String nomeTitular;
    protected double saldo;
    protected List<Transacao> transacoes;
    public static int contConta;

    public ContaCorrenteComum() {
        super();
        this.numeroConta = ++contConta;
        this.transacoes = new ArrayList<Transacao>();
        this.saldo = 0;
    }

    public ContaCorrenteComum(String nomeTitular) {
        this.numeroConta = ++contConta;
        this.nomeTitular = nomeTitular;
        this.saldo = 0;
        this.transacoes = new ArrayList<Transacao>();
    }

    public ContaCorrenteComum(String nomeTitular, double saldo) {
        this.numeroConta = ++contConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.transacoes = new ArrayList<Transacao>();
    }

    public void deposito(double valor){
        if(valor > 0) {
            realizarTransacao("Depósito", valor);
            this.saldo += valor;
            System.out.println("Depósito realizado!");
        } else {
            System.out.println("Digite um valor maior que zero!");
        }
    }

    public void saque(double valor){
        if(valor > 0) {
            if (this.saldo >= valor) {
                realizarTransacao("Saque", -valor);
                this.saldo -= valor;
                System.out.println("Saque realizado!");
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Digite um valor maior que zero!");
        }
    }

    public void imprimirExtrato(){
        System.out.println("Número da conta: " + this.numeroConta);
        System.out.println("Nome do titular: " + this.nomeTitular);
        System.out.println("Saldo da conta: " + this.saldo);

        if(!this.transacoes.isEmpty()){
            System.out.println("Transações realizadas:");
            this.transacoes.sort((a, b) -> b.getData().compareTo(a.getData()));
            for (Transacao t: this.transacoes) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
                String formattedDate = formatter.format(t.getData());

                System.out.println("Data: " + formattedDate);
                System.out.println("Descrição: " + t.getDescricao());
                System.out.println("Valor da transação: " + t.getValor());
            }
        } else {
            System.out.println("Extrato vazio!");
        }
    }

    public void realizarTransacao(String descricao, double valor){
        Transacao transacao = new Transacao(valor, new Date(),descricao);

        this.transacoes.add(transacao);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
