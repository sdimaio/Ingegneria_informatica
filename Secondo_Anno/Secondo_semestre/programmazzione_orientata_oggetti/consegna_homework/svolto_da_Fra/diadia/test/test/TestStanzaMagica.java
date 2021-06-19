package test;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.ambienti.StanzaMagica;
import it.uniroma3.attrezzi.Attrezzo;

public class TestStanzaMagica {
private Stanza magica;

private Attrezzo pala;
private Attrezzo piccone;
private Attrezzo spada;
private Attrezzo ascia;
	@Before
	public void setUp(){
		this.magica=new StanzaMagica("magica");
		this.pala=new Attrezzo("pala",2);
		this.piccone=new Attrezzo("piccone",2);
		this.spada=new Attrezzo("spada",2);
		this.ascia=new Attrezzo("ascia",2);
		
	}


	@Test
	public void testAddAttrezzo() {
		this.magica.addAttrezzo(ascia);
		this.magica.addAttrezzo(pala);
		this.magica.addAttrezzo(piccone);
		this.magica.addAttrezzo(spada);
		assertEquals("si deve girare","magica\nUscite: \nAttrezzi nella stanza: ascia (2kg) pala (2kg) piccone (2kg) adaps (4kg) ", magica.getDescrizione());
	}

	

}
