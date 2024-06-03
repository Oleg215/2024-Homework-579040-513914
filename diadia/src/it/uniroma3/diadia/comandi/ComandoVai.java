package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	private String direzione;
	

	public void esegui(Partita partita) {
		Stanza StanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		Stanza ProssimaStanza=null;
		if(direzione==null) {
			System.out.println("Dove vuoi andare ? Devi specificare una direzione");
								
		return;}
		 ProssimaStanza = StanzaCorrente.getStanzaAdiacente(this.direzione);
		
		if (ProssimaStanza == null) {
			System.out.println("Direzione inesistente");
		return;}
			partita.getLabirinto().setStanzaCorrente(ProssimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(--cfu);
		
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	

	
	public void setParametro(String parametro) {
		this.direzione=parametro;
		
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

