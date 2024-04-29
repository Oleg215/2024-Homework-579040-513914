package it.uniroma3.diadia.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza s1;
	private Attrezzo chiavi;

	@Before 
	public void setUp() {
		s1= new Stanza("s1");
		chiavi= new Attrezzo("chiavi", 12);

	}

	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetAttrezzo() {
		assertTrue(s1.addAttrezzo(chiavi));
	}
	
	@Test
	public void testRemoveAttrezzoF() {
		assertFalse(s1.removeAttrezzo(chiavi));
		}
	@Test
	public void testRemoveAttrezzoT() {
		s1.addAttrezzo(chiavi);
		assertTrue(s1.removeAttrezzo(chiavi));
		}
}
	//prova commit 1