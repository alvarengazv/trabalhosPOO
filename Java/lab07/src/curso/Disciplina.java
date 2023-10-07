package curso;

import pessoas.Aluno;
import pessoas.Professor;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private int CH;
    private Professor professor;
    final private List<Aluno> listaAlunos;

    public Disciplina() {
        super();
        this.listaAlunos = new ArrayList<>();
    }

    public Disciplina(String nome, int CH, Professor professor) {
        this.nome = nome;
        this.CH = CH;
        this.professor = professor;
        this.listaAlunos = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno a){
        this.listaAlunos.add(a);
    }

    public void removerAluno(Aluno a){
        this.listaAlunos.remove(a);
    }

    public void imprimir(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Carga Horária: " + this.CH);
        System.out.println("Professor: " + this.professor.getNome());

        System.out.println("Alunos: ");
        if(!this.listaAlunos.isEmpty()){
            for(Aluno a : this.listaAlunos){
                System.out.println(a.getNome());
            }
        } else {
            System.out.println("Essa Disciplina ainda não possui alunos!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCH() {
        return CH;
    }

    public void setCH(int CH) {
        this.CH = CH;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
}
