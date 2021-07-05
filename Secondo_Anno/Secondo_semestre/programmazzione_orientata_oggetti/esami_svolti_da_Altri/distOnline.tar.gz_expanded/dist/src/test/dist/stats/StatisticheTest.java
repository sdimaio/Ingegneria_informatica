package dist.stats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dist.pers.Attenta;
import dist.pers.Distratta;
import dist.pers.Persona;
import dist.sim.Contatto;

public class StatisticheTest {

	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
	}

	@Test
	public void testProduciStatisticaVuota() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		assertTrue(stats.produciStatistiche(new HashSet<Contatto>()).isEmpty());

	}

	@Test
	public void testProduciStatistica() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )

		Set<Contatto> contatti = new HashSet<>();
		Set<Persona> coinvolti1 = new HashSet<>();
		Set<Persona> coinvolti2 = new HashSet<>();
		Set<Persona> coinvolti3 = new HashSet<>();

		Attenta a1 = new Attenta(null);
		Attenta a2 = new Attenta(null);
		Distratta d1 = new Distratta(null);
		Distratta d2 = new Distratta(null);

		coinvolti1.add(d1);
		coinvolti1.add(d2);
		coinvolti1.add(a1);

		coinvolti2.add(a2);
		coinvolti2.add(d2);
		
		coinvolti3.add(d2);

		contatti.add(new Contatto(1, coinvolti1, null));
		contatti.add(new Contatto(2, coinvolti3, null));
		contatti.add(new Contatto(3, coinvolti2, null));

		Map<Persona, List<Contatto>> test = stats.produciStatistiche(contatti);
		
		assertEquals(1, test.get(d2).get(0).getCoinvolti().size());
		assertEquals(2, test.get(d2).get(1).getCoinvolti().size());
		assertEquals(3, test.get(d2).get(2).getCoinvolti().size());

		System.out.println(test.get(d2).size());

	}


}


