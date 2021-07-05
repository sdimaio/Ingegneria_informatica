package it.uniroma3.DiaDia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.DiaDia.Ambienti.Labirinto;
import it.uniroma3.DiaDia.Ambienti.LabirintoBuilder;
import it.uniroma3.DiaDia.Ambienti.Stanza;

public class LabirintoTest {

	private Stanza salone;
	private Stanza stanza;
	private Labirinto lab = new LabirintoBuilder()
			 .addStanzaIniziale("LabCampusOne")
			 .addStanzaVincente("Biblioteca")
			 .addAdiacenza("LabCampusOne","Biblioteca","ovest")
			 .getLabirinto();
//	@Before
//	public void setUp() {
//		this.labirinto = new LabirintoBuilder()
//				 .addStanzaIniziale("LabCampusOne")
//				 .addStanzaVincente("Biblioteca")
//				 .addAdiacenza("LabCampusOne","Biblioteca","ovest")
//				 .getLabirinto();
//	}
	
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaVincenteFalse() {
		assertNotEquals("Atrio", lab.getStanzaVincente());
	}
	
	@Test
	public void testSetStanzaCorrenteNot() {
		salone = lab.getStanzaCorrente();	
		stanza = new Stanza("Garage");
		lab.setStanzaCorrente(stanza);
		
		assertNotEquals(salone.getNome(), lab.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		
		assertEquals("LabCampusOne", lab.getStanzaCorrente().getNome());
	}

	@Test
	public void testGetStanzaCorrente() {
		salone = new Stanza("Salotto"); 
		lab.setStanzaCorrente(salone);
		
		assertEquals(salone.getNome(), lab.getStanzaCorrente().getNome());
	}
	

}
