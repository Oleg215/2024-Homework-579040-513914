package it.uniroma3.diadia.test;


import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.Command;
import it.uniroma3.diadia.comandi.FabbricaComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

//	limitarsi alla sola verifica del corretto riconoscimento dei comandi
	private FabbricaComandiFisarmonica factory;
	private Command comando;
	
	@Before
	public void setUp() {
		this.factory = new FabbricaComandiFisarmonica();
	}
	
	@Test
	public void ComandoNonValidoTest() {
		this.comando = new ComandoNonValido();
		assertEquals(comando.getNome(), factory.costruisciComando("sudest").getNome());
	}
	
	@Test
	public void ComandoConParametroTest() {
		this.comando = new ComandoPrendi();
		this.comando.setParametro("osso");
		assertEquals(comando.getNome(), factory.costruisciComando("prendi osso").getNome());
		assertEquals(comando.getParametro(), factory.costruisciComando("prendi osso").getParametro());
	}
	
	@Test
	public void ComandoFineTest() {
		this.comando = new ComandoFine();
		assertEquals(comando.getNome(), factory.costruisciComando("fine").getNome());
	}
	
}
