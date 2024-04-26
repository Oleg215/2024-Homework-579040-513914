package diadia_base.tar.gz_expanded;

import it.uniroma3.diadia.*;
import static org.junit.Assert.*;



import org.junit.Test;

public class PartitaTest {
	Partita p=new Partita();
	
	
	
	
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