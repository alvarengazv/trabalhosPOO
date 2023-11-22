package consultas;

import pessoas.Medico;
import pessoas.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Excecoes.ExcecaoConsultaInexistente;
import Excecoes.ExcecaoMedicoInexistente;
import Excecoes.ExcecaoPacienteInexistente;

public class Consultorio {
	public static int maxPacientes = 100;
	public static int maxConsultas = 100;
	public static int maxMedicos = 5;


	private List<Medico> medicos;
	private List<Paciente> paciente;
	private List<Consulta> consulta;
	private int contPaciente;
	private String telefone;
	private String endereco;
	private String nome;
	
	public Consultorio() {
		this.contPaciente = 0;
		this.medicos = new ArrayList<Medico>();
		this.paciente = new ArrayList<Paciente>();
		this.consulta = new ArrayList<Consulta>();
	}
	
	public Consultorio(String telefone, String endereco, String nome) {
		super();
		this.contPaciente = 0;
		this.telefone = telefone;
		this.endereco = endereco;
		this.nome = nome;
		this.medicos = new ArrayList<Medico>();
		this.paciente = new ArrayList<Paciente>();
		this.consulta = new ArrayList<Consulta>();
	}
	
	public void cadastrarPaciente(Paciente p) {
		this.paciente.add(p);
		this.contPaciente++;
	}
	
	public void removerPaciente(String cpf) throws ExcecaoPacienteInexistente {
		if(!this.paciente.removeIf(p -> p.getCpf().equals(cpf)))
			throw new ExcecaoPacienteInexistente();
	}

	public void cadastrarMedico(Medico m) {
		this.medicos.add(m);
	}
	
	public void removerMedico(int crm) throws ExcecaoMedicoInexistente {
		if(!this.medicos.removeIf(m -> m.getCrm() == crm))
			throw new ExcecaoMedicoInexistente();
	}
	
	public void cadastrarConsulta(Consulta c) {
		if(verificarDisponibilidade(c.getData(), c.getHora(), c.getCrmMedico())) {
			this.consulta.add(c);
			System.out.println("Consulta cadastrada com sucesso!");
		} else {
			System.out.println("Horário indisponível!");
		}
	}

	public boolean verificarDisponibilidade(String data, String hora, int crm) {
		for(Consulta c : consulta) {
			if(c.getData().equals(data) && c.getHora().equals(hora) && c.getCrmMedico() == crm) {
				return false;
			}
		}
		return true;
	}
	
	public void removerConsulta(String cpf, String data) throws ExcecaoConsultaInexistente {
		if(!this.consulta.removeIf(c -> c.getCpfPaciente().equals(cpf) && c.getData().equals(data)))
			throw new ExcecaoConsultaInexistente(cpf, data);
	}
	
	public void imprimirListaPacientes() {
		if(!this.paciente.isEmpty()) {
			int n = 0;
			for(Paciente p: this.paciente){
				System.out.println("Paciente " + (++n));
				p.imprimir();
			}
		} else {
			System.out.println("Lista de Pacientes vazia!");
		}
	}
	
	public void imprimirListaMedicos() {
		if(!this.medicos.isEmpty()) {
			int n = 0;
			for(Medico m: this.medicos){
				System.out.println("Médico " + (++n));
				m.imprimir();
			}
		} else {
			System.out.println("Lista de Médicos vazia!");
		}
	}
	
	public void imprimirListaConsultas(Scanner sc) {		
		if(!this.consulta.isEmpty()) {
			int n = 0;
			for(Consulta c: this.consulta){
				if(n != 0) {
					System.out.println("APERTE ENTER PARA VER A PRÓXIMA CONSULTA");
					System.out.println("--------------------------------------");
					sc.nextLine();
				}
				System.out.println("Consulta " + (++n));
				c.imprimir();
			}
		} else {
			System.out.println("Lista de Consultas vazia!");
		}
	}
	
	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}

	public int getContPaciente() {
		return contPaciente;
	}

	public void setContPaciente(int contPaciente) {
		this.contPaciente = contPaciente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
