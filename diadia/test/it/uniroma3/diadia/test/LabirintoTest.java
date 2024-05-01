package it.uniroma3.diadia.test;
import  it.uniroma3.diadia.ambienti.*;
import static org.junit.Assert.*;

import org.junit.Test;



public class LabirintoTest {
	Labirinto l=new Labirinto();
	Stanza s=new Stanza("s");
	
	@Test
	public void testIniz() {
		assertEquals("Atrio",l.getStanzaCorrente().getNome());
		}
	@Test
	public void testVin() {
		assertEquals("Biblioteca",l.getStanzaVincente().getNome());
	}
	@Test
	public void testCor() {
		l.setStanzaCorrente(s);
		assertEquals("s",l.getStanzaCorrente().getNome());
		
	}

}
