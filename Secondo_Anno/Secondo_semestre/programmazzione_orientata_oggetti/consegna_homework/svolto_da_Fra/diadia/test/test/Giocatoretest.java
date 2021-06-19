package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.giocatore.Giocatore;

public class Giocatoretest {

	private Giocatore studente;
	private Attrezzo a;
	@Before
	public void setUp(){
		studente=new Giocatore();
		a=new Attrezzo("matita",1);
	}
	@Test
	public void testSetCfu() {
		this.studente.setCfu(10);
		assertEquals("errore, doveva essere 10",10,this.studente.getCfu());
	}
	@Test
	public void testGetCfuIniziali() {
		assertEquals("errore, doveva essere 20",20,this.studente.getCfu());
	}
	@Test
	public void testSetAttrezzo() {
		this.studente.setAttrezzo(a);
		assertNotEquals("Borsa vuota",this.studente.getBorsa());
	}
    @Test
    public void testGetBorsa() {
    	assertNotNull(studente.getBorsa());
    }
    @Test 
    public void testIsvivo() {
    	studente.setCfu(2);
    	assertTrue("sono vivo", studente.IsVivo());
    }
    @Test 
    public void testIsmorto() {
    	studente.setCfu(0);
    	assertFalse("sono vivo", studente.IsVivo());
    }
}
