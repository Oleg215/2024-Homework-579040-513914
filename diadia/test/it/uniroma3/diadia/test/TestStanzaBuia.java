package it.uniroma3.diadia.test;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;

public class TestStanzaBuia {
	private StanzaBuia s;
	private StanzaBuia c;
	private Attrezzo t;
	private Attrezzo l;
	private Stanza s1;
	@Before
	public void setUp() {
		s=new StanzaBuia("stanza");
		l=new Attrezzo("lanterna",2);
		c=new StanzaBuia("camera","torcia");
		t=new Attrezzo("torcia",2);
		
		
	}
	
	@Test
	public void testLanterna() {
		s.addAttrezzo(l);
		assertEquals(s.getDes(),s.getDescrizione());
	}
	@Test
	public void testBuioSenzaLanterna() {
		assertNotEquals(s.getDes(),s.getDescrizione());
	}
	@Test 
	public void testTorcia() {
		c.addAttrezzo(t);
		assertEquals(c.getDes(),c.getDescrizione());
	}
	@Test
	public void testBuioSenzaTorcia() {
		assertNotEquals(s.getDes(),s.getDescrizione());
	}
	@Test
	public void testBuioConLanterna() {
		s.addAttrezzo(t);
		assertNotEquals(s.getDes(),s.getDescrizione());
	}
	@Test 
	public void testBuioConTorcia() {
		c.addAttrezzo(l);
		assertNotEquals(s.getDes(),s.getDescrizione());
	}

}
