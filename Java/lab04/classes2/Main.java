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
		
		System.out.println("Foram criadas " + Lampada.cont + " instâncias da classe Lâmpada.");
		
		Lampada l2 = new Lampada("L teste", 220);
		System.out.println("Modelo da lâmpada: " + l2.getModelo());
		
		System.out.println("Tensão da lâmpada: " + l2.getTensao());
		
		System.out.println(l2.mostraEstado());
		
		l2.acender();
		
		System.out.println(l2.mostraEstado());
		
		l2.apagar();
		
		System.out.println(l2.mostraEstado());
		
		System.out.println("Foram criadas " + Lampada.cont + " instâncias da classe Lâmpada.");
		
		scanner.close();
	}

}
