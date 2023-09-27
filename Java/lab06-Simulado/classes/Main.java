package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Scanner s = new Scanner(System.in);
		int escolha;
		
		do {
			System.out.println("Escolha uma opção: [1]Cadastrar cliente, " + 
							   "[2]Cadastrar pedido, [3]Listar pedidos, [4]Listar clientes, " + 
							   "[5]Listar pedidos por cliente, [6]Calcular valor gasto por cliente ou [-1]Sair");
			escolha = s.nextInt();
			s.nextLine();
		
			switch (escolha) {
			case 1: {
				Cliente c = new Cliente();
				
				System.out.println("Nome: ");
				c.setNome(s.nextLine());
				System.out.println("Endereco: ");
				c.setEndereco(s.nextLine());
				System.out.println("Telefone: ");
				c.setTelefone(s.nextLine());
				
				clientes.add(c);
				break;
			}
			case 2: {
				if(!clientes.isEmpty()) {
					int i = 0;
					System.out.println("Para qual cliente você quer cadastrar um pedido:");
					for(Cliente c : clientes) {
						System.out.println("Cliente: " + (++i) + "\nNome: " + c.getNome() + "\nTelefone: " + c.getTelefone());
						System.out.println("Deseja o cliente acima? (S ou N)");
						
						String sn = s.next();
						
						if(sn.equals("S") || sn.equals("s")) {
							Pedido p = new Pedido();
							
							System.out.println("Número do pedido: ");
							p.setNumero(s.nextInt());
							s.nextLine();
							
							System.out.println("Descrição do pedido: ");
							p.setDescricao(s.nextLine());
							
							System.out.println("Valor do pedido: ");
							p.setValor(s.nextDouble());
							
							p.setCliente(c);
							c.getListaPedidos().add(p);
							pedidos.add(p);
							break;
						} else continue;
					}
				} else {
					System.out.println("Não há clientes cadastrados! Cadastre um cliente para poder adicionar pedidos.");
				}
				break;
			}
			case 3: {
				if(!pedidos.isEmpty()) {
					int[] i = new int[1];
					pedidos.forEach(p -> {
						System.out.println("\nPedido " + (++i[0]) + ":");
						System.out.println("Número: " + p.getNumero());
						System.out.println("Descrição: " + p.getDescricao());
						System.out.println("Valor: " + p.getValor());
						System.out.println("Cliente: " + p.getCliente().getNome());
					});
				} else {
					System.out.println("Não há pedidos cadastrados!");
				}
				break;
			}
			case 4: {
				if(!clientes.isEmpty()) {
					int[] i = new int[1];
					clientes.forEach(c -> {
						System.out.println("\nCliente " + (++i[0]) + ":");
						System.out.println("Nome: " + c.getNome());
						System.out.println("Endereço: " + c.getEndereco());
						System.out.println("Telefone: " + c.getTelefone());
						System.out.println("Pedidos: ");
						if(!c.getListaPedidos().isEmpty()) {
							int[] j = {0};
							c.getListaPedidos().forEach(p -> {
								System.out.println("\nPedido " + (++j[0]));
								System.out.println("Número: " + p.getNumero());
								System.out.println("Descrição: " + p.getDescricao());
								System.out.println("Valor: " + p.getValor());
							});
						} else {
							System.out.println("Esse cliente não possui pedidos.");
						}
					});
				} else {
					System.out.println("Não há clientes cadastrados!");
				}
				break;
			}
			case 5: {
				int escolha2;
				System.out.print("\nEscolha o cliente por [1] número ou [2] nome do cliente: ");
				escolha2 = s.nextInt();
				s.nextLine();
				int[] check = {0};
				
				if(escolha2 == 1) {
					System.out.print("\nDigite o número do cliente: ");
					String telefone = s.nextLine();
					
					for(Cliente c: clientes){
						if(c.getTelefone().equals(telefone)) {
							c.listarPedidos();
							check[0]++;
						}
					}
					if(check[0] != 1) {
						System.out.println("Não há clientes com esse número.");
					}
				} else if(escolha2 == 2) {
					System.out.print("\nDigite o nome do cliente: ");
					String nome = s.nextLine();
					
					for(Cliente c: clientes){
						if(c.getNome().equals(nome)) {
							c.listarPedidos();
							check[0]++;
						}
					}
					if(check[0] != 1) {
						System.out.println("Não há clientes com esse nome.");
					}
				} else {
					System.out.println("Opção inválida!");
				}
				break;
			}
			case 6: {
				int escolha2;
				System.out.print("\nEscolha o cliente por [1] número ou [2] nome do cliente: ");
				escolha2 = s.nextInt();
				s.nextLine();
				int[] check = {0};
				
				if(escolha2 == 1) {
					System.out.print("\nDigite o número do cliente: ");
					String telefone = s.nextLine();
					
					for(Cliente c: clientes){
						if(c.getTelefone().equals(telefone)) {
							System.out.println("Valor total gasto: " + c.valorTotal());
							check[0]++;
						}
					}
					if(check[0] != 1) {
						System.out.println("Não há clientes com esse número.");
					}
				} else if(escolha2 == 2) {
					System.out.print("\nDigite o nome do cliente: ");
					String nome = s.nextLine();
					
					for(Cliente c: clientes){
						if(c.getNome().equals(nome)) {
							System.out.println("Valor total gasto: " + c.valorTotal());
							check[0]++;
						}
					}
					if(check[0] != 1) {
						System.out.println("Não há clientes com esse nome.");
					}
				} else {
					System.out.println("Opção inválida!");
				}
				break;
			}
			case (-1): {
				System.out.println("Saindo...");
				break;
			}
			default:
				System.out.println("Opção inválida");
				break;
			}
		} while (escolha != -1);
		s.close();
	}
}
