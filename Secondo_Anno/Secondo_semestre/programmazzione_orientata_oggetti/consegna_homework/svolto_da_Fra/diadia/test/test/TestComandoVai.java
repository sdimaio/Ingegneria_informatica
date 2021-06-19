package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.comandi.ComandoVai;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.partita.Partita;

public class TestComandoVai {
	private Partita p;
	private ComandoVai vai;
	private IO io;
	private Stanza stanza1;
	private Stanza stanza2;
	
	@Before
	public void setUp() {
		this.io=new  IOConsole();
		this.p=new Partita();
		this.vai=new ComandoVai();
		this.vai.setIO(io);
		this.stanza1=new Stanza("stanza1");
		this.stanza2=new Stanza("stanza2");
		this.p.setStanzaCorrente(stanza1);
		this.stanza1.impostaStanzaAdiacente("sud", stanza2);
	
	}

	@Test
	public void testEseguiDirezioneSbagliata() {
		this.vai.esegui(this.p);
		this.vai.setParametro("nord");
		assertEquals("non ti puoi spostare, la direzione è sbagliata","stanza1"
				,this.p.getStanzaCorrente().getNome());
	}

	@Test
	public void testEseguiDirezioneEsistente() {
		this.vai.esegui(this.p);
		this.vai.setParametro("null");
		
		assertEquals("La direzione è corretta ,ti dovresti spostare","stanza1",this.p.getStanzaCorrente().getNome());
	}

	@Test
	public void testEseguiDirezioneInesistente() {
		this.vai.esegui(this.p);
		this.vai.setParametro("sud");
		
		assertEquals("non ti puoi spostare, la direzione è inesistente","stanza1",this.p.getStanzaCorrente().getNome());
	}
}
