package it.uniroma3.DiaDia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.Ambienti.Labirinto;
import it.uniroma3.DiaDia.Ambienti.LabirintoBuilder;
import it.uniroma3.DiaDia.Giocatore.Borsa;

public class GiocatoreTest {
	private Partita p;
	private Borsa b;
	private Labirinto lab = new LabirintoBuilder()
			 .addStanzaIniziale("LabCampusOne")
			 .addStanzaVincente("Biblioteca")
			 .addAdiacenza("LabCampusOne","Biblioteca","ovest")
			 .getLabirinto();
	@Before
	public void setUp() {
		p = new Partita(lab);
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
