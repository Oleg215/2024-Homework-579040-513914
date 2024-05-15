package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class PartitaTest {
	private Labirinto labirinto;
	Partita p=new Partita(labirinto);
	
	
	
	
	@Test
	public void testGetStanza() {
		
		assertEquals("Atrio",p.getLabirinto().getStanzaCorrente().getNome());
	}
	@Test
	public void testGetGiocatore(){
		assertNotNull(p.getGiocatore());
	}
	@Test
	public void testGetLabirinto() {
		
		assertNotNull(p.getLabirinto());
	}
	@Test
	public void testVinta() {
		p.getLabirinto().setStanzaCorrente(p.getLabirinto().getStanzaVincente());
		assertEquals(true,p.vinta());
		assertEquals(true,p.isFinita());
	}
	
		 
	
	
}