package dist.stats;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dist.pers.Distratta;
import dist.pers.Persona;
import dist.sim.Ambiente;
import dist.sim.Contatto;
import dist.sim.Coordinate;
import dist.sim.Simulatore;

public class StatisticheTest {

	@SuppressWarnings("unused")
	private Statistiche stats;
	private Simulatore simulatore;;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
	}
	
	@Test
	public void testProduciStatisticaVuota() {
		Set<Contatto> c  = new HashSet<>();
		assertEquals(Collections.EMPTY_MAP, this.stats.produciStatistiche(c));
	}
	
	@Test
	public void testProduciStatisticaUnaDirezione() {
		Map<Persona, List<Contatto>> mappa = new HashMap<>();
		Coordinate coor = new Coordinate(2, 3);
		List<Contatto> contatti = new ArrayList<>();
		Ambiente ambiente = new Ambiente();
		Persona p1 = new Distratta(ambiente);
		Set<Persona> per  = new HashSet<>();
		per.add(p1);
		Contatto c = new Contatto(23, per, coor);
		contatti.add(c);
		mappa.put(p1, contatti);
		this.simulatore.add(c);
		
		String expected = new String("{"+ p1.toString()+"=[[Contatto: era 23, #coinvolti 1]]}");
		assertEquals(expected, this.stats.produciStatistiche(this.simulatore.getContatti()).toString());
	}

}
