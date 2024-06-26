package it.uniroma3.diadia.ambienti;
import java.io.FileNotFoundException;
import java.util.*;

import it.uniroma3.diadia.ambienti.CaricatoreLabirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {

	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;

	/*public  Labirinto() {
		this.creaStanze();
	} */ 
	public Labirinto() {}
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c =
				new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
  /*  public void creaStanze() {

		/* crea gli attrezzi */
    /*	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
	/*	Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
	/*	atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
	/*	aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }*/
  
	
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return  new LabirintoBuilder(labirinto);
	}
	  public void setStanzaIniziale(Stanza stanzaIniziale) {
	    	this.stanzaIniziale=stanzaIniziale;
	    }
	    public Stanza getStanzaIniziale() {
	    	return this.stanzaIniziale;
	    }
		public Stanza getStanzaVincente() {
			return stanzaVincente;
		}

		public void setStanzaCorrente(Stanza stanzaCorrente) {
			this.stanzaIniziale = stanzaCorrente;
		}
		public void setStanzaVincente(Stanza stanzaVincente) {
			this.stanzaVincente=stanzaVincente;
		}
		public Stanza getStanzaCorrente() {
			return this.stanzaIniziale;
		}
	
//	public static LabirintoBuilder Labirinto.new Builder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
//		return new LabirintoBuilder(labirinto);
//	}
	
	
	public static class LabirintoBuilder {
		
	/*addStanzaIniziale,addStanzaVincente,addAttrezzo,addAdiacenza,getLabirinto */
		private Labirinto labirinto;
		private Stanza stanza;
		private Map<String,Stanza> Stanze;

		public LabirintoBuilder() {
			this.labirinto=new Labirinto();
			this.Stanze=new HashMap<>();		}
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto=new Labirinto(labirinto);
			this.Stanze=new HashMap<>();
		}
		public Map<String,Stanza> getListaStanze(){
			return this.Stanze;
		}
		public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
			Stanza stanza=new Stanza(nomeStanza);
			this.stanza=stanza;
			Stanze.put(nomeStanza, stanza);
			labirinto.setStanzaIniziale(stanza);
			labirinto.setStanzaCorrente(stanza);
			return this;
		}
		public LabirintoBuilder addStanzaVincente(String nomeStanza) {
			Stanza stanza=new Stanza(nomeStanza);
			this.stanza=stanza;
			Stanze.put(nomeStanza, stanza);
			labirinto.setStanzaVincente(stanza);
			return this;
		}
		public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, attrezzo);
			if(this.stanza==null)
				return this;
			this.stanza.setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder  addCane(String nome, String attrezzoPref, String attrezzoChePos, int peso) {
			Cane c = new Cane(nome,attrezzoPref,attrezzoChePos,peso);
			if(this.stanza==null)
				return this;
			this.stanza.setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder  addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome);
			if(this.stanza==null)
				return this;
			this.stanza.setPersonaggio(s);
			return this;
		}
		public LabirintoBuilder addStanzaBloccata(String nomeStanza,Direzione direzioneBlocco,String attrezzo) {
			StanzaBloccata stanza=new StanzaBloccata(nomeStanza,direzioneBlocco,attrezzo);
			this.stanza=stanza;
			Stanze.put(nomeStanza, stanza);
			return this;
		}
		public LabirintoBuilder addStanzaMagica(String nomeStanza,int sogliaMagica) {
			StanzaMagica stanza=new StanzaMagica(nomeStanza,sogliaMagica);
			this.stanza=stanza;
			Stanze.put(nomeStanza, stanza);
			return this;
		}
		public LabirintoBuilder addStanzaBuia(String nomeStanza,String oggetto) {
			StanzaBuia stanza= new StanzaBuia(nomeStanza,oggetto);
			this.stanza=stanza;
			Stanze.put(nomeStanza, stanza);
			return this;
		}
		public LabirintoBuilder addStanza(String nomeStanza) {
			Stanza stanza=new Stanza(nomeStanza);
			this.stanza=stanza;
			Stanze.put(nomeStanza, stanza);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int pesoAttrezzo) {
			Attrezzo attrezzo= new Attrezzo(nomeAttrezzo,pesoAttrezzo);
			if(this.stanza==null)
				return this;
			this.stanza.addAttrezzo(attrezzo);
			return this;
		}
		public LabirintoBuilder addAdiacenza(String stanzaSrc,String stanzaDst,Direzione direzione) {
			Stanza StanzaSrc=Stanze.get(stanzaSrc);
			Stanza StanzaDst=Stanze.get(stanzaDst);
			StanzaSrc.impostaStanzaAdiacente(direzione, StanzaDst);
			return this;

		}
		public Labirinto getLabirinto() {
			return this.labirinto;
		}

	}
}
