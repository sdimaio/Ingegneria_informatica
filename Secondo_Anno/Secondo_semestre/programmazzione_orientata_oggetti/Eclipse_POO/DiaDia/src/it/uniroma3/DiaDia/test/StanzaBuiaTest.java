package it.uniroma3.DiaDia.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.DiaDia.Ambienti.Stanza;
import it.uniroma3.DiaDia.Ambienti.StanzaBuia;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private Stanza s = new StanzaBuia("DarkRoom", "lanterna");
	private Attrezzo att = new Attrezzo("lanterna", 2);
	
	@Test
	public void testGetDescrizioneNonHoAttrezzo() {
		assertEquals("Qui c'è buio pesto!!", s.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneHoAttrezzo() {
		s.addAttrezzo(att);
		assertEquals(s.toString(), s.getDescrizione());
	}
	

	

}
