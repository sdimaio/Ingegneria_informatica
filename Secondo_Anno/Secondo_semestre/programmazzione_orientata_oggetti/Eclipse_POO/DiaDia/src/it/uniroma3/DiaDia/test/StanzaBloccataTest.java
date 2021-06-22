package it.uniroma3.DiaDia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.Ambienti.Stanza;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private Partita p = new Partita();
	private Stanza bib = new Stanza("Biblioteca");
	private Stanza N10 = p.getStanzaCorrente().getStanzaAdiacente("sud");
	private Attrezzo att = new Attrezzo("piedediporco", 1);
	private String dirBlock = new String("nord");
	private String dir = "sud";
	
	@Test
	public void testGetStanzaAdiacenteNoAtrezzo() {
		assertEquals(p.getStanzaCorrente(), p.getStanzaCorrente().getStanzaAdiacente(dirBlock));
	}
	
	@Test
	public void testGetStanzaAdiacenteHoAtrezzo() {
		p.getStanzaCorrente().addAttrezzo(att);
		bib.impostaStanzaAdiacente("sud", p.getStanzaCorrente());
		assertEquals(bib.toString(), p.getStanzaCorrente().getStanzaAdiacente(dirBlock).toString());
	}
	
	@Test
	public void testGetStanzaAdiacenteNoDirezioneNoAtrezzo() {
		assertEquals(N10, p.getStanzaCorrente().getStanzaAdiacente(dir));
	}

	@Test
	public void testGetDescrizione() {
		assertEquals(p.getStanzaCorrente().toString(),p.getStanzaCorrente().getDescrizione());
	}

}