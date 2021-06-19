package it.uniroma3.Esame_giugno_2003;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GruppoDiFormeTest {

	private GruppoDiForme vuoto;
	private GruppoDiForme gruppoCerchioUnitarioSingleton;
	
	private GruppoDiForme gruppoEsterno;
	private Punto origine;
	private Cerchio unitario;


	@Before
	public void setUp() {
		this.origine = new Punto(0,0);
		this.unitario = new Cerchio(origine, 1);
		this.vuoto = new GruppoDiForme();
		this.gruppoEsterno = new GruppoDiForme();
		this.gruppoCerchioUnitarioSingleton = new GruppoDiForme();
		this.gruppoCerchioUnitarioSingleton.aggiungiForma(this.unitario);
	}	
	
	@Test
	public void testTraslaDiUnGruppoDiGruppiConSoloCerchiounitario() {
		//Creo un gruppo, inserisco un solo cerchio unitario
		//cerco un gruppo con dentro solo il gruppo di cui sopra 
		this.gruppoEsterno.aggiungiForma(this.gruppoCerchioUnitarioSingleton);
		
		//asserisco la posizione del centro del cerchio 
		//traslo il gruppo esterno(che contiene il gruppo con il solo cerchio)
		assertEquals(0, this.unitario.getCentro().getX());
		assertEquals(0, this.unitario.getCentro().getY());
		//asserisco che il cerchio risulta spostato
		this.gruppoEsterno.trasla(+1, +1);
	}

	@Test
	public void testAggiungiForma() {
		final GruppoDiForme nidificato = new GruppoDiForme();
		this.vuoto.aggiungiForma(nidificato);
		assertEquals(1, this.vuoto.getNumeroDiForme());
	}

}
