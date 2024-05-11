package it.uniroma3.diadia.test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza s1;
	private Attrezzo chiavi;
	private Attrezzo bastone;
	private Map<String, Attrezzo> arr;
	@Before 
	public void setUp() {
		s1= new Stanza("s1");
		chiavi= new Attrezzo("chiavi", 12);
		bastone=new Attrezzo("bastone", 5);
		arr=new HashMap<>();
	}
	@Test
	public void testAddAttrezzoNum() {
		s1.addAttrezzo(chiavi);
		s1.addAttrezzo(bastone);
		assertEquals(2,s1.getNumeroAttrezzi());
	}
	@Test
	public void testAddAttrezzo() {
		s1.addAttrezzo(chiavi);
		assertEquals(true,s1.hasAttrezzo("chiavi"));
	}
	@Test
	public void testAdd2Attrezzi() {
		s1.addAttrezzo(chiavi);
		s1.addAttrezzo(bastone);
		assertEquals(bastone,s1.getMappaAttrezzi());
	}
	public void testAddAttrezzoArr() {
		s1.addAttrezzo(chiavi);
		s1.addAttrezzo(bastone);
		arr.get(bastone);
		arr.get(chiavi);
		assertEquals(arr,s1.getMappaAttrezzi());
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
	@Test
	public void testRemoveAttrezzoT2() {
		s1.addAttrezzo(chiavi);
		s1.removeAttrezzo(chiavi);
		assertFalse(s1.hasAttrezzo("chiavi"));
	
}
	
}
	//prova commit 1