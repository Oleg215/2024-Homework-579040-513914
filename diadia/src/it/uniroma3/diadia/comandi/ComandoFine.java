package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Command {
	public void esegui(Partita partita) {
		System.out.println("grazie per aver giocato");
		partita.setFinita();
	}

	@Override
	public void setParametro(String parametro) {}
	

}
