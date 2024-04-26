package diadia_base.tar.gz_expanded;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	private Borsa b;
	private Attrezzo chiavi;
	private Attrezzo martello;
	
	@Before
	public void setUp() {
		b = new Borsa();
		chiavi = new Attrezzo("chiavi", 12);
		martello = new Attrezzo("martello", 9);
	}
	
	@Test
	public void testAddAttrezzo() {		
		assertFalse(b.addAttrezzo(chiavi));
	}

	@Test
	public void testAddAttrezzoPesoMinore() {
		assertTrue(b.addAttrezzo(martello));
	}
	
	@Test
	public void testGetAttrezzo() {
		assertNull(b.getAttrezzo("martello"));
	}
}
