package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.Stanza;

public class labirintotest {
	private Labirinto labirinto;
	private Stanza atrio;
	private Stanza biblioteca;
	private Stanza test2;
	
	@Before
	public void seUp() {
		labirinto= new Labirinto();
		atrio=this.labirinto.getCorrente();
		biblioteca=this.labirinto.getFine();
	}
	@Test
	public void testStanzaCorrente() {
		assertEquals(atrio,this.labirinto.getCorrente());
	}
	@Test
	public void testStanzaVincente() {
		assertEquals(biblioteca,this.labirinto.getFine());
	}
	@Test
	public void testSetCorrente() {
		this.labirinto.setCorrente(null);
		assertNull("errore, doveva essere nullo.",this.labirinto.getCorrente());
	}
	@Test
	public void testSetCorrente2() {
		this.labirinto.setCorrente(test2);
		assertEquals("errore, doveva essere test2",test2,this.labirinto.getCorrente());
	}


}
