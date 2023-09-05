package classes2;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		int tensao;
		String modelo;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Qual o modelo da lâmpada: ");
		
		modelo = scanner.nextLine();
		
		System.out.println("Qual a tensão da lâmpada: ");

		tensao = scanner.nextInt();
		
		Lampada l = new Lampada(modelo, tensao);

		System.out.println("Modelo da lâmpada: " + l.getModelo());
		
		System.out.println("Tensão da lâmpada: " + l.getTensao());
		
		System.out.println(l.mostraEstado());
		
		l.acender();
		
		System.out.println(l.mostraEstado());
		
		l.apagar();
		
		System.out.println(l.mostraEstado());
		
	}

}
