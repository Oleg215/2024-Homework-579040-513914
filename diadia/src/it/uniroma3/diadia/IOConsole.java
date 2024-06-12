package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole implements IO{
	Scanner scanner;
	public IOConsole(Scanner scanner) {
		this.scanner=scanner;
	}
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
//	forma sintattica try-with-resource
	public String leggiRiga() {
		
		{
			String riga = scanner.nextLine();
//			 scannerDiLinee.close();
		    return riga;
		}

//		Scanner scannerDiLinee = new Scanner(System.in);
//		String riga = scannerDiLinee.nextLine();
//		//		 scannerDiLinee.close();
//		return riga;
	}
}

/*package it.uniroma3.diadia;
import java.util.Scanner;
public class IOConsole implements IO{
	
	Scanner scannerDiLinee;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
		//controlli artigianali prima della consegna
		//System.out.println("\n\nPIPPO\n\n");
	}
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		//Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}*/