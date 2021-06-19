package test;
import it.uniroma3.ambienti.*;
import it.uniroma3.partita.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Partitatest {

	// controllo vittoria
		private Partita partita1;
		private Stanza corrente1;
		private Partita partita2;
		private Partita partita3;


		//controllo partita finita
		private Partita partita4;
		private Partita partita5;
		private Partita partita6;
		private Partita partita7;
		private Partita partita8;
		private Partita partita9;
		private Partita partita10;

		

		@Before
		public void setUp() {
			
			this.partita1=new Partita();
			this.corrente1=new Stanza("Corrente1");
			this.partita1.setStanzaCorrente(corrente1);

			//stanza corrente e vincente uguali 
			this.partita2=new Partita();
			this.partita2.setStanzaCorrente(this.partita2.getStanzaVincente());


			//una è null
			this.partita3=new Partita();


			//per vedere se la partita è finita

			this.partita4=new Partita();  //finita1 vinta0 cfu1
			this.partita4.setFinita();
			this.partita4.getGiocatore().getCfu();
			


			this.partita5=new Partita();
			this.partita5.setStanzaCorrente(this.partita5.getStanzaVincente());
			this.partita5.getGiocatore().setCfu(0);

			this.partita6=new Partita();

			this.partita7=new Partita();
			this.partita7.setFinita();
			this.partita7.setStanzaCorrente(this.partita7.getStanzaVincente());
			this.partita7.getGiocatore().setCfu(0);



			this.partita8=new Partita();
			this.partita8.setFinita(); //se l'utente esce senza giocare

			this.partita9=new Partita(); //finita e vinta
			this.partita9.setFinita();
			this.partita9.setStanzaCorrente(this.partita9.getStanzaVincente());

			this.partita10=new Partita();
			this.partita10.getGiocatore().setCfu(0);

		}

		@Test
		public void testPartitaCorrenteNonVincente() {  // stanza corrente != vincente 
			assertEquals(false,this.partita1.vinta());

		}
		@Test
		public void testPartitaCorrenteVincente() {					// stanza corrente == vincente
			assertEquals(true,partita2.vinta());
		}
		@Test
		public void testPartitaCorrenteNulla() { 					// stanza corrente == null
			assertEquals(false, partita3.vinta());
		}
		@Test
		public void testPartitaFinitaNonVinta() {// partita finita, cfu 0, vinta 0
			assertEquals(true, partita4.isFinita());
		}
		@Test
		public void testPartitaEsauritoIcrediti() {			// finita 0, vinta 0, cfu 1
			assertEquals(true,partita5.isFinita());
		}
		@Test
		public void testPartitaInSospeso() {			//cfu 0, finita 0, vinta 0
			assertEquals(false,partita6.isFinita());
		}
		@Test
		public void testPartitaVintaFinita() { 			//finita 1, vinta 1, cfu 1
			assertEquals(true,partita7.isFinita());
		}
		@Test
		public void testFinitaBruscamente() {					// finita 1, vinta 0, cfu 0
			assertEquals(true,partita8.isFinita());
		}
		@Test
		public void testFinitaVinta() {					// finita 1, vinta 1, cfu 0
			assertEquals(true,partita9.isFinita());

		}
		@Test
		public void testNonVintaEsauritoCrediti() { 			// finita 1, vinta 0, cfu 1
			assertEquals(true,partita10.isFinita());
		}


}
