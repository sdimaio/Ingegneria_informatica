package it.uniroma3.DiaDia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.Ambienti.Labirinto;
import it.uniroma3.DiaDia.Ambienti.LabirintoBuilder;
import it.uniroma3.DiaDia.Ambienti.Stanza;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private Labirinto lab = new LabirintoBuilder()
			 .addStanzaIniziale("LabCampusOne")
			 .addStanzaVincente("Biblioteca")
			 .addStanzaBloccata("Atrio", "piedediporco", "est")
			// .addAttrezzo("piedediporco", 2)
			 .addAdiacenza("LabCampusOne","Atrio","est")
			 .addAdiacenza("Atrio", "Biblioteca", "est")
			 .getLabirinto();
	private Partita p = new Partita(lab);
//	private Stanza bib = new Stanza("Biblioteca");
//	private Stanza N10 = p.getStanzaCorrente().getStanzaAdiacente("est");
//	private Attrezzo att = new Attrezzo("piedediporco", 1);
//	private String dirBlock = new String("est");
//	private String dir = "sud";

	@Test
	public void testGetStanzaAdiacenteNoAttrezzo() {
		assertNotEquals(lab.getStanzaVincente(),p.getStanzaCorrente().getStanzaAdiacente("est").getStanzaAdiacente("est"));
	}
	
	@Test
	public void testGetStanzaAdiacenteHoAttrezzo() {
		p.getStanzaCorrente().addAttrezzo(att);
		bib.impostaStanzaAdiacente("sud", p.getStanzaCorrente());
		assertEquals(bib.toString(), p.getStanzaCorrente().getStanzaAdiacente(dirBlock).toString());
	}
	
	@Test
	public void testGetStanzaAdiacenteNoDirezioneNoAttrezzo() {
		assertEquals(N10, p.getStanzaCorrente().getStanzaAdiacente(dir));
	}

	@Test
	public void testGetDescrizione() {
		assertEquals(N10.toString(),p.getStanzaCorrente().getStanzaAdiacente("est").getDescrizione());
	}

}
