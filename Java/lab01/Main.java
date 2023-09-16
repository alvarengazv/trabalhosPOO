package lab01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String string, stringC = "";
		Boolean primeiro = true;
		
		try {
			while((string = br.readLine()) != null) {
				
				if(string.contains("_")) {
					while (string.contains("_")) {
						if(primeiro) {
							stringC = string.replaceFirst("_", "<i>");
						} else {
							stringC = string.replaceFirst("_", "</i>");
						}
						string = stringC;
						primeiro = !primeiro;
			        }
				}
				
				primeiro = true;
				
				if(string.contains("*")) {
					while (string.contains("*")) {
						if(primeiro) {
							stringC = string.replaceFirst("\\*", "<b>");
						} else {
							stringC = string.replaceFirst("\\*", "</b>");
						}
						string = stringC;
						primeiro = !primeiro;
			        }
				}
				
				System.out.println(string);
				
				string = "";
				stringC = "";
				primeiro = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
		}	
	}
}