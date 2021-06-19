package test;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.StanzaBuia;
import it.uniroma3.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia buia;

	private Attrezzo torcia;

	@Before
public void Alloca() {

this.buia=new StanzaBuia("buia","torcia");
this.torcia=new Attrezzo("torcia",1);


}

	@Test
	public void testGetDescrizione() {
		buia.addAttrezzo(torcia);
		assertEquals("si deve vedere","buia\nUscite: \nAttrezzi nella stanza: torcia (1kg) ", buia.getDescrizione());
	}

	@Test
	public void testGetDescrizioneNoAttrezzo() {
		
		assertEquals(" non si deve vedere","non si vede nulla\n", buia.getDescrizione());
	}

}
