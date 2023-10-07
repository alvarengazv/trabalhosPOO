package curso;

import pessoas.Aluno;
import pessoas.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {
    private String nome;
    final private List<Professor> listaProfessores;
    final private List<Aluno> listaAlunos;
    final private List<Disciplina> listaDisciplinas;
    private int qtdAlunos;

    public Curso() {
        this.listaProfessores = new ArrayList<>();
        this.listaAlunos = new ArrayList<>();
        this.listaDisciplinas = new ArrayList<>();
        this.qtdAlunos = 0;
    }

    public Curso(String nome) {
        this.nome = nome;
        this.listaProfessores = new ArrayList<>();
        this.listaAlunos = new ArrayList<>();
        this.listaDisciplinas = new ArrayList<>();
        this.qtdAlunos = 0;
    }

    public void cadastrarProfessor(Professor p){
        this.listaProfessores.add(p);
    }

    public void cadastrarAluno(Aluno a){
        this.listaAlunos.add(a);
        this.qtdAlunos++;
    }

    public void cadastrarDisciplina(Disciplina d){
        this.listaDisciplinas.add(d);
    }

    public void imprimirListaDeProfessor(Scanner sc){
        int n = 0;
        if(!this.listaProfessores.isEmpty()) {
            for (Professor p : this.listaProfessores) {
                if (n > 0) {
                    System.out.println("APERTE ENTER PARA VER O PRÓXIMO PROFESSOR DA LISTA");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                }
                System.out.println("Professor Número " + (++n));
                p.imprimir();
            }
        } else {
            System.out.println("Este curso ainda não possui professores cadastrados!");
        }
    }

    public void imprimirListaDeAluno(Scanner sc){
        int n = 0;
        if(!this.listaAlunos.isEmpty()) {
            for (Aluno a : this.listaAlunos) {
                if (n > 0) {
                    System.out.println("APERTE ENTER PARA VER O PRÓXIMO ALUNO DA LISTA");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                }
                System.out.println("Aluno Número " + (++n));
                a.imprimir();
            }
        } else {
            System.out.println("Este curso ainda não possui alunos cadastrados!");
        }
    }


    public void imprimirListaDeDisciplina(Scanner sc){
        int n = 0;
        if(!this.listaDisciplinas.isEmpty()) {
            for (Disciplina d : this.listaDisciplinas) {
                if (n > 0) {
                    System.out.println("APERTE ENTER PARA VER A PRÓXIMA DISCIPLINA DA LISTA");
                    System.out.println("--------------------------------------------------");
                    sc.nextLine();
                }
                System.out.println("Disciplina Número " + (++n));
                d.imprimir();
            }
        } else {
            System.out.println("Este curso ainda não possui disciplinas cadastradas!");
        }
    }

    public void removerProfessor(Professor p){
        List<Disciplina> remover = new ArrayList<>();
        for (Disciplina d: this.listaDisciplinas) {
            if(d.getProfessor().equals(p)){
                remover.add(d);
            }
        }

        remover.forEach(this::removerDisciplina);

        this.listaProfessores.remove(p);
        System.out.println("Professor removido com sucesso!");
    }

    public void removerAluno(Aluno a){
        for (Disciplina d: this.listaDisciplinas) {
            d.removerAluno(a);
        }
        this.listaAlunos.remove(a);
        System.out.println("Aluno removido com sucesso!");
    }

    public void removerDisciplina(Disciplina d){
        for (Professor p: this.listaProfessores) {
            p.removerDisciplina(d);
        }
        for (Aluno a: this.listaAlunos) {
            a.desfazerMatricula(d);
        }
        this.listaDisciplinas.remove(d);
        System.out.println("Disciplina removida com sucesso!");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }
}
