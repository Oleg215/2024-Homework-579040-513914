package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class PartitaTest {
	private Labirinto l;
	Partita p;
	
	@Before 
	public void setUp() {
		l=new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 1)
				.addStanzaVincente("Biblioteca")
				.addStanza("Aula N10")
				.addAttrezzo("lanterna", 3)
				.addStanza("Aula N11")
				.addStanza("Laboratorio Campus")
				.addAdiacenza("Atrio","Biblioteca","nord")
				.addAdiacenza("Atrio","Aula N11","est")
				.addAdiacenza("Atrio","Aula N10","sud")
				.addAdiacenza("Atrio","Laboratorio Campus","ovest")
				.addAdiacenza("Aula N11","Laboratorio Campus","est")
				.addAdiacenza("Aula N11","Atrio","ovest")
				.addAdiacenza("Aula N10", "Atrio","nord")
				.addAdiacenza("Aula N10", "Aula N11","est")
				.addAdiacenza("Aula N10", "Laboratorio Campus","ovest")
				.addAdiacenza("Laboratorio Campus","Atrio", "est")
				.addAdiacenza("Laboratorio Campus","Aula N11", "ovest")
				.addAdiacenza("Biblioteca", "Atrio", "sud").getLabirinto();
		p=new Partita(l);
	}
	
	
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