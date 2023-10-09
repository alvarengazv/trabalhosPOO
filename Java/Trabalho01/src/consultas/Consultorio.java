package consultas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pessoas.Medico;
import pessoas.Paciente;

public class Consultorio {
	private List<Medico> medicos;
	private List<Paciente> paciente;
	private List<Consulta> consulta;
	private int contPaciente;
	private int telefone;
	private String endereco;
	private String nome;
	
	public Consultorio() {
		this.contPaciente = 0;
		this.medicos = new ArrayList<Medico>();
		this.paciente = new ArrayList<Paciente>();
		this.consulta = new ArrayList<Consulta>();
	}
	
	public Consultorio(int telefone, String endereco, String nome) {
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
	
	public void removerPaciente(String cpf) {
		int aux = 0;
		
		for(Paciente p : this.paciente) {
			if(p.getCpf().equals(cpf)) {
				aux++;
				this.paciente.remove(p);
				System.out.println("Paciente removido com sucesso!");
				break;
			}
		}
		
		if(aux != 1) {
			System.out.println("Não existe paciente registrado com o número indicado!");
		}
	}

	public void cadastrarMedico(Medico m) {
		this.medicos.add(m);
	}
	
	public void removerMedico(int crm) {
		int aux = 0;
		
		for(Medico m : this.medicos) {
			aux++;
			if(m.getCrm() == crm) {
				this.medicos.remove(m);
				System.out.println("Médico removido com sucesso!");
				break;
			}
		}
		if(aux != 1) {
			System.out.println("Não existe médico registrado com o número indicado!");
		}
	}
	
	public void cadastrarConsulta(Consulta c) {
		this.consulta.add(c);
	}
	
	public void removerConsulta(int numero) {
		int aux = 0;
		
		for(Consulta c : this.consulta) {
			if(c.getNumero() == numero) {
				aux++;
				this.consulta.remove(c);
				System.out.println("Consulta apagada com sucesso!");
				break;
			}
		}
		
		if(aux != 1) {
			System.out.println("Não existe consulta registrada com o número indicado!");
		}
	}
	
	public void imprimirListaPacientes() {
		if(this.paciente.size() > 0) {
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
		if(this.medicos.size() > 0) {
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

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
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
