package dist.pers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dist.sim.Ambiente;
import dist.sim.Coordinate;

public class AttentaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMossa() {
		Ambiente a = new Ambiente();
		Attenta p = new Attenta(a, new Coordinate(15, 15));
		
		a.add(new Attenta(a, new Coordinate(16, 16)));
		a.add(new Attenta(a, new Coordinate(14, 14)));
		a.add(new Attenta(a, new Coordinate(14, 16)));
		
		a.add(p);
		
		p.mossa();
		
		assertEquals(new Coordinate(16, 14),p.getPosizione());
		
	}

}
