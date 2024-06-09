package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {
	private String nomeAttrezzo;
	private AbstractPersonaggio personaggio;
	private IOConsole io;
	private String messaggio;
	static final  String ObjNotFound="L'oggetto non è in borsa";
	
	@Override
	public void esegui(Partita partita) {
		personaggio=partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo))
			messaggio=ObjNotFound;
		else { 
			Attrezzo attrezzo;
		attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		messaggio=personaggio.riceviRegalo(attrezzo, partita);
		}
		io.mostraMessaggio(messaggio);
		
		
	}

	@Override
	public void setParametro(String parametro) {
		nomeAttrezzo=parametro;
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
