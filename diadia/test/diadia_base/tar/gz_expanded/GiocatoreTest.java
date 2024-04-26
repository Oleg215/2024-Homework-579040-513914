package diadia_base.tar.gz_expanded;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {


	Giocatore G1= new Giocatore();
	Giocatore G2= new Giocatore();
	Giocatore G3= new Giocatore();

	@Before
	public void setup() {
		G2.setCfu(5);
		G3.setCfu(-3);
	}

	@Test
	public void testCfuIniz() {
		assertEquals(20,G1.getCfu());
	}

	@Test
	public void testSetCfu() {
		assertEquals(5,G2.getCfu());
	}

	@Test
	public void testGetBorsa() {
		assertNotNull(G1.getBorsa());
	}
	@Test
	public void testCfuNeg() {
		assertEquals(-3,G3.getCfu());
	}
}


