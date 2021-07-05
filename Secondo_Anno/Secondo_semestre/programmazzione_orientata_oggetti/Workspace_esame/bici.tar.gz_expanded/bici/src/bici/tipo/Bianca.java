package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;

import static bici.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;

import bici.sim.Coordinate;
import bici.sim.Zona;

/**
 * Modella le fasi del ciclo di vista di una bicicletta {@link Bianca}.
 * <B>(VEDI DOMANDA 2)</B>
 */
public class Bianca extends Bici {

	static final private Image IMMAGINE_BICI_BIANCA = leggiImmagineBici(java.awt.Color.WHITE);
	
	private static int progId; 
	
	private final int id;
	
	public Bianca(Zona zona) {
		super(zona);
		this.id = progId++;
		
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public Image getImmagine() {
		return IMMAGINE_BICI_BIANCA;
	}
	
	@Override
	public Coordinate decidiProssimaDestinazione() {
		return posizioneCasuale();
	}
	
}
