package classes1;

public class Triangulo {
	private float a;
	private float b;
	private float c;
	public static int cont = 0;
	
	public Triangulo() {
		this.a = 1f;
		this.b = 1f;
		this.c = 1f;
		cont++;
	}
	
	public Triangulo(float a, float b, float c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		cont++;
	}
	
	public float getA() {
		return a;
	}
	public void setA(float a) {
		this.a = a;
	}
	public float getB() {
		return b;
	}
	public void setB(float b) {
		this.b = b;
	}
	public float getC() {
		return c;
	}
	public void setC(float c) {
		this.c = c;
	}
	
	public static Boolean isTriangulo(float a, float b, float c) {
		return(Math.abs(b - c) < a && a < b + c) 
			&& (Math.abs(a - c) < b && b < a + c)
			&& (Math.abs(a - b) < c && c < a + a);
	}
	
	public String tipoTriangulo() {
		if((a == b && b != c) || (a == c && c != b) || (b == c && c != a)) {
			return "Isósceles";
		} else if(a == b && b == c) {
			return "Equilátero";
		} else {
			return "Escaleno";
		}
	}
	
}
