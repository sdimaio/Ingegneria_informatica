package dist.pers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dist.sim.Ambiente;
import dist.sim.Coordinate;

public class DistrattaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMossa() {
		Ambiente a = new Ambiente();
		Distratta p = new Distratta(a, new Coordinate(15, 15));
		
		a.addOstacolo(16, 16);
		a.addOstacolo(14,14);
		a.addOstacolo(14, 16);
		
		a.add(p);
		
		p.mossa();
		
		assertEquals(new Coordinate(16, 14),p.getPosizione());
		
	}

}
