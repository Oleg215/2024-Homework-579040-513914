package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Command {
	
	public void esegui(Partita partita) {
		System.out.println("Comando sconosciuto");
	}
	public void setParametro(String parametro) {}

}
