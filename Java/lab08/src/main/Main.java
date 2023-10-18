package main;

import contas.ContaCorrenteComum;
import contas.ContaCorrentePremium;
import contas.ContaInvestimento;
import contas.ContaPoupanca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static List<ContaCorrenteComum> contasCadastradas = new ArrayList<>();
    public static ContaCorrenteComum c1 = new ContaCorrenteComum("Guilherme", 15000);
    public static ContaCorrentePremium c2 = new ContaCorrentePremium("Pedro", 15000, 1500);
    public static ContaPoupanca c3 = new ContaPoupanca("João", 15000, new Date());
    public static ContaInvestimento c4 = new ContaInvestimento("Paulo", 15000, 0.52);

    public static void main(String[] args) {
        contasCadastradas.add(c1);
        contasCadastradas.add(c2);
        contasCadastradas.add(c3);
        contasCadastradas.add(c4);

        try {
            menuInicial();
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            sc.close();
        }
    }

    public static void menuInicial() throws ParseException {
        int escolha;

        do {
            System.out.println("------------------Escolha uma opção------------------");
            System.out.println("1 - Cadastrar uma Conta Corrrente Comum;");
            System.out.println("2 - Cadastrar uma Conta Corrrente Premium;");
            System.out.println("3 - Cadastrar uma Conta Poupança;");
            System.out.println("4 - Cadastrar uma Conta de Investimento");
            System.out.println("5 - Imprimir Contas Cadastradas;");
            System.out.println("6 - Gerenciar Conta;");
            System.out.println("7 - Sair;");
            System.out.println("----------------------------------------------------");

            escolha = sc.nextInt();
            sc.nextLine();

            switch(escolha){
                case 1:{
                    System.out.println("----------Cadastrando Conta Corrente Comum----------");
                    contasCadastradas.add(cadastrarCCC());
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 2:{
                    System.out.println("----------Cadastrando Conta Corrente Premium----------");
                    contasCadastradas.add(cadastrarCCP());
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 3:{
                    System.out.println("----------Cadastrando Conta Poupança----------");
                    try {
                        contasCadastradas.add(cadastrarCP());
                    } catch (ParseException e) {
                        System.err.println(e.getMessage());
                        throw new RuntimeException(e);
                    }
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 4:{
                    System.out.println("----------Cadastrando Conta de Investimento----------");
                    contasCadastradas.add(cadastrarCI());
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 5:{
                    System.out.println("-------------Imprimindo Contas Cadastradas------------");
                    imprimirContas();
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 6:{
                    System.out.println("-----------------Gerenciar uma conta------------------");
                    encontrarConta();
                    break;
                }
                case 7:{
                    System.out.println("------------------Saindo do Programa------------------");
                    break;
                }
                default:{
                    System.out.println("----------Caso inválido----------");
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("---------------------------------");
                    sc.nextLine();
                    break;
                }
            }
        } while (escolha != 7);
    }

    public static ContaCorrenteComum cadastrarCCC(){
        System.out.println("Nome do titular: ");
        String nome = sc.nextLine();

        double saldoInicial;

        do {
            System.out.println("Saldo Inicial: ");
            saldoInicial = sc.nextDouble();
            sc.nextLine();

            if(saldoInicial < 0){
                System.out.println("O saldo inicial não pode ser negativo!");
            }
        } while (saldoInicial < 0);

        return new ContaCorrenteComum(nome, saldoInicial);
    }

    public static ContaCorrentePremium cadastrarCCP(){
        ContaCorrenteComum c = cadastrarCCC();
        ContaCorrenteComum.contConta--;

        double limite;
        do {
            System.out.println("Limite de Crédito: ");
            limite = sc.nextDouble();
            sc.nextLine();

            if(limite < 0){
                System.out.println("O limite não pode ser negativo!");
            }
        } while (limite < 0);

        return new ContaCorrentePremium(c.getNomeTitular(), c.getSaldo(), limite);
    }

    public static ContaPoupanca cadastrarCP() throws ParseException {
        ContaCorrenteComum c = cadastrarCCC();
        ContaCorrenteComum.contConta--;
        Date data;

        while (true){

            try {
                System.out.println("Data de aniversário para creditar (dd/MM): ");
                String dataString = sc.nextLine();

                DateFormat sdf = new SimpleDateFormat("dd/MM");
                sdf.setLenient(false);
                data = sdf.parse(dataString);

                System.out.println("Data de aniversário alterada com sucesso!");
                break;
            } catch (ParseException e) {
                System.out.println("Formato de data inválido!");
            }
        }
        return new ContaPoupanca(c.getNomeTitular(), c.getSaldo(), data);
    }

    public static ContaInvestimento cadastrarCI(){
        ContaCorrenteComum c = cadastrarCCC();
        ContaCorrenteComum.contConta--;

        double taxaRetorno;

        do {
            System.out.println("Taxa de Retorno Anual: ");
            taxaRetorno = sc.nextDouble();
            sc.nextLine();

            if(taxaRetorno < 0 || taxaRetorno > 1){
                System.out.println("A taxa de retorno deve ser >= 0 e <= 1 !");
            }
        } while (taxaRetorno < 0 || taxaRetorno > 1);

        return new ContaInvestimento(c.getNomeTitular(), c.getSaldo(), taxaRetorno);
    }

    public static void imprimirContas(){
        System.out.println("Contas cadastradas:");
        int n = 0;

        for(ContaCorrenteComum c : contasCadastradas){
            if (n > 0) {
                System.out.println("APERTE ENTER PARA VER A PRÓXIMA CONTA");
                System.out.println("--------------------------------------------------");
                sc.nextLine();
            }
            c.imprimirExtrato();
            n++;
        }
    }

    public static void encontrarConta(){
        System.out.println("Número da conta:");
        int numero = sc.nextInt();
        sc.nextLine();
        boolean existe = false;

        for (ContaCorrenteComum c : contasCadastradas){
            if(c.getNumeroConta() == numero){
                menuConta(c);
                existe = true;
                break;
            }
        }

        if (!existe) {
            System.out.println("Conta não encontrada!");
        }
    }

    public static void menuConta(ContaCorrenteComum conta){
        int escolha;

        do {
            System.out.println("------------------Escolha uma opção------------------");
            if(conta.getClass() != ContaCorrenteComum.class) {
                System.out.println("Operação de Conta de Investimento (GERÊNCIA):");
                if (conta.getClass() == ContaPoupanca.class) {
                    System.out.println("0 - Alterar data de aniversário;");
                    System.out.println("----------------------------------------------------");
                } else if (conta.getClass() == ContaCorrentePremium.class) {
                    System.out.println("0 - Alterar limite de crédito;");
                    System.out.println("----------------------------------------------------");
                } else if (conta.getClass() == ContaInvestimento.class) {
                    System.out.println("0 - Alterar taxa de retorno anual;");
                    System.out.println("----------------------------------------------------");
                }
            }
            System.out.println("1 - Depositar;");
            System.out.println("2 - Sacar;");
            System.out.println("3 - Imprimir extrato;");
            System.out.println("4 - Sair da conta;");
            System.out.println("----------------------------------------------------");

            escolha = sc.nextInt();
            sc.nextLine();

            switch(escolha){
                case 0:{
                    System.out.println("---------------------Alterando Informações----------------------");
                    alterarInformacoes(conta);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 1:{
                    System.out.println("---------------------Depositando----------------------");
                    System.out.println("Qual o valor a ser depositado:");
                    conta.deposito(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 2:{
                    System.out.println("-----------------------Sacando------------------------");
                    System.out.println("Qual o valor a ser sacado:");
                    conta.saque(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 3:{
                    System.out.println("------------------Imprimindo Extrato------------------");
                    conta.imprimirExtrato();
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 4:{
                    System.out.println("--------------------Saindo da Conta--------------------");
                    break;
                }
                default:{
                    System.out.println("--------------------Caso inválido---------------------");
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------------");
                    sc.nextLine();
                    break;
                }
            }
        } while (escolha != 4);
    }

    public static void alterarInformacoes(ContaCorrenteComum conta){
        if(conta.getClass() == ContaPoupanca.class){
            while (true){
                try {
                    System.out.println("Nova data de aniversário (dd/MM): ");
                    String dataString = sc.nextLine();

                    DateFormat sdf = new SimpleDateFormat("dd/MM");
                    sdf.setLenient(false);
                    Date data;
                    data = sdf.parse(dataString);

                    ((ContaPoupanca) conta).setDataCredito(data);
                    System.out.println("Data de aniversário alterada com sucesso!");
                    break;
                } catch (ParseException e) {
                    System.out.println("Formato de data inválido!");
                    continue;
                }
            }
        } else if(conta.getClass() == ContaCorrentePremium.class){
            double novoLimite, valor;
            do {
                System.out.println("Novo limite de crédito:");
                novoLimite = sc.nextDouble();
                sc.nextLine();

                if(novoLimite < 0){
                    System.out.println("O limite não pode ser negativo!");
                }

                valor = novoLimite + conta.getSaldo();

                if (valor < 0) {
                    System.out.println("Você não pode diminuir o limite enquanto não pagar a dívida!");
                }

                if (novoLimite == ((ContaCorrentePremium) conta).getLimiteCredito()) {
                    System.out.println("Esse já é o valor do limite da conta!");
                }
            } while (novoLimite < 0 || valor < 0 || novoLimite == ((ContaCorrentePremium) conta).getLimiteCredito());

            System.out.println("Limite de crédito alterada com sucesso!");
            ((ContaCorrentePremium) conta).setLimiteCredito(novoLimite);
        } else if(conta.getClass() == ContaInvestimento.class){
            double novaTaxa;

            do {
                System.out.println("Nova taxa de retorno anual:");
                novaTaxa = sc.nextDouble();
                sc.nextLine();

                if(novaTaxa < 0 || novaTaxa > 1){
                    System.out.println("A taxa de retorno deve ser >= 0 e <= 1 !");
                }
            } while (novaTaxa < 0 || novaTaxa > 1);

            System.out.println("Taxa de retorno alterada com sucesso!");
            ((ContaInvestimento) conta).setTaxaRetornoAnual(novaTaxa);
        }
    }
}
