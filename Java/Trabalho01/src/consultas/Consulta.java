package consultas;

public class Consulta {
	private String data;
	private String hora;
	private String cpfPaciente;
	private int crmMedico;
	private int numero;
	static int qtdConsultas = 0;
	
	public Consulta(String data, String hora, String cpfPaciente, int crmMedico) {
		super();
		this.data = data;
		this.hora = hora;
		this.cpfPaciente = cpfPaciente;
		this.crmMedico = crmMedico;
		this.numero = ++qtdConsultas;
	}

	public Consulta() {
		super();
		this.numero = ++qtdConsultas;
	}

	public void imprimir() {
		System.out.println("Número da Consulta: " + this.numero);
		System.out.println("Data: " + this.data);
		System.out.println("Hora: " + this.hora);
		System.out.println("CPF Paciente: " + this.cpfPaciente);
		System.out.println("CRM Médico: " + this.crmMedico);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public int getCrmMedico() {
		return crmMedico;
	}

	public void setCrmMedico(int crmMedico) {
		this.crmMedico = crmMedico;
	}
	
	public int getNumero() {
		return this.numero;
	}

}