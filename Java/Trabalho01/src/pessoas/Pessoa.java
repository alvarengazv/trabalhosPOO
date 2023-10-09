package pessoas;

public class Pessoa {
	protected String nome;
	protected char sexo;
	protected String endereco;
	protected String cpf;
	protected int telefone;
	protected int identidade;
	
	public Pessoa(String nome, char sexo, String endereco, String cpf, int telefone, int identidade) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
		this.cpf = cpf;
		this.telefone = telefone;
		this.identidade = identidade;
	}
	
	public Pessoa() {
		super();
	}

	public void imprimir() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Sexo: " + this.sexo);
		System.out.println("Endereco: " + this.endereco);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Identidade: " + this.identidade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getIdentidade() {
		return identidade;
	}

	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}
}
