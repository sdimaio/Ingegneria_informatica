package test;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.ambienti.StanzaBloccata;
import it.uniroma3.attrezzi.Attrezzo;

public class TestStanzaBloccata {
private Stanza  bloccata;
private Attrezzo chiave;
private Stanza passaggio;
private Attrezzo piedediporco;
	@Before
	public void setUp()  {
		this.passaggio=new Stanza("passaggio");
		this.bloccata=new StanzaBloccata("bloccata","nord","chiave");
		this.passaggio.impostaStanzaAdiacente("sud", bloccata);
		this.bloccata.impostaStanzaAdiacente("nord", passaggio);
		this.chiave=new Attrezzo("chiave",1);
		this.piedediporco=new Attrezzo("piedediporco",10);
	}

	@Test
	public void testGetStanzaAdiacenteConChiave() {
		this.bloccata.addAttrezzo(chiave);
		assertEquals("Devo avere la descrizione di passaggio","passaggio\nUscite:  sud\nAttrezzi nella stanza: ", this.bloccata.getStanzaAdiacente("nord").getDescrizione());
	}
	@Test
	public void testGetStanzaAdiacenteSenzaChiave() {
		assertEquals("Devo avere la descrizione di bloccata","La stanza è bloccata, non puoi andare avanti/nti trovi in:\n"
				+ "bloccata\nUscite:  nord\nAttrezzi nella stanza: ", this.bloccata.getStanzaAdiacente("nord").getDescrizione());
	}
	@Test
	public void testGetStanzaAdiacenteConChiaveSbagliata() {
		this.bloccata.addAttrezzo(piedediporco);
		assertEquals("Devo avere la descrizione di bloccata","La stanza è bloccata, non puoi andare avanti/nti trovi in:\n"
				+ "bloccata\nUscite:  nord\nAttrezzi nella stanza: piedediporco (10kg) ", this.bloccata.getStanzaAdiacente("nord").getDescrizione());
	}

}
