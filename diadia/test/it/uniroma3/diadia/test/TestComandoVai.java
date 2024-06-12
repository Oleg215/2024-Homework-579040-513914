package it.uniroma3.diadia.test;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.ComandoVai;



public class TestComandoVai {			
	
	private Partita p;
	private ComandoVai t;
	private Labirinto labirinto;
	@Before
	public void setup() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto=Labirinto.newBuilder("labirinto2.txt").getLabirinto();
//				.addStanzaIniziale("Atrio")
//				.addAttrezzo("osso", 1)
//				.addStanzaVincente("Biblioteca")
//				.addStanza("Aula N10")
//				.addAttrezzo("lanterna", 3)
//				.addStanza("Aula N11")
//				.addStanza("Laboratorio Campus")
//				.addAdiacenza("Atrio","Biblioteca","nord")
//				.addAdiacenza("Atrio","Aula N11","est")
//				.addAdiacenza("Atrio","Aula N10","sud")
//				.addAdiacenza("Atrio","Laboratorio Campus","ovest")
//				.addAdiacenza("Aula N11","Laboratorio Campus","est")
//				.addAdiacenza("Aula N11","Atrio","ovest")
//				.addAdiacenza("Aula N10", "Atrio","nord")
//				.addAdiacenza("Aula N10", "Aula N11","est")
//				.addAdiacenza("Aula N10", "Laboratorio Campus","ovest")
//				.addAdiacenza("Laboratorio Campus","Atrio", "est")
//				.addAdiacenza("Laboratorio Campus","Aula N11", "ovest")
//				.addAdiacenza("Biblioteca", "Atrio", "sud").getLabirinto();
		p=new Partita(labirinto);
		t= new ComandoVai();
	}
	

	@Test
	public void testSud() {
		t.setParametro("sud");
		t.esegui(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getNome(),"Aula N10");
		}
	@Test
	public void testEst() {
		t.setParametro("est");
		t.esegui(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getNome(),"Aula N11");
	}
	@Test
	public void testOvest() {
		t.setParametro("ovest");
		t.esegui(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getNome(),"Laboratorio Campus");
		
	}
	@Test
	public void testNord() {
		t.setParametro("nord");
		t.esegui(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getNome(),"Biblioteca");
		
	}
	@Test
	public void test2passiUguali() {
		t.setParametro("ovest"); 
		t.esegui(p);
		t.esegui(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getNome(),"Aula N11");
		}
	@Test
	public void test2passiDiversi() {
		t.setParametro("sud");
		t.esegui(p);
		t.setParametro("ovest");
		t.esegui(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getNome(),"Laboratorio Campus");
	}
	@Test
	public void testDecrementoCfu() {
		t.setParametro("sud");
		t.esegui(p);
		assertEquals(19,p.getGiocatore().getCfu());
	}
}
