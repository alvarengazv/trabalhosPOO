package pessoas;

import curso.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private int matricula;
    final private List<Disciplina> listaDisciplinas;

    public Aluno() {
        super();
        this.listaDisciplinas = new ArrayList<>();
    }

    public Aluno(String nome, String endereco, int matricula) {
        super(nome, endereco);
        this.matricula = matricula;
        this.listaDisciplinas = new ArrayList<>();
    }

    public Aluno(String nome, String endereco) {
        super(nome, endereco);
        this.listaDisciplinas = new ArrayList<>();
    }

    public void matricular(Disciplina d){
        this.listaDisciplinas.add(d);
    }

    public void desfazerMatricula(Disciplina d){
        this.listaDisciplinas.remove(d);
    }
    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("Número de Matrícula: " + this.matricula);
        System.out.println("Disciplinas em que está matriculado: ");
        if(!this.listaDisciplinas.isEmpty()){
            for(Disciplina d : this.listaDisciplinas){
                System.out.println(d.getNome());
            }
        } else {
            System.out.println("Este aluno não está matriculado em nenhuma disciplina!");
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }
}
