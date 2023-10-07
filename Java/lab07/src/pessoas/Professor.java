package pessoas;

import curso.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    private String curso;
    private String titulacao;
    final private List<Disciplina> disciplinas;

    public Professor() {
        super();
        this.disciplinas = new ArrayList<>();
    }

    public Professor(String nome, String endereco, String curso, String titulacao) {
        super(nome, endereco);
        this.curso = curso;
        this.titulacao = titulacao;
        this.disciplinas = new ArrayList<>();
    }

    public Professor(String nome, String endereco) {
        super(nome, endereco);
        this.disciplinas = new ArrayList<>();
    }

    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("Titulação: " + this.titulacao);
        System.out.println("Curso: " + this.curso);
        System.out.println("Disciplinas: ");
        if(!this.disciplinas.isEmpty()){
            for(Disciplina d : this.disciplinas){
                System.out.println(d.getNome());
            }
        } else {
            System.out.println("Este professor ainda não leciona nenhuma disciplina!");
        }
    }

    public void adicionarDisciplina(Disciplina d){
        this.disciplinas.add(d);
    }

    public void removerDisciplina(Disciplina d){
        this.disciplinas.remove(d);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}
