package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pessoas.*;
import curso.*;

public class Main {
    static List<Curso> cursos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String nomeCurso = "Engenharia de Computação";
        Curso curso = new Curso(nomeCurso);

        cursos.add(curso);

        int escolhaMenu1;

        do {
            System.out.println("-----------------Escolha uma opção-----------------");
            System.out.println("0 - Cadastrar um Curso;");
            System.out.println("1 - Gerenciar um Curso;");
            System.out.println("2 - Sair do Programa;");
            System.out.println("---------------------------------------------------");
            escolhaMenu1 = sc.nextInt();
            sc.nextLine();

            switch (escolhaMenu1){
                case 0: {
                    cadastrarCurso();
                    break;
                }
                case 1: {
                    Curso c = listarCursos();
                    if(c.getNome() != null){
                        menuGerenciamento(c);
                    } else {
                        System.out.println("Retornando ao menu inicial.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("-----------------Saindo do Programa-----------------");
                    break;
                }
                default: {
                    System.out.println("-----------------Opção Inválida-----------------");
                    break;
                }
            }

        }while(escolhaMenu1 != 2);
        sc.close();
    }

    public static Curso listarCursos(){
        int n = 0;

        System.out.println("Digite o número do curso caso queira gerenciá-lo ou digite outro para continuar:");
        for(Curso c : cursos){
            System.out.println("Curso Número " + (++n));
            System.out.println("Nome: " + c.getNome());

            if(sc.nextInt() == n){
                return c;
            }
            sc.nextLine();
        }
        return new Curso();
    }

    public static void menuGerenciamento(Curso c){
        int escolhaMenu2;

        do {
            System.out.println("-----------------Escolha uma opção-----------------");
            System.out.println("1 - Cadastrar um Professor;");
            System.out.println("2 - Cadastrar um Aluno;");
            System.out.println("3 - Cadastrar uma Disciplina;");
            System.out.println("4 - Imprimir Dados de um Professor;");
            System.out.println("5 - Imprimir Dados de um Aluno;");
            System.out.println("6 - Imprimir Dados de uma Disciplina;");
            System.out.println("7 - Imprimir Professores do Curso;");
            System.out.println("8 - Imprimir Alunos do Curso;");
            System.out.println("9 - Imprimir Disciplinas do Curso;");
            System.out.println("10 - Matricular um Aluno em uma Disciplina;");
            System.out.println("11 - Remover um Professor do Curso;");
            System.out.println("12 - Remover um Aluno do Curso;");
            System.out.println("13 - Remover uma Disciplina do Curso;");
            System.out.println("14 - Sair do Curso '" + c.getNome() + "';");
            System.out.println("--------------------------------------------------");

            escolhaMenu2 = sc.nextInt();
            sc.nextLine();

            switch (escolhaMenu2) {
                case 1: {
                    System.out.println("---------------Cadastrando Professor---------------");
                    cadastrarProfessor(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 2: {
                    System.out.println("-----------------Cadastrando Aluno-----------------");
                    cadastrarAluno(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 3: {
                    System.out.println("--------------Cadastrando Disciplina--------------");
                    cadastrarDisciplina(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 4: {
                    System.out.println("----------Imprimindo Dados de um Professor--------");
                    imprimirDadosDeUmProfessor(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 5: {
                    System.out.println("----------Imprimindo Dados de um Aluno----------");
                    imprimirDadosDeUmAluno(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 6: {
                    System.out.println("--------Imprimindo Dados de uma Disciplina--------");
                    imprimirDadosDeUmaDisciplina(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 7: {
                    System.out.println("----------Imprimindo Lista de Professores---------");
                    c.imprimirListaDeProfessor(sc);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 8: {
                    System.out.println("------------Imprimindo Lista de Alunos------------");
                    c.imprimirListaDeAluno(sc);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 9: {
                    System.out.println("----------Imprimindo Lista de Disciplinas---------");
                    c.imprimirListaDeDisciplina(sc);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 10: {
                    System.out.println("---------------Matriculando Aluno----------------");
                    matricularAluno(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 11: {
                    System.out.println("---------------Removendo Professor----------------");
                    removerProfessor(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 12: {
                    System.out.println("-----------------Removendo Aluno------------------");
                    removerAluno(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 13: {
                    System.out.println("---------------Removendo Disciplina----------------");
                    removerDisciplina(c);
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
                case 14: {
                    System.out.println("----------------Saindo do Gerenciamento do Curso----------------");
                    break;
                }
                default: {
                    System.out.println("------------------Caso inválido-------------------");
                    System.out.println("APERTE ENTER PARA CONTINUAR");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                    break;
                }
            }
        } while (escolhaMenu2 != 14);
    }

    public static void cadastrarCurso(){
        Curso c = new Curso();
        System.out.println("Qual o nome do curso a ser criado:");
        c.setNome(sc.nextLine());

        cursos.add(c);
        System.out.println("Curso cadastrado com sucesso!");
    }

    public static Pessoa cadastrarPessoa() {
        Pessoa p = new Pessoa();
        System.out.println("Nome: ");
        p.setNome(sc.nextLine());

        System.out.println("Endereço: ");
        p.setEndereco(sc.nextLine());

        return p;
    }

    public static void cadastrarProfessor(Curso c) {
        Pessoa pe = cadastrarPessoa();
        Professor pr = new Professor(pe.getNome(), pe.getEndereco());

        System.out.println("Titulação: ");
        pr.setTitulacao(sc.nextLine());

        pr.setCurso(c.getNome());

        c.cadastrarProfessor(pr);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public static void cadastrarAluno(Curso c) {
        Pessoa pe = cadastrarPessoa();
        Aluno a = new Aluno(pe.getNome(), pe.getEndereco());

        a.setMatricula(c.getQtdAlunos() + 1);

        c.cadastrarAluno(a);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void cadastrarDisciplina(Curso c) {
        if(!c.getListaProfessores().isEmpty()) {
            Disciplina d = new Disciplina();

            System.out.println("Nome: ");
            d.setNome(sc.nextLine());

            System.out.println("Carga Horária: ");
            d.setCH(sc.nextInt());
            sc.nextLine();

            boolean existe = false;
            do {
                System.out.println("Qual o nome do professor: ");
                String nome = sc.nextLine();

                for(Professor p : c.getListaProfessores()) {
                    if(p.getNome().equals(nome)) {
                        d.setProfessor(p);
                        p.adicionarDisciplina(d);
                        existe = true;
                    }
                }

                if(!existe) {
                    System.out.println("Não há professores registrados com esse nome!");
                }
            }while(!existe);

            c.cadastrarDisciplina(d);
            System.out.println("Disciplina cadastrada com sucesso!");
        } else {
            System.out.println("Não é possível criar uma disciplina pois não há professores cadastrados nesse curso!");
        }
    }

    public static void imprimirDadosDeUmProfessor(Curso c) {
        if(!c.getListaProfessores().isEmpty()) {
            System.out.println("Digite o nome do Professor que você deseja ver as informações: ");
            String nome = sc.nextLine();

            Professor p = encontrarProfessor(c, nome);
            if(p.getNome() != null)
                p.imprimir();
        } else {
            System.out.println("Não há professores registrados!");
        }
    }

    public static void imprimirDadosDeUmAluno(Curso c) {
        if(!c.getListaAlunos().isEmpty()) {
            System.out.println("Digite a matrícula do Aluno que você deseja ver as informações: ");
            int matricula = sc.nextInt();
            sc.nextLine();

            Aluno a = encontrarAluno(c, matricula);
            if(a.getMatricula() != 0)
                a.imprimir();
        } else {
            System.out.println("Não há alunos registrados!");
        }
    }

    public static void imprimirDadosDeUmaDisciplina(Curso c) {
        if(!c.getListaDisciplinas().isEmpty()) {
            System.out.println("Digite o nome da Disciplina que você deseja ver as informações: ");
            String nome = sc.nextLine();

            Disciplina d = encontrarDisciplina(c, nome);
            if(d.getNome() != null)
                d.imprimir();
        } else {
            System.out.println("Não há disciplinas registradas!");
        }
    }

    public static Aluno encontrarAluno(Curso c, int matricula){
        for(Aluno aluno : c.getListaAlunos()) {
            if(aluno.getMatricula() == matricula) {
                System.out.println("Aluno encontrado: ");
                return aluno;
            }
        }

        System.out.println("Não existe aluno registrado com o número de matrícula indicado!");
        return new Aluno();
    }

    public static Professor encontrarProfessor(Curso c, String nome){
        for(Professor p : c.getListaProfessores()) {
            if(p.getNome().equals(nome)) {
                System.out.println("Professor encontrado: ");
                return p;
            }
        }

        System.out.println("Não existe professor registrado com o nome indicado!");
        return new Professor();
    }

    public static Disciplina encontrarDisciplina(Curso c, String nome){
        for(Disciplina d : c.getListaDisciplinas()) {
            if(d.getNome().equals(nome)) {
                System.out.println("Disciplina encontrada");
                return d;
            }
        }

        System.out.println("Não existe disciplina registrada com o nome indicado!");
        return new Disciplina();
    }

    public static void matricularAluno(Curso c) {
        if(!c.getListaAlunos().isEmpty()) {
            if(!c.getListaDisciplinas().isEmpty()) {
                System.out.println("Digite a matrícula do Aluno que você deseja matricular em alguma disciplina: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                Aluno a = encontrarAluno(c, matricula);
                if (a.getMatricula() != 0) {
                    System.out.println("Qual o nome da disciplina em que ele será matriculado: ");
                    String nomeDisciplina = sc.nextLine();

                    Disciplina d = encontrarDisciplina(c, nomeDisciplina);
                    if(!a.getListaDisciplinas().contains(d)) {
                        if (d.getNome() != null) {
                            a.matricular(d);
                            d.cadastrarAluno(a);
                            System.out.println("Aluno matriculado com sucesso!");
                        }
                    } else {
                        System.out.println("Este aluno já está matriculado nessa disciplina!");
                    }
                }
            } else {
                System.out.println("Não há disciplinas registradas!");
            }
        } else {
            System.out.println("Não há alunos registrados!");
        }
    }

    public static void removerProfessor(Curso c) {
        if(!c.getListaProfessores().isEmpty()) {
            System.out.println("Digite o nome do Professor que você deseja remover: ");
            String nome = sc.nextLine();

            System.out.println("Você está prestes a deletar todas as disciplinas vinculadas a este professor, tem certeza disso? (S ou N)");
            String resposta = sc.nextLine().toUpperCase();

            if(resposta.equals("S")){
                Professor p = encontrarProfessor(c, nome);
                if(p.getNome() != null){
                    c.removerProfessor(p);
                }
            } else {
                System.out.println("Saindo da remoção de professor");
            }
        } else {
            System.out.println("Não há Professores registrados!");
        }
    }

    public static void removerAluno(Curso c) {
        if(!c.getListaAlunos().isEmpty()) {
            System.out.println("Digite a matrícula do Aluno que você deseja remover: ");
            int matricula = sc.nextInt();
            sc.nextLine();

            Aluno a = encontrarAluno(c, matricula);
            if(a.getMatricula() != 0){
                c.removerAluno(a);
            }
        } else {
            System.out.println("Não há Alunos registrados!");
        }
    }

    public static void removerDisciplina(Curso c) {
        if(!c.getListaDisciplinas().isEmpty()) {
            System.out.println("Digite o nome da Disciplina que você deseja remover: ");
            String nome = sc.nextLine();

            Disciplina d = encontrarDisciplina(c, nome);
            if(d.getNome() != null)
                c.removerDisciplina(d);
        } else {
            System.out.println("Não há Disciplinas registradas!");
        }
    }
}
