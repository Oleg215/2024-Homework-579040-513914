package it.uniroma3.diadia.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.ComandoVai;



public class TestComandoVai {			
	
	private Partita p;
	private ComandoVai t;
	private Labirinto labirinto;
	@Before
	public void setup() {
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
