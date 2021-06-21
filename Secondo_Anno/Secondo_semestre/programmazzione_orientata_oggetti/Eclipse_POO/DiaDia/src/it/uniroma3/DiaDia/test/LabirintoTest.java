package it.uniroma3.DiaDia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.Ambienti.Labirinto;
import it.uniroma3.DiaDia.Ambienti.Stanza;

public class LabirintoTest {

	private Labirinto lab;
	private Stanza salone;
	private Stanza stanza;
	@Before
	public void setUp() {
		lab = new Labirinto();
	}
	
	
	@Test
	public void testGetStanzaVincente() {
		lab.creaStanze();
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaVincenteNull() {
		assertNull("", lab.getStanzaVincente());
	}
	
	@Test
	public void testSetStanzaCorrenteNot() {
		lab.creaStanze();
		salone = lab.getStanzaCorrente();	
		stanza = new Stanza("Garage");
		lab.setStanzaCorrente(stanza);
		
		assertNotEquals(salone, lab.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		lab.creaStanze();
		
		assertEquals("Atrio", lab.getStanzaCorrente().getNome());
	}

	@Test
	public void testGetStanzaCorrente() {
		lab.creaStanze();
		salone = new Stanza("Salotto"); 
		lab.setStanzaCorrente(salone);
		
		assertEquals(salone, lab.getStanzaCorrente());
	}
	

}
