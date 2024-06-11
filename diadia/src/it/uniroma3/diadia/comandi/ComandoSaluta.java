package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
	private static final String MESSAGGIO_CON_CHI = "Chi dovrei salutare?";
	private String messaggio;
	private IO io;
	
	@Override 
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio=partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			this.messaggio=personaggio.saluta();
			io.mostraMessaggio(messaggio);
		}
		else
			io.mostraMessaggio(MESSAGGIO_CON_CHI);
		return;	}
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
	public String getNome() {return null;}
}
