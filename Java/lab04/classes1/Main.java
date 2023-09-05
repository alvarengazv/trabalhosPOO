package classes1;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Triangulo t1 = new Triangulo();
		float a, b, c;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Qual o lado A: ");
		
		a = scanner.nextFloat();
		
		System.out.println("Qual o lado B: ");

		b = scanner.nextFloat();
		
		System.out.println("Qual o lado C: ");
		
		c = scanner.nextFloat();

		if(t1.isTriangulo(a, b, c)) {
			Triangulo t2 = new Triangulo(a, b, c);
			System.out.println("Este é um triângulo " + t2.tipoTriangulo());
		} else {
			System.out.println("Não é possível criar um triângulo com esses valores!");
		}
		
	}

}
