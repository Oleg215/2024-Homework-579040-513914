package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaComandiFisarmonica implements FabbricaComandi {
	public Command costruisciComando(String istruzione) {
		Scanner scannerDiParole=new Scanner(istruzione);
		String nomeComando=null;
		String parametro=null;
		Command comando=null;
		if(scannerDiParole.hasNext())
			nomeComando=scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro=scannerDiParole.next();
		if(nomeComando==null)
			comando= new ComandoNonValido();
		else if(nomeComando=="vai")
		comando=new ComandoVai();
		else if(nomeComando=="prendi")
			comando=new ComandoPrendi();
		else if(nomeComando=="posa")
			comando=new ComandoPosa();
		else if(nomeComando=="aiuto")
			comando= new ComandoAiuto();
		else if(nomeComando=="fine")
			comando= new ComandoFine();
		else if(nomeComando=="guarda")
			comando= new ComandoGuarda();
		else
			comando=new ComandoNonValido();
		comando.setParametro(parametro);
		return comando;
	}

}
