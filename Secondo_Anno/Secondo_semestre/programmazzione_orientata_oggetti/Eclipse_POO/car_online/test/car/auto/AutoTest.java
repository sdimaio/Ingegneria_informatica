package car.auto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import car.sim.Zona;

/** 
 * Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite<BR/>
 * RIVEDERE {@link #testIdProgressiviPerBianche()}<BR/>
 * COMPLETARE {@link #testIdProgressiviPerGialle()}<BR/>
 * <B>(VEDI DOMANDA 2)</B>
 */
public class AutoTest {

	private Zona zona;
	
	@Before
	public void setUp() throws Exception {
		this.zona = new Zona();
	}

	@Test
	public void testIdProgressiviPerBianche() {
		// DA RIVEDERE VEDI DOMANDA 2
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, new Bianca(this.zona).getId());
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, new Bianca(this.zona).getId());
	}

	@Test
	public void testIdProgressiviPerGialle() {
		// DA COMPLETARE VEDI DOMANDA 2
		fail("DA COMPLETARE");
	}

}
