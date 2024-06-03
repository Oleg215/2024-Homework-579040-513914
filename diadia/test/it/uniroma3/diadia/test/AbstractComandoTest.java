package it.uniroma3.diadia.test;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import it.uniroma3.diadia.comandi.AbstractComando;

public class AbstractComandoTest {

	private AbstractComando abstractComando;
	
	
	
	@Test
	public void testomandoParametro() {
		abstractComando.setParametro("pippo");
		assertNotNull(abstractComando.getParametro());
	}

	
}
