package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.stanzaBloccata = new StanzaBloccata("stanzaBloccata", "nord", "martello");
		this.stanza = new Stanza("cucina");
		this.attrezzo = new Attrezzo("martello", 2);
		stanzaBloccata.impostaStanzaAdiacente("nord", stanza);
	}
	
	@Test
	public void getStanzaAdiacenteBloccataTest() {
		assertEquals(stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void getStanzaAdiacenteSbloccataTest() {
		assertEquals(stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void getDescrizioneBloccataTest() {
		String descrizione = "Stanza bloccata nella direzione nord" + ". Prendi il martello che consente di sbloccare la direzione bloccata\n";
		assertEquals(descrizione, this.stanzaBloccata.getDescrizione());
	}
}
