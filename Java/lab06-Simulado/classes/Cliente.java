package classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private List<Pedido> listaPedidos;
	
	public Cliente() {
		super();
		this.listaPedidos = new ArrayList<Pedido>();
	}

	public Cliente(String nome, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.listaPedidos = new ArrayList<Pedido>();
	}

	public void listarPedidos() {
		if(!this.listaPedidos.isEmpty()) {
			int[] i = {0};
			this.listaPedidos.forEach(p -> {
				System.out.println("\nPedido " + (++i[0]));
				System.out.println("Número: " + p.getNumero());
				System.out.println("Descrição: " + p.getDescricao());
				System.out.println("Valor: R$" + p.getValor());
			});
		} else System.out.println("Sem pedidos!");
	}
	
	public double valorTotal() {
		if(!this.listaPedidos.isEmpty()) {
			double[] valor = new double[1];
			this.listaPedidos.forEach(p -> {
				valor[0] += p.getValor();
			});
			return valor[0];
		} else return 0;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	
}
