package it.uniroma3.DiaDia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.Partita;

public class PartitaTest {

	private Partita p;
	
	@Before
	public void setUp() {
		p = new Partita();
	}
	
	/*TEST REALIZZATI PRIMA DI INTRODURRE LA CLASSE GIOCATORE*/
	@Test
	public void testVintaFalse() {
		assertFalse("Ritorna True se inizializzato a due stanze uguali",p.getStanzaCorrente()== p.labirintoCorrente.getStanzaVincente());
	}
	
	@Test
	public void testVintaTrue() {
		p.labirintoCorrente.setStanzaCorrente(p.labirintoCorrente.getStanzaVincente());
		assertTrue("",p.labirintoCorrente.getStanzaCorrente()== p.labirintoCorrente.getStanzaVincente());
	}
	
	@Test
	public void testVintaUnaNull() {
		p.labirintoCorrente.setStanzaCorrente(null);
		assertFalse("Ritorna True se inizializziamo tutte e due le stanze a null",p.labirintoCorrente.getStanzaCorrente()== p.labirintoCorrente.getStanzaVincente());
	}

	@Test
	public void testIsFinita() {
		p.labirintoCorrente.setStanzaCorrente(p.labirintoCorrente.getStanzaVincente());
		p.setFinita();
		p.ciocatore.setCfu(0);
		assertTrue("",p.isFinita());
	}
	
	@Test
	public void testNonFinita() {
		assertFalse("",p.isFinita());
	}

	@Test
	public void testSetFinita() {
		p.setFinita();
		p.ciocatore.setCfu(0);
		assertTrue("Ritorna False se setFinita non funge",p.isFinita());
	}

}
