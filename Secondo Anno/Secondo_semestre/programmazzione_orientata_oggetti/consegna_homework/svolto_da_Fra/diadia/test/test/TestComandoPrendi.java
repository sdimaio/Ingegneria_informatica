package test;
import static org.junit.Assert.assertEquals;
import it.uniroma3.comandi.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.partita.*;
import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;

import it.uniroma3.diadia.*;
public class TestComandoPrendi {
	private Stanza stanza;
	private Attrezzo spada;

	private IO io;
	private Partita p1;
	private Comandoprendi c;
	@Before
	public void setUp()  {
		this.stanza=new Stanza("stanza");
		this.spada=new Attrezzo("spada",1);
	
		this.stanza.addAttrezzo(spada);
		this.p1= new Partita();
		this.c=new Comandoprendi();
		this.io =new IOConsole();
		this.c.setIO(io);
		this.p1.setStanzaCorrente(stanza);
	}
     @Test
     public void TestPrendi() {
    	 this.c.setParametro("spada");
    	 this.c.esegui(p1);
    	 
    	 assertEquals("dovevano essere uguali", "Contenuto borsa (1kg/10kg): spada (1kg) ", this.p1.getGiocatore().getBorsa());
    	 assertEquals("dovevano essere uguali", "stanza\n"
    	 		+ "Uscite: \n"
    	 		+ "Attrezzi nella stanza: ", this.stanza.getDescrizione());
     }
     @Test
     public void TestSetParametro() {
    	 this.c.setParametro("spada");
    	 assertEquals("doveva essere spada","spada",this.c.getparametro());
     }
     
     @Test
     public void TestPrendiAttrezzoInesistente() {
    	 this.c.setParametro("calcolatrice");
    	 this.c.esegui(p1);
    	 
    	 assertEquals("dovevano essere uguali", "Borsa vuota", this.p1.getGiocatore().getBorsa());
    	 assertEquals("dovevano essere uguali", "stanza\n"
    	 		+ "Uscite: \n"
    	 		+ "Attrezzi nella stanza: spada (1kg) ", this.stanza.getDescrizione());
     }
}
