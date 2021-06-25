package it.uniroma3.DiaDia.test;

import static org.junit.Assert.*;


import org.junit.Test;

import it.uniroma3.DiaDia.Ambienti.Stanza;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanza;
    //private Attrezzo[] attrezzi;
    //private String[] direzioni;

	
	/*@Before
	public void SetUp() {
		this.stanza = new Stanza("atrio");
	}*/
	
	
	@Test
	public void testGetNome() {
		this.stanza = new Stanza("atrio");
		assertEquals("atrio", stanza.getNome());
	}
	
	@Test
	public void testGetNomeVuoto() {
		this.stanza = new Stanza("");
		assertEquals("",stanza.getNome());
	}
	
	@Test
	public void testGetNomeNoStanza() {
		this.stanza = new Stanza(null);
		assertNull("dovrebbe essere null",stanza.getNome());
	}

	@Test
	public void testAddAttrezzi() {
		this.stanza = new Stanza("atrio");
		Attrezzo martello = new Attrezzo("martello", 1000);
		assertTrue("Aggiunto con successo",stanza.addAttrezzo(martello));
	}
	
	/*@Test
	public void testAddAttrezziFull() {
		this.stanza = new Stanza("atrio");
		Attrezzo martello = new Attrezzo("martello", 1000);
		for(int i = 0; i < 10; i++ ) {
			stanza.addAttrezzo(martello);
		}
		assertFalse("L'aggiunta non dovrebbe avvenire  ",stanza.addAttrezzo(martello));
	}*/
	
	@Test
	public void testAddAttrezziNull() {
		this.stanza = new Stanza("atrio");
		assertTrue("L'aggiunta dovrebbe avvenire anche se l'oggeto e' null",stanza.addAttrezzo(null));
	}

	@Test
	public void testGetAttrezzoNull() {
		this.stanza = new Stanza("atrio");
		Attrezzo martello = new Attrezzo("martello", 1000);
		stanza.addAttrezzo(martello);
		assertNull(stanza.getAttrezzo("freccia"));
	}
	
	@Test
	public void testGetAttrezzo() {
		this.stanza = new Stanza("atrio");
		Attrezzo martello = new Attrezzo("martello", 1000);
		Attrezzo catapulta = new Attrezzo("catapulta", 2000);
		stanza.addAttrezzo(martello);
		stanza.addAttrezzo(catapulta);
		assertEquals(catapulta ,stanza.getAttrezzo("catapulta"));
	}

}
