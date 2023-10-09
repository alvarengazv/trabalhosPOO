package pessoas;

public class Medico extends Pessoa {
	private int crm;
	private String especialidade;

	public Medico(String nome, char sexo, String endereco, String cpf, int telefone, int identidade, int crm,
			String especialidade) {
		super(nome, sexo, endereco, cpf, telefone, identidade);
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public Medico(String nome, char sexo, String endereco, String cpf, int telefone, int identidade) {
		super(nome, sexo, endereco, cpf, telefone, identidade);
	}
	
	public Medico() {
		super();
	}

	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("CRM: " + this.crm);
		System.out.println("Especialidade: " + this.especialidade);
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
