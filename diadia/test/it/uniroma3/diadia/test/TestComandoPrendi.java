package it.uniroma3.diadia.test;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class TestComandoPrendi {
	private Partita p;
	private Attrezzo a1;
	private Stanza s;
	private ComandoPrendi c;
	private Attrezzo a2;
	
	@Before
	public void setUp() {
		p=new Partita();
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


