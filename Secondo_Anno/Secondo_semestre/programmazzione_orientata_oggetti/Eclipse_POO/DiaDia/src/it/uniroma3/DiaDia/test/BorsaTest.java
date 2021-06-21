package it.uniroma3.DiaDia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.Attrezzi.Attrezzo;
import it.uniroma3.DiaDia.Giocatore.Borsa;

public class BorsaTest {
	private Attrezzo attrezzo;
	private Borsa bag;

	@Before
	public void setUp() {
		bag = new Borsa();
		attrezzo = new Attrezzo("martello", 5);
	}
	@Test
	public void testAddAttrezzo() {
		assertTrue("", bag.addAttrezzo(attrezzo));
	}

	@Test
	public void testAddAttrezzoBorsaPiena() {
		attrezzo = new Attrezzo("forbice", 1);
		for(int i = 0; i < 10; i++) {
			bag.addAttrezzo(attrezzo);
		}
		assertFalse("", bag.addAttrezzo(attrezzo));
	}

	@Test
	public void testAddAttrezzoBorsaPesante() {
		attrezzo = new Attrezzo("vaga", 10);

		bag.addAttrezzo(attrezzo);

		assertFalse("", bag.addAttrezzo(attrezzo));
	}

	@Test
	public void testGetPeso() {
		assertEquals(0, bag.getPeso());
	}

	@Test
	public void testGetPesoUnoAttrPesoMax() {
		attrezzo = new Attrezzo("vaga", 10);

		bag.addAttrezzo(attrezzo);
		assertEquals(10, bag.getPeso());
	}

	@Test
	public void testGetPesoPesoMax() {
		attrezzo = new Attrezzo("forbice", 1);
		for(int i = 0; i < 10; i++) {
			bag.addAttrezzo(attrezzo);
		}
		assertEquals(10, bag.getPeso());
	}

	@Test
	public void testRemoveAttrezzo() {
		
		assertNull("", bag.removeAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzoChece() {
		bag.addAttrezzo(attrezzo);
		assertEquals(attrezzo, bag.removeAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaPiena() {
		attrezzo = new Attrezzo("forbice", 1);
		for(int i = 0; i < 10; i++) {
			bag.addAttrezzo(attrezzo);
		}
		assertEquals(attrezzo, bag.removeAttrezzo("forbice"));
	}

}
