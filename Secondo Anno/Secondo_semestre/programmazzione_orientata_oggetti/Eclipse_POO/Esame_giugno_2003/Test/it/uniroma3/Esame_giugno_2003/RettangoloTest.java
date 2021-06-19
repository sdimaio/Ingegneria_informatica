package it.uniroma3.Esame_giugno_2003;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class RettangoloTest {
	
	private Punto vertice;
	private Rettangolo ret;
	
	@Before
	public void setUp() {
		this.vertice = new Punto(1,1);
		this.ret = new Rettangolo(vertice, 10, 13);
	}
	@Test
	public void testTrasla_asseX() {
		ret.trasla(+1,0);
		assertEquals(2, ret.getVertice().getX());
		assertEquals(1, ret.getVertice().getY());
	}
	
	public void testTrasla_asseY() {
		ret.trasla(0,+1);
		assertEquals(1, ret.getVertice().getX());
		assertEquals(2, ret.getVertice().getY());
	}

}
