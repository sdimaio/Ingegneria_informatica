package it.uniroma3.DiaDia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.Giocatore.Borsa;

public class GiocatoreTest {
	private Partita p;
	private Borsa b;
	@Before
	public void setUp() {
		p = new Partita();
	}
	
	@Test
	public void testGetCfu() {
		assertEquals(20, p.ciocatore.getCfu());
	}
	
	public void testGetCfuMaxInteger() {
		p.ciocatore.setCfu(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, p.ciocatore.getCfu());
	}

	/* i test del set Cfu sono omessi perché già
	 * testati nei test del getCfu*/
	 
	@Test
	public void testGetBorsa() {
		b = new Borsa();
		assertFalse("",p.ciocatore.getBorsa() == b);
	}
	

	@Test
	public void testGetBorsaUguali() {
		b = p.ciocatore.getBorsa();
		assertTrue("",p.ciocatore.getBorsa() == b);
	}

}
