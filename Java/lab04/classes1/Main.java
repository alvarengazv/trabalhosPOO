package classes1;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		float a, b, c;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Qual o lado A: ");
		
		a = scanner.nextFloat();
		
		System.out.println("Qual o lado B: ");

		b = scanner.nextFloat();
		
		System.out.println("Qual o lado C: ");
		
		c = scanner.nextFloat();
 
		if(Triangulo.isTriangulo(a, b, c)) {
			Triangulo t1 = new Triangulo(a, b, c);
			System.out.println("Este é um triângulo " + t1.tipoTriangulo());
			System.out.println("Lado A: " + t1.getA() + "\tLado B: " + t1.getB() + "\tLado C: " + t1.getC());
			
		} else {
			System.out.println("Não é possível criar um triângulo com esses valores!");
		}
		
		System.out.println("Foram criadas " + Triangulo.cont + " instâncias da classe Triângulo.");
		
		Triangulo t2 = new Triangulo();
		
		System.out.println("Este é um triângulo " + t2.tipoTriangulo());
		System.out.println("Lado A: " + t2.getA() + "\tLado B: " + t2.getB() + "\tLado C: " + t2.getC());
		
		System.out.println("Foram criadas " + Triangulo.cont + " instâncias da classe Triângulo.");
		
		Triangulo t3 = new Triangulo(3, 4, 5);
		
		System.out.println("Este é um triângulo " + t3.tipoTriangulo());
		System.out.println("Lado A: " + t3.getA() + "\tLado B: " + t3.getB() + "\tLado C: " + t3.getC());
		
		System.out.println("Foram criadas " + Triangulo.cont + " instâncias da classe Triângulo.");
		
		scanner.close();
	}

}
