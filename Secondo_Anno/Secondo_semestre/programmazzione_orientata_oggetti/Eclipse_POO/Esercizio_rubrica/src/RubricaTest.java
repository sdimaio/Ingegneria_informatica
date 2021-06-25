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
		String s1 = new String("Paolo");
		r.inserisci(s1, 5446654);
		
		assertEquals(5446654 ,r.dammiIlNumeroDi(s1).intValue());
	}

	@Test
	public void testRimuovi() {
		String s1 = new String("Paolo");
		r.inserisci(s1, 5446654);
		r.rimuovi(s1);
		assertNull(r.dammiIlNumeroDi(s1));
	}

	@Test
	public void testNomiInRubricaVuota() {
		String s1 = new String("Paolo");
		String s2 = new String("Pippo");
		r.inserisci(s1, 684647);
		r.inserisci(s2, 684547);
		Rubrica r2 = new Rubrica();
		assertNotEquals(r.nomiInRubrica(), r2.nomiInRubrica());
	
	}
	
	@Test
	public void testNomiInRubricaPiena() {
		String s1 = new String("Paolo");
		String s2 = new String("Pippo");
		r.inserisci(s1, 684647);
		r.inserisci(s2, 684547);
		Rubrica r2 = new Rubrica();
		r2.inserisci(s1, 684647);
		r2.inserisci(s2, 684547);
		assertEquals(r2.nomiInRubrica(), r.nomiInRubrica());
	
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
