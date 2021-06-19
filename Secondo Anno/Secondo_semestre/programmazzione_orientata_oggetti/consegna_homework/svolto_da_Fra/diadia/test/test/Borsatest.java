package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.giocatore.Borsa;

public class Borsatest {

	private Borsa borsaPiena;
	private Borsa borsaVuota;
	private Borsa borsaUnElemento;
	private Attrezzo pettine;
	private Attrezzo forbici;
	private Attrezzo portafoglio;
	private Attrezzo spada;
	private Attrezzo pala;
	private Attrezzo secchio;
	private Attrezzo lavandino;
	private Attrezzo piatto;
	private Attrezzo forchetta;
	private Attrezzo balestra;
	private Attrezzo calcolatrice;
	
	private Attrezzo piccone;
	
	@Before
	public void setUp(){
		this.borsaUnElemento=new Borsa();
		this.borsaPiena=new Borsa();
		this.borsaVuota=new Borsa();
		this.pettine=new Attrezzo("pettine",1);
		this.forbici=new Attrezzo("forbici",1);
		this.spada= new Attrezzo ("spada",1);
		this.pala= new Attrezzo ("pala",1);
		this.secchio= new Attrezzo ("secchio",1);
		this.lavandino= new Attrezzo ("lavandino",1);
		this.piatto= new Attrezzo ("piatto",1);
		this.forchetta= new Attrezzo ("forchetta",1);
		this.balestra= new Attrezzo ("balestra",1);
		this.portafoglio= new Attrezzo ("portafoglio",1);
		this.calcolatrice= new Attrezzo ("calcolatrice",1);
		this.piccone= new Attrezzo ("piccone",300);
		this.borsaPiena.addAttrezzo(calcolatrice);
		this.borsaUnElemento.addAttrezzo(portafoglio);
	}
	@Test
	public void testRemoveBorsaVuota() {
		assertFalse("Errore non potevi rimuovere ,la borsa doveva essere vuota.", this.borsaVuota.removeAttrezzo("portafoglio"));
	}
	@Test
	public void testRemoveBorsaUnElemento() {
		assertTrue("la borsa deve risultare vuota.", this.borsaUnElemento.removeAttrezzo("portafoglio"));
	}
	@Test
	public void testRemoveBorsaPienaAttrezzoSbagliato() {
		this.borsaPiena.addAttrezzo(portafoglio);
		this.borsaPiena.addAttrezzo(spada);
		this.borsaPiena.addAttrezzo(pala);
		this.borsaPiena.addAttrezzo(secchio);
		this.borsaPiena.addAttrezzo(lavandino);
		this.borsaPiena.addAttrezzo(piatto);
		this.borsaPiena.addAttrezzo(forchetta);
		this.borsaPiena.addAttrezzo(balestra);
		this.borsaPiena.addAttrezzo(calcolatrice);
		
		assertFalse("Errore,l'attrezzo è presente e lo zaino è pieno",this.borsaPiena.removeAttrezzo("pettine"));
	}
	@Test
	public void testAddBorsaPiena() {
		this.borsaPiena.addAttrezzo(portafoglio);
		this.borsaPiena.addAttrezzo(spada);
		this.borsaPiena.addAttrezzo(pala);
		this.borsaPiena.addAttrezzo(secchio);
		this.borsaPiena.addAttrezzo(lavandino);
		this.borsaPiena.addAttrezzo(piatto);
		this.borsaPiena.addAttrezzo(forchetta);
		this.borsaPiena.addAttrezzo(balestra);
		this.borsaPiena.addAttrezzo(calcolatrice);
		this.borsaPiena.addAttrezzo(piccone);
		assertFalse("Errore, non dovrebbe aggiungerlo",this.borsaPiena.addAttrezzo(forbici));
	}
	@Test
	public void testAddBorsaVuota() {
		assertTrue("errore,avrebbe dovuto aggiungerla.",this.borsaVuota.addAttrezzo(pettine));
	}
	@Test
	public void testAddVuoto() {
		assertFalse("errore, sto aggiungendo null", this.borsaVuota.addAttrezzo(null));
	}
	@Test
	public void testRemoveVuoto() {
		assertFalse("Sto rimuovendo null",this.borsaPiena.removeAttrezzo(null));
	}
	@Test
	public void testRemoveBorsaPiena() {
		this.borsaPiena.addAttrezzo(portafoglio);
		this.borsaPiena.addAttrezzo(spada);
		this.borsaPiena.addAttrezzo(pala);
		this.borsaPiena.addAttrezzo(secchio);
		this.borsaPiena.addAttrezzo(lavandino);
		this.borsaPiena.addAttrezzo(piatto);
		this.borsaPiena.addAttrezzo(forchetta);
		this.borsaPiena.addAttrezzo(balestra);
		this.borsaPiena.addAttrezzo(calcolatrice);
		this.borsaPiena.addAttrezzo(piccone);
		assertFalse("rimuovo male",this.borsaPiena.removeAttrezzo("piccone"));
	}
	
}
