package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole implements IO{

	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
//	forma sintattica try-with-resource
	public String leggiRiga() {
		try (Scanner scannerDiLinee = new Scanner(System.in)) {
		    String riga = scannerDiLinee.nextLine();
//			 scannerDiLinee.close();
		    return riga;
		}

//		Scanner scannerDiLinee = new Scanner(System.in);
//		String riga = scannerDiLinee.nextLine();
//		//		 scannerDiLinee.close();
//		return riga;
	}
}

