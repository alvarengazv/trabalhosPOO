package pessoas;

public class Pessoa {
    private String nome;
    private String endereco;

    public Pessoa() {
        super();
    }

    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void imprimir(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Endereço: " + this.endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
