package it.uniroma3.diadia.test;
import  it.uniroma3.diadia.ambienti.*;
import static org.junit.Assert.*;

import org.junit.Test;



public class LabirintoTest {
	Labirinto l=new LabirintoBuilder()
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
