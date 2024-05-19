package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	private Borsa b;
	private Borsa b2;
	private Attrezzo chiavi;
	private Attrezzo martello;
	private Attrezzo ombrello;
	
	@Before
	public void setUp() {
		b = new Borsa();
		b2 = new Borsa();
		chiavi = new Attrezzo("chiavi", 12);
		martello = new Attrezzo("martello", 3);
		ombrello= new Attrezzo("ombrello", 4);
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante() {		
		assertFalse(b.addAttrezzo(chiavi));
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(martello));
	}
	@Test
	public void testGetAttrezzoT() {
		b.addAttrezzo(martello);
		assertEquals(martello,b.getAttrezzo("martello"));
		
	}
	@Test
	public void testGetAttrezzoF() {
		assertNull(b.getAttrezzo("martello"));
	}
	@Test 
	public void testGetSecondoAttrezzo() {
		b.addAttrezzo(martello);
		b.addAttrezzo(ombrello);
		assertEquals(ombrello,b.getAttrezzo("ombrello"));
		}
//	@Test
//	public void testRemoveAttrezzo() {
//		b.addAttrezzo(martello);
//		assertEquals(martello,b.removeAttrezzo("martello"));
//		assertEquals(0,b.getNumeroAttrezzi());
//	}
//	@Test
//	public void testRemoveSecondoAttrezzo() {
//		b.addAttrezzo(martello);
//		b.addAttrezzo(ombrello);
//		assertEquals(ombrello,b.removeAttrezzo("ombrello"));
//		assertEquals(1,b.getNumeroAttrezzi());
//	}	
	
	
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		b.addAttrezzo(ombrello);
		b.addAttrezzo(martello);
		SortedSet<Attrezzo> set = new TreeSet<>();
		set.add(martello);
		set.add(ombrello);
		assertEquals(set, this.b.getContenuroOrdinatoPerNome());
	}
	
	
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		b.addAttrezzo(ombrello);
		b.addAttrezzo(martello);
		
		List<Attrezzo> list=new ArrayList<>();
		list.add(martello);
		list.add(ombrello);
		assertEquals(list, b.getContenutoOrdinatoPerPeso());
	}
	
}
