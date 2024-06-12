package it.uniroma3.diadia.test;
import it.uniroma3.diadia.*; 
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.comandi.*;
public class TestComandoPosa {
	private Partita p;
	private ComandoPosa c;
	private Attrezzo a;
	private Stanza s;
	private	List<Attrezzo> list;
	private Labirinto l;
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		l=Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		p=new Partita(l);
		c=new ComandoPosa();
		s=l.getStanzaCorrente();
		a=new Attrezzo("lanterna",2);
		p.getGiocatore().getBorsa().addAttrezzo(a);
		c.setParametro("lanterna");
		list=new ArrayList<>();
	}
	
 
	@Test
	public void testPosaNumeroOggetti() {
		c.esegui(p);
		
		assertTrue(s.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void testBorsa() {
		c.esegui(p);
		list.add(a);
		assertEquals(list,s.getAttrezzi());
	}

}
