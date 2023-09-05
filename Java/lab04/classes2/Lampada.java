package classes2;

public class Lampada {
	private String modelo;
	private int tensao;
	private Boolean estado;
	public static int cont = 0;
	
	public Lampada() {
		super();
		cont++;
	}
	
	public Lampada(String modelo, int tensao) {
		super();
		this.modelo = modelo;
		this.tensao = tensao;
		this.estado = false;
		cont++;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getTensao() {
		return tensao;
	}
	public void setTensao(int tensao) {
		this.tensao = tensao;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public void acender() {
		this.estado = true;
	}
	
	public void apagar() {
		this.estado = false;
	}
	
	public String mostraEstado() {
		return this.estado ? "A lâmpada está acesa!" : "A lâmpada está apagada!";
	}
}
