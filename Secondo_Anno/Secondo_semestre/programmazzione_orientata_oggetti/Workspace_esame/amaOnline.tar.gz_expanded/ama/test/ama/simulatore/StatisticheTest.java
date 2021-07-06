package ama.simulatore;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Citta;
import ama.Posizione;
import ama.mezzo.Brown;
import ama.mezzo.Chase;
import ama.mezzo.Mezzo;
import ama.mezzo.Pendo;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final static private Posizione ORIGINE = new Posizione(0, 0);
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
	}

	/* N.B. E' POSSIBILE USARE I  METODI CHE SEGUONO (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	private Vetro creaVetroRaccoltoDaBrowniano() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaBrowniano());	
		return rifiuto;
	}

	
	private Vetro creaVetroRaccoltoDaChaser() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaChaser());	
		return rifiuto;
	}
	
	private Set<Rifiuto> creaVetroRaccoltoDaMezzoDue(Mezzo m) {
		Set<Rifiuto> smaltiti = new HashSet<>();
		final Vetro rifiuto = new Vetro(ORIGINE);
		final Vetro rifiuto2 = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(m);
		rifiuto2.setRaccoltoDa(m);
		smaltiti.add(rifiuto);
		smaltiti.add(rifiuto2);
		return smaltiti;
	}
	
	/* N.B. E' POSSIBILE USARE I METODI SOPRA (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	
	@Test
	public void testRaccoltoPerMezzo() {
		/* DA COMPLETARE VEDI DOMANDA 3 */
		Rifiuto r = creaVetroRaccoltoDaBrowniano();
		Set<Rifiuto> smaltiti = new HashSet<Rifiuto>();
		smaltiti.add(r);
		Mezzo racc = r.getRaccoglitore();
		Integer i = 1;
		assertEquals(i, stats.raccoltoPerMezzo(smaltiti).get(racc));
	}
	
	@Test
	public void testRaccoltoPerMezzoDiversi() {
		/* DA COMPLETARE VEDI DOMANDA 3 */
		Rifiuto r = creaVetroRaccoltoDaBrowniano();
		Rifiuto r1 = creaVetroRaccoltoDaBrowniano();
		Set<Rifiuto> smaltiti = new HashSet<Rifiuto>();
		smaltiti.add(r);
		smaltiti.add(r1);
		Mezzo racc = r.getRaccoglitore();
		Mezzo racc1 = r1.getRaccoglitore();
		Integer i = 1;
		Integer i2 = 1;
		assertEquals(i, stats.raccoltoPerMezzo(smaltiti).get(racc));
		assertEquals(i2, stats.raccoltoPerMezzo(smaltiti).get(racc1));
	}
	
	@Test
	public void testRaccoltoPerMezzoDue() {
		/* DA COMPLETARE VEDI DOMANDA 3 */
		Mezzo m = new Mezzo(simulatore, new Pendo(new Citta()));
		Set<Rifiuto> smaltiti = this.creaVetroRaccoltoDaMezzoDue(m);
		
		Integer i = 2;
		assertEquals(i, stats.raccoltoPerMezzo(smaltiti).get(m));
	}

	
	@Test
	public void testRaccoltoPerPolitica() {
		/* DA COMPLETARE VEDI DOMANDA 4 */
		Mezzo m = new Mezzo(simulatore, new Pendo(new Citta()));
		Mezzo m1 = new Mezzo(simulatore, new Chase(new Citta()));
		Mezzo m2 = new Mezzo(simulatore, new Brown());
		Set<Rifiuto> smaltiti = this.creaVetroRaccoltoDaMezzoDue(m);
		smaltiti.addAll(this.creaVetroRaccoltoDaMezzoDue(m1));
		smaltiti.addAll(this.creaVetroRaccoltoDaMezzoDue(m2));
		
		Map<Class<?>, Integer> expected= new HashMap<>();
		expected.put(Pendo.class, 2);
		expected.put(Chase.class, 2);
		expected.put(Brown.class, 2);
		
		assertEquals(expected, stats.raccoltoPerPolitica(smaltiti));
	}
	
	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */

}
