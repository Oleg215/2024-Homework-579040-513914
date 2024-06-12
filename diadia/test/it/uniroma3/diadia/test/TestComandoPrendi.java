package it.uniroma3.diadia.test;


import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class TestComandoPrendi {
	private Partita p;
	private Attrezzo a1;
	private Stanza s;
	private ComandoPrendi c;
	private Attrezzo a2;
	private Labirinto labirinto;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto=Labirinto.newBuilder("labirinto2.txt").getLabirinto();
//				.addStanzaIniziale("Atrio")
//				.addAttrezzo("osso", 1)
//				.addStanzaVincente("Biblioteca")
//				.addStanza("Aula N10")
//				.addAttrezzo("lanterna", 3)
//				.addStanza("Aula N11")
//				.addStanza("Laboratorio Campus")
//				.addAdiacenza("Atrio","Biblioteca","nord")
//				.addAdiacenza("Atrio","Aula N11","est")
//				.addAdiacenza("Atrio","Aula N10","sud")
//				.addAdiacenza("Atrio","Laboratorio Campus","ovest")
//				.addAdiacenza("Aula N11","Laboratorio Campus","est")
//				.addAdiacenza("Aula N11","Atrio","ovest")
//				.addAdiacenza("Aula N10", "Atrio","nord")
//				.addAdiacenza("Aula N10", "Aula N11","est")
//				.addAdiacenza("Aula N10", "Laboratorio Campus","ovest")
//				.addAdiacenza("Laboratorio Campus","Atrio", "est")
//				.addAdiacenza("Laboratorio Campus","Aula N11", "ovest")
//				.addAdiacenza("Biblioteca", "Atrio", "sud").getLabirinto();
		p=new Partita(labirinto);
		s=p.getLabirinto().getStanzaCorrente();
		a1=s.getAttrezzo("osso");
		c=new ComandoPrendi();
		c.setParametro("osso");
		a2=new Attrezzo("lampada",12);
	}
	@Test
	public void TestPrendi() {
		c.esegui(p);
		assertFalse(s.hasAttrezzo("osso"));
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	@Test 
	public void TestPrendiTroppoPesante() {
		c.setParametro("lampada");
		c.esegui(p);
		assertTrue(s.hasAttrezzo("osso"));
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
		
	}


