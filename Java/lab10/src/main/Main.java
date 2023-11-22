package main;

import consultas.Consulta;
import consultas.Consultorio;
import pessoas.Pessoa;
import pessoas.Medico;
import pessoas.Paciente;

import java.util.Scanner;

import Excecoes.ExcecaoSexoInvalido;

public class Main {
	final static String nomeConsultorio = "Ser Espaço Terapêutico";
	final static String telefoneConsultorio = "(37) 99988-5522";
	final static String enderecoConsultorio = "Rua Pernambuco 525";
	static Consultorio consultorio = new Consultorio(telefoneConsultorio, enderecoConsultorio, nomeConsultorio);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int escolha;
		
		do {
			System.out.println("----------Escolha uma opção----------");
			System.out.println("1 - Cadastrar um Médico;");
			System.out.println("2 - Cadastrar um Paciente;");
			System.out.println("3 - Cadastrar uma Consulta;");
			System.out.println("4 - Imprimir Dados de um Médico;");
			System.out.println("5 - Imprimir Consultas;");
			System.out.println("6 - Imprimir Dados do Paciente;");
			System.out.println("7 - Imprimir Consulta Específica;");
			System.out.println("8 - Remover um Médico;");
			System.out.println("9 - Remover um Paciente;");
			System.out.println("10 - Remover uma Consulta;");
			System.out.println("11 - Sair;");
			System.out.println("-------------------------------------");
			
			escolha = sc.nextInt();
			sc.nextLine();
			
			switch(escolha){
				case 1:{
					System.out.println("----------Cadastrando Médico----------");
					cadastrarMedico(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("--------------------------------------");
					sc.nextLine();
					break;
				}
				case 2:{
					System.out.println("----------Cadastrando Paciente----------");
					cadastrarPaciente(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("----------------------------------------");
					sc.nextLine();
					break;
				}
				case 3:{
					System.out.println("----------Cadastrando Consulta----------");
					cadastrarConsulta(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("----------------------------------------");
					sc.nextLine();
					break;
				}
				case 4:{
					System.out.println("----------Imprimindo Dados de Médico----------");
					imprimirDadosDeUmMedico(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("-----------------------------------------------");
					sc.nextLine();
					break;
				}
				case 5:{
					System.out.println("----------Imprimindo Lista de Consultas----------");
					consultorio.imprimirListaConsultas(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("-------------------------------------------------");
					sc.nextLine();
					break;
				}
				case 6:{
					System.out.println("----------Imprimindo Dados de Paciente----------");
					imprimirDadosDeUmPaciente(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("------------------------------------------------");
					sc.nextLine();
					break;
				}
				case 7:{
					System.out.println("----------Imprimindo Dados de Consulta----------");
					imprimirDadosDeUmaConsulta(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("------------------------------------------------");
					sc.nextLine();
					break;
				}
				case 8:{
					System.out.println("----------Removendo Médico----------");
					removerMedico(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("------------------------------------");
					sc.nextLine();
					break;
				}
				case 9:{
					System.out.println("----------Removendo Paciente----------");
					removerPaciente(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("--------------------------------------");
					sc.nextLine();
					break;
				}
				case 10:{
					System.out.println("----------Removendo Consulta----------");
					removerConsulta(sc);
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("--------------------------------------");
					sc.nextLine();
					break;
				}
				case 11:{
					System.out.println("----------Saindo do Programa----------");
					break;
				}
				default:{
					System.out.println("----------Caso inválido----------");
					System.out.println("APERTE ENTER PARA CONTINUAR");
					System.out.println("---------------------------------");
					sc.nextLine();
					break;
				}
			}
		} while (escolha != 11);
		sc.close();
	}
	
	public static Pessoa cadastrarPessoa(Scanner sc) {
		Pessoa p = new Pessoa();
		System.out.println("Nome: ");
		p.setNome(sc.nextLine());

		boolean verificado = false;
		char sexo;

		do {
			try {
				System.out.println("Sexo: ");
				sexo = sc.nextLine().charAt(0);
				p.setSexo(sexo);
				verificado = true;
			} catch (ExcecaoSexoInvalido e) {
				System.out.println(e.getMessage());
				verificado = false;
			}
		}while(!verificado);

		

		System.out.println("Endereço: ");
		p.setEndereco(sc.nextLine());

		boolean existe;
		String cpf;
		do{
			existe = false;
			System.out.println("CPF: ");
			cpf = sc.nextLine();

			for(Pessoa pessoa : consultorio.getPaciente()){
				if(pessoa.getCpf().equals(cpf)){
					existe = true;
					System.out.println("Já existe uma pessoa cadastrada com este CPF!");
					break;
				}
			}

			for(Pessoa pessoa : consultorio.getMedicos()){
				if(pessoa.getCpf().equals(cpf)){
					existe = true;
					System.out.println("Já existe uma pessoa cadastrada com este CPF!");
					break;
				}
			}

		}while(existe);

		p.setCpf(cpf);

		System.out.println("Telefone: ");
		p.setTelefone(sc.nextLine());

		int identidade;

		do{
			existe = false;
			System.out.println("Identidade: ");
			identidade = sc.nextInt();

			for(Pessoa pessoa : consultorio.getPaciente()){
				if(pessoa.getIdentidade() == identidade){
					existe = true;
					System.out.println("Já existe uma pessoa cadastrada com este número de Identidade!");
					break;
				}
			}

			for(Pessoa pessoa : consultorio.getMedicos()){
				if(pessoa.getIdentidade() == identidade){
					existe = true;
					System.out.println("Já existe uma pessoa cadastrada com este número de Identidade!");
					break;
				}
			}
		}while(existe);

		p.setIdentidade(identidade);


		
		return p;
	}
	
	public static void cadastrarMedico(Scanner sc) {
		if(consultorio.getMedicos().size() < Consultorio.maxMedicos) {
			Pessoa p = cadastrarPessoa(sc);
			Medico m = new Medico(p.getNome(), p.getSexo(), p.getEndereco(), p.getCpf(), p.getTelefone(), p.getIdentidade());

			boolean existe;
			int crm;

			do{
				existe = false;
				System.out.println("CRM: ");
				crm = sc.nextInt();
				sc.nextLine();

				for(Medico medico : consultorio.getMedicos()){
					if(medico.getCrm() == crm){
						existe = true;
						System.out.println("Já existe um médico cadastrado com este CRM!");
						break;
					}
				}
			}while(existe);

			m.setCrm(crm);

			System.out.println("Especialidade: ");
			m.setEspecialidade(sc.nextLine());
		
			consultorio.cadastrarMedico(m);
			System.out.println("Médico cadastrado com sucesso!");
		} else {
			System.out.println("Número máximo de médicos atingido!");
		}
	}
	
	public static void cadastrarPaciente(Scanner sc) {
		if(consultorio.getPaciente().size() < Consultorio.maxPacientes) {
			Pessoa pe = cadastrarPessoa(sc);
			Paciente pa = new Paciente(pe.getNome(), pe.getSexo(), pe.getEndereco(), pe.getCpf(), pe.getTelefone(), pe.getIdentidade());
			
			System.out.println("Relato do Paciente: ");
			pa.setRelato(sc.nextLine());
			sc.nextLine();

			System.out.println("Medicação Consumida Regularmente: ");
			pa.setMedicacaoConsumidaRegularmente(sc.nextLine());
			
			
			consultorio.cadastrarPaciente(pa);
			System.out.println("Paciente cadastrado com sucesso!");
		} else {
			System.out.println("Número máximo de pacientes atingido!");
		}
	}

	public static void cadastrarConsulta(Scanner sc) {
		if(!consultorio.getPaciente().isEmpty() && !consultorio.getMedicos().isEmpty()) {
			if(consultorio.getConsulta().size() < Consultorio.maxConsultas) {
				Consulta c = new Consulta();
				
				System.out.println("Data: ");
				c.setData(sc.nextLine());
				
				System.out.println("Hora: ");
				c.setHora(sc.nextLine());
				
				boolean existe = false;
				do {
					System.out.println("CPF do Paciente: ");
					String cpf = sc.nextLine();
					
					for(Paciente p : consultorio.getPaciente()) {
						if(p.getCpf().equals(cpf)) {
							c.setCpfPaciente(cpf);
							existe = true;
						}
					}
					
					if(!existe) {
						System.out.println("Não há pacientes registrados com esse CPF!");
					}
				}while(!existe);
				
				existe = false;
				
				do {
					System.out.println("CRM do Médico: ");
					int crm = sc.nextInt();
					sc.nextLine();
					
					for(Medico m : consultorio.getMedicos()) {
						if(m.getCrm() == crm) {
							c.setCrmMedico(crm);
							existe = true;
						}
					}
					
					if(!existe) {
						System.out.println("Não há médicos registrados com esse CRM!");
					}
				}while(!existe);
				
				
				consultorio.cadastrarConsulta(c);
			} else {
				System.out.println("Número máximo de consultas atingido!");
			}
		} else {
			System.out.println("Não é possível criar uma consulta pois não há médicos ou pacientes cadastrados!");
		}
	}
	
	public static void imprimirDadosDeUmMedico(Scanner sc) {
		if(!consultorio.getMedicos().isEmpty()) {
			System.out.println("Digite o CRM do Médico que você deseja ver as informações: ");
			int crm = sc.nextInt();
			sc.nextLine();
			
			int aux = 0;
			
			for(Medico m : consultorio.getMedicos()) {
				if(m.getCrm() == crm) {
					aux++;
					System.out.println("Médico encontrado: ");
					m.imprimir();
				}
			}
			
			if(aux != 1) {
				System.out.println("Não existe médico registrado com o CRM indicado!");
			}
		} else {
			System.out.println("Não há médicos registrados!");
		}
	}
	
	public static void imprimirDadosDeUmPaciente(Scanner sc) {
		if(!consultorio.getPaciente().isEmpty()) {
			System.out.println("Digite o CPF do Paciente que você deseja ver as informações: ");
			String cpf = sc.nextLine();
			
			int aux = 0;
			
			for(Paciente p : consultorio.getPaciente()) {
				if(p.getCpf().equals(cpf)) {
					aux++;
					System.out.println("Paciente encontrado: ");
					p.imprimir();
				}
			}
			
			if(aux != 1) {
				System.out.println("Não existe paciente registrado com o CPF indicado!");
			}
		} else {
			System.out.println("Não há pacientes registrados!");
		}
	}
	
	public static void imprimirDadosDeUmaConsulta(Scanner sc) {
		if(!consultorio.getConsulta().isEmpty()) {
			System.out.println("Digite o número da Consulta que você deseja ver as informações: ");
			int numero = sc.nextInt();
			sc.nextLine();
			
			int aux = 0;
			
			for(Consulta c : consultorio.getConsulta()) {
				if(c.getNumero() == numero) {
					aux++;
					System.out.println("Consulta encontrada: ");
					c.imprimir();
					System.out.println("Paciente de CPF " + c.getCpfPaciente() + ":");
					
					int aux2 = 0;
					
					for(Paciente p : consultorio.getPaciente()) {
						if(p.getCpf().equals(c.getCpfPaciente())) {
							aux2++;
							p.imprimir();
						}
					}
					
					if(aux2 != 1) {
						System.out.println("(PACIENTE COM REGISTRO EXCLUÍDO)");
					} else {
						aux2--;
					}
					
					System.out.println("Médico de CRM " + c.getCrmMedico() + ":");
					
					for(Medico m : consultorio.getMedicos()) {
						if(m.getCrm() == (c.getCrmMedico())) {
							aux2++;
							m.imprimir();
						}
					}
					if(aux2 != 1) {
						System.out.println("(MÉDICO COM REGISTRO EXCLUÍDO)");
					}
				}
			}
			
			if(aux != 1) {
				System.out.println("Não existe consulta registrada com o número indicado!");
			}
		} else {
			System.out.println("Não há consultas registradas!");
		}
	}
	
	public static void removerMedico(Scanner sc) {
		if(!consultorio.getMedicos().isEmpty()) {
			System.out.println("Digite o CRM do Médico que você deseja remover: ");
			int crm = sc.nextInt();
			sc.nextLine();

			try {
				consultorio.removerMedico(crm);
				System.out.println("Médico removido com sucesso!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Não há médicos registrados!");
		}
		
	}
	
	public static void removerPaciente(Scanner sc) {
		if(!consultorio.getPaciente().isEmpty()) {
			System.out.println("Digite o CPF do Paciente que você deseja remover: ");
			String cpf = sc.nextLine();

			try {
				consultorio.removerPaciente(cpf);
				System.out.println("Paciente removido com sucesso!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Não há pacientes registrados!");
		}
	}
	
	public static void removerConsulta(Scanner sc) {
		if(!consultorio.getConsulta().isEmpty()) {
			System.out.println("Digite o CPF do paciente do qual que você deseja remover a consulta: ");
			String cpf = sc.nextLine();
			System.out.println("Digite a data da consulta que você deseja remover: ");
			String data = sc.nextLine();
			
			try {
				consultorio.removerConsulta(cpf, data);
				System.out.println("Consulta removida com sucesso!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Não há consultas registradas!");
		}
	}
}
