package classes;

public class Pedido {
	private String descricao;
	private int numero;
	private double valor;
	private Cliente cliente;
	
	public Pedido() {
		super();
	}

	public Pedido(String descricao, int numero, double valor, Cliente cliente) {
		super();
		this.descricao = descricao;
		this.numero = numero;
		this.valor = valor;
		this.cliente = cliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
}
