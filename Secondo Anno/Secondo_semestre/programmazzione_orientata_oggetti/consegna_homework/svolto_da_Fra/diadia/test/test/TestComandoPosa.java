package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.comandi.ComandoPosa;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

import it.uniroma3.partita.Partita;

public class TestComandoPosa {
	private Stanza stanza;
	private Attrezzo spada;

	private IO io;
	private Partita p1;
	private ComandoPosa c;
	@Before
	public void setUp()  {
		this.stanza=new Stanza("stanza");
		this.spada=new Attrezzo("spada",1);
		
		
		this.p1= new Partita();
		this.c=new ComandoPosa();
		this.io =new IOConsole();
		this.c.setIO(io);
		this.p1.setStanzaCorrente(stanza);
	}
     @Test
     public void TestPrendi() {
    	 this.p1.getGiocatore().borsa.addAttrezzo(spada);
    	 this.c.setParametro("spada");
    	 this.c.esegui(p1);
    	 
    	 assertEquals("dovevano essere uguali", "Borsa vuota", this.p1.getGiocatore().getBorsa());
    	 assertEquals("dovevano essere uguali", "stanza\n"
    	 		+ "Uscite: \n"
    	 		+ "Attrezzi nella stanza: spada (1kg) ", this.stanza.getDescrizione());
     }
     @Test
     public void TestPrendiAttrezzoInesistente() {
    	 this.c.setParametro("spada");
    	 this.c.esegui(p1);
    	 assertEquals("dovevano essere uguali", "Borsa vuota", this.p1.getGiocatore().getBorsa());
    	 assertEquals("dovevano essere uguali", "stanza\n"
    	 		+ "Uscite: \n"
    	 		+ "Attrezzi nella stanza: ", this.stanza.getDescrizione());
     }
     
     

}