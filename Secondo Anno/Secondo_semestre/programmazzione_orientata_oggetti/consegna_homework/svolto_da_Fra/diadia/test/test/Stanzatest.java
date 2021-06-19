package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.ambienti.*;
import it.uniroma3.attrezzi.*;
/**
 * classe di test per la classe stanza
 * 
 * 
 * @author Francesco Saverio Conforti
 *
 */
public class Stanzatest {
	//* dichiaro delle stanze
	private Stanza bar;
	private Stanza stanzaPienaNonAdiacente;
	private Stanza mensa;
	private Stanza patio;
	private Stanza stanzasud;
	private Stanza stanzavuota;
	private Stanza inutile;
	//* dichiaro piu del massimo degli attrezzi possibili da salvare
	private Attrezzo spada;
	private Attrezzo pala;
	private Attrezzo secchio;
	private Attrezzo lavandino;
	private Attrezzo piatto;
	private Attrezzo forchetta;
	private Attrezzo balestra;
	private Attrezzo calcolatrice;
	private Attrezzo martello;
	private Attrezzo piccone;
	private Attrezzo cassa;
	private Attrezzo tavolettagrafica;
	
	
	
	@Before //* per eseguire prima del test effettivo
	public void alloca() {
		//* istanzio oggetti di tipo stanza
		this.mensa = new Stanza("mensa");
		this.bar = new Stanza ("bar");
		this.stanzaPienaNonAdiacente = new Stanza("stanzapienanonadiacente");
		this.patio = new Stanza("patio");
		this.inutile = new Stanza ("inutile");
		//* istanzio oggetti di tipo attrezzo
		this.stanzavuota = new Stanza ("stanzavuota");
		this.stanzasud = new Stanza("stanzasud");
		this.spada = new Attrezzo("spada",10);
		this.pala = new Attrezzo ("pala", 10);
		this.secchio = new Attrezzo ("secchio",5);
		this.lavandino = new Attrezzo ("lavandino",25);
		this.piatto = new Attrezzo("piatto",1);
		this.forchetta = new Attrezzo("forchetta",1);
		this.balestra = new Attrezzo ("balestra",10);
		this.calcolatrice= new Attrezzo("calcolatrice", 2);
		this.martello = new Attrezzo("martello",8);
		this.piccone = new Attrezzo("piccone", 8);
		this.cassa =new Attrezzo("cassa ",12);
		this.tavolettagrafica = new Attrezzo("tavolettagrafica",3);
		//* imposto adiacenze
		mensa.impostaStanzaAdiacente("ovest", bar);
		mensa.impostaStanzaAdiacente("sud", patio);
		stanzasud.impostaStanzaAdiacente("nord", stanzavuota);
		stanzavuota.impostaStanzaAdiacente("est", patio);
		bar.addAttrezzo(balestra);
		
	}
	//* testo la funzione getter delle adiacenze
	@Test
	public void testAdiacenzaOvest() {
		assertEquals("Adiacenza errata",bar,this.mensa.getStanzaAdiacente("ovest"));
	}
	@Test
	public void testAdiacenzaSud() {
		assertEquals("Adiacenza errata",patio,this.mensa.getStanzaAdiacente("sud"));
	}
	@Test
	public void testAdiacenzaNord() {
		assertEquals("Adiacenza errata",stanzavuota,this.stanzasud.getStanzaAdiacente("nord"));
	}
	@Test
	public void testAdiacenzaEst() {
		assertEquals("Adiacenza errata",patio,this.stanzavuota.getStanzaAdiacente("est"));
	}
	//* ora passio al test della funzione impostaadiacenza
	@Test
	public void testImpostaAdiacenzaNord() {
		this.stanzaPienaNonAdiacente.impostaStanzaAdiacente("nord", mensa);
		assertEquals("impostazione adiacenza errata",mensa, this.stanzaPienaNonAdiacente.getStanzaAdiacente("nord"));
	}
	@Test
	public void testImpostaAdiacenzaSud() {
		this.stanzaPienaNonAdiacente.impostaStanzaAdiacente("sud", bar);
		assertEquals("impostazione adiacenza errata",bar, this.stanzaPienaNonAdiacente.getStanzaAdiacente("sud"));
	}
	@Test
	public void testImpostaAdiacenzaOvest() {
		this.stanzaPienaNonAdiacente.impostaStanzaAdiacente("ovest", patio);
		assertEquals("impostazione adiacenza errata",patio, this.stanzaPienaNonAdiacente.getStanzaAdiacente("ovest"));
	}
	@Test
	public void testImpostaAdiacenzaEst() {
		this.stanzaPienaNonAdiacente.impostaStanzaAdiacente("est", stanzavuota);
		assertEquals("impostazione adiacenza errata",stanzavuota, this.stanzaPienaNonAdiacente.getStanzaAdiacente("est"));
	}
	@Test
	public void testImpostaAdiacenzaDirezioneNulla() {
		this.stanzaPienaNonAdiacente.impostaStanzaAdiacente(null, bar);
		assertNull("Attenzione adiacenza nulla", this.stanzaPienaNonAdiacente.getStanzaAdiacente(null));
	//* l'oggetto deve essere nullo altrimenti assert ritorna false
	}
	@Test
	public void testImpostaAdiacenzaDirezioneInesistente() {
		this.stanzaPienaNonAdiacente.impostaStanzaAdiacente("destra", bar);
		assertNotSame("Attenzione adiacenza nulla", this.stanzaPienaNonAdiacente.getStanzaAdiacente(null));
	
	}
	@Test
	public void testImpostaAdiacenzaStanzaNulla() {
		this.stanzaPienaNonAdiacente.impostaStanzaAdiacente("nord", inutile);
		assertNotNull("Attenzione sto passando stanza nulla", this.stanzaPienaNonAdiacente.getStanzaAdiacente("nord"));
	//* l'oggetto deve essere nullo altrimenti assert ritorna false
	}
	@Test
	public void testImpostaAdiacenzaTuttoNull() {
		this.stanzaPienaNonAdiacente.impostaStanzaAdiacente(null, null);
		assertNull("Attenzione deve essere tutto nullo", this.stanzaPienaNonAdiacente.getStanzaAdiacente(null));
}
	//* testo i getter per la descrizione
	@Test
	public void testgetDescrizioneVuota() {
		assertEquals("La stanza è vuota, dovrei avere descrizione vuota","inutile\nUscite: \nAttrezzi nella stanza: ", this.inutile.getDescrizione());
	}
	@Test
	public void testgetDescrizionePiena() {
		assertEquals("La stanza contiene uscite, dovrei avere descrizione non  vuota","mensa\nUscite:  ovest sud\nAttrezzi nella stanza: ", this.mensa.getDescrizione());
	}
	@Test
	public void testAddAttrezzoStanzaPiena(){
		this.stanzaPienaNonAdiacente.addAttrezzo(balestra);
		this.stanzaPienaNonAdiacente.addAttrezzo(calcolatrice);
		this.stanzaPienaNonAdiacente.addAttrezzo(cassa);
		this.stanzaPienaNonAdiacente.addAttrezzo(forchetta);
		this.stanzaPienaNonAdiacente.addAttrezzo(lavandino);
		this.stanzaPienaNonAdiacente.addAttrezzo(martello);
		this.stanzaPienaNonAdiacente.addAttrezzo(pala);
		this.stanzaPienaNonAdiacente.addAttrezzo(piatto);
		this.stanzaPienaNonAdiacente.addAttrezzo(piccone);
		this.stanzaPienaNonAdiacente.addAttrezzo(secchio);
		assertFalse("Non puoi aggiungere altro, la stanza è gia piena",this.stanzaPienaNonAdiacente.addAttrezzo(tavolettagrafica));
	}
	@Test
	public void TestAddAttrezzoStanzaVuota() {
		assertTrue("Doveva eseerci un attrezzo",this.stanzavuota.addAttrezzo(spada));
		
	}
	@Test
	public void TestAddAttrezzoNullo() {
		assertFalse(" Non doveva esserci alcun attrezzo",this.stanzavuota.addAttrezzo(null));
	}

	@Test
	public void testAddAttrezzohasattrezzo(){
		this.stanzaPienaNonAdiacente.addAttrezzo(balestra);
		this.stanzaPienaNonAdiacente.addAttrezzo(calcolatrice);
		this.stanzaPienaNonAdiacente.addAttrezzo(cassa);
		this.stanzaPienaNonAdiacente.addAttrezzo(forchetta);
		this.stanzaPienaNonAdiacente.addAttrezzo(lavandino);
		this.stanzaPienaNonAdiacente.addAttrezzo(martello);
		this.stanzaPienaNonAdiacente.addAttrezzo(pala);
		this.stanzaPienaNonAdiacente.addAttrezzo(piatto);
		this.stanzaPienaNonAdiacente.addAttrezzo(piccone);
		this.stanzaPienaNonAdiacente.addAttrezzo(secchio);
		assertTrue(" Non doveva esserci alcun attrezzo",this.stanzaPienaNonAdiacente.hasAttrezzo("piatto"));
	}
	@Test
	public void testRimuoviAttrezzo() {
		assertTrue("l'attrezzo doveva essere rimosso",bar.removeAttrezzo(balestra));
	}
	@Test
	public void testRimuoviAttrezzoStanzaVuota() {
		assertFalse("non puoi rimuovere oggetti da una stanza vuota",stanzavuota.removeAttrezzo(balestra));
	}
	}
