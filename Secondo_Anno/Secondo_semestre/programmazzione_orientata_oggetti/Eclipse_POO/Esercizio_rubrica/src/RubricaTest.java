import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RubricaTest {
	
	private Rubrica r = new Rubrica();
	
	@Before
	public void setUp() {
		r.svuota();
	}
	
	@Test
	public void testInserisci() {
		fail("Not yet implemented");
	}

	@Test
	public void testRimuovi() {
		fail("Not yet implemented");
	}

	@Test
	public void testNomiInRubrica() {
		assertSame("[]", r.nomiInRubrica());
	}

	@Test
	public void testDammiIlNumeroDi() {
		String s1 = new String("Paolo");
		String s2 = new String("Pippo");
		r.inserisci(s1, 390112461);
		assertEquals(390112461, r.dammiIlNumeroDi(s1).intValue());
		assertNull(r.dammiIlNumeroDi(s2));
	}

	@Test
	public void testAggiornaNumero() {
		String s1 = new String("Paolo");
		r.inserisci(s1, 390112461);
		assertEquals(390112461, r.aggiornaNumero(s1, 39062888).intValue());
		assertEquals(39062888, r.dammiIlNumeroDi(s1).intValue());
	}

}
