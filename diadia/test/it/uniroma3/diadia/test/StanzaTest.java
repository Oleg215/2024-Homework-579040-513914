package it.uniroma3.diadia.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;
public class StanzaTest {

	private Stanza s1;
	private Attrezzo chiavi;
	private Attrezzo bastone;
	private Attrezzo ombrello;
	private List<Attrezzo> arr;
	@Before 
	public void setUp() {
		ombrello=new Attrezzo("ombrello",3);
		s1= new Stanza("s1");
		chiavi= new Attrezzo("chiavi", 12);
		bastone=new Attrezzo("bastone", 5);
		arr=new ArrayList<>();
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
		assertEquals(chiavi,s1.getAttrezzi().get(0));
		assertEquals(bastone,s1.getAttrezzi().get(1));
	}
	public void testAddAttrezzoArr() {
		s1.addAttrezzo(chiavi);
		s1.addAttrezzo(bastone);
		assertEquals(arr,s1.getAttrezzi());
	}

	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente(Direzione.nord));
	}
	 
	@Test
	public void testGetAttrezzo() {
		s1.addAttrezzo(chiavi);
		Attrezzo att=s1.getAttrezzo("chiavi");
		assertSame(att,chiavi);
	}
	
	@Test
	public void testRemoveAttrezzoF() {
		assertFalse(s1.removeAttrezzo(ombrello));
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
	@Test
	public void test() throws FileNotFoundException, FormatoFileNonValidoException {
		Labirinto l=Labirinto.newBuilder("labirinto2.txt").addStanzaIniziale("stanza").
				addAttrezzo("lanterna", 2).
				getLabirinto();
		Attrezzo att=l.getStanzaCorrente().getAttrezzo("lanterna");
		assertEquals("lanterna",att.getNome());
		Borsa borsa=new Borsa();
		borsa.addAttrezzo(att);
	}
	
}
	//prova commit 1