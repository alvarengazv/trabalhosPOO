package pessoas;

public class Paciente extends Pessoa {
	private String relato;
	private String medicacaoConsumidaRegularmente;

	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("Relato: " + this.relato);
		System.out.println("Medicação: " + this.medicacaoConsumidaRegularmente);
	}

	public Paciente(String nome, char sexo, String endereco, String cpf, String telefone, int identidade, String relato,
			String medicacaoConsumidaRegularmente) {
		super(nome, sexo, endereco, cpf, telefone, identidade);
		this.relato = relato;
		this.medicacaoConsumidaRegularmente = medicacaoConsumidaRegularmente;
	}

	public Paciente(String nome, char sexo, String endereco, String cpf, String telefone, int identidade) {
		super(nome, sexo, endereco, cpf, telefone, identidade);
	}
	
	public Paciente() {
		super();
	}
	

	
	public String getRelato() {
		return relato;
	}

	public void setRelato(String relato) {
		this.relato = relato;
	}

	public String getMedicacaoConsumidaRegularmente() {
		return medicacaoConsumidaRegularmente;
	}

	public void setMedicacaoConsumidaRegularmente(String medicacaoConsumidaRegularmente) {
		this.medicacaoConsumidaRegularmente = medicacaoConsumidaRegularmente;
	}

}
