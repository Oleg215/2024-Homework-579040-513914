package it.uniroma3.diadia.ambienti;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.*;
import java.util.HashMap;
public class LabirintoBuilder {
/*addStanzaIniziale,addStanzaVincente,addAttrezzo,addAdiacenza,getLabirinto */
	private Labirinto labirinto;
	private Stanza stanza;
	private Map<String,Stanza> Stanze;

	public LabirintoBuilder() {
		this.labirinto=new Labirinto();
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
		labirinto.setStanzaCorrente(stanza);
		return this;
	}
	public LabirintoBuilder addStanzaBloccata(String nomeStanza,String direzioneBlocco,String attrezzo) {
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
		stanza.addAttrezzo(attrezzo);
		return this;
	}
	public LabirintoBuilder addAdiacenza(String stanzaSrc,String stanzaDst,String direzione) {
		Stanza StanzaSrc=Stanze.get(stanzaSrc);
		Stanza StanzaDst=Stanze.get(stanzaDst);
		StanzaSrc.impostaStanzaAdiacente(direzione, StanzaDst);
		return this;

	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}

}