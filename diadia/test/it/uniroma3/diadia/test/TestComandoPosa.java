package it.uniroma3.diadia.test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.comandi.*;
public class TestComandoPosa {
	private Partita p;
	private ComandoPosa c;
	private Attrezzo a;
	private Stanza s;
	private	Attrezzo[] ar;
	private Labirinto l;
	@Before
	public void setUp() {
		p=new Partita(l);
		c=new ComandoPosa();
		a=new Attrezzo("lanterna",2);
		p.getGiocatore().getBorsa().addAttrezzo(a);
		s=p.getLabirinto().getStanzaCorrente();
		c.setParametro("lanterna");
		ar=new Attrezzo[10];
	}
	

	@Test
	public void testPosaNumeroOggetti() {
		c.esegui(p);
		
		assertEquals(true,s.hasAttrezzo("lanterna"));
	}
	@Test
	public void testArray() {
		ar=new Attrezzo[10];
		ar[0]=s.getAttrezzo("osso");
		ar[1]=a;
		c.esegui(p);
	
		assertArrayEquals(ar,s.getAttrezzi());
	}
	@Test
	public void testBorsa() {
		c.esegui(p);
		assertArrayEquals(ar,p.getGiocatore().getBorsa().getAttrezzi());
	}

}
