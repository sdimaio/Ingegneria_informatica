package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;
import static bici.sim.GeneratoreCasuale.generaNposizioniCasuali;
import static bici.sim.CostantiSimulazione.N_DESTINAZIONI;

import java.awt.Image;
import java.util.List;
import java.util.Collections;

import bici.sim.Coordinate;
import bici.sim.Zona;

public class Gialla extends Bici {
	
	static final private Image IMMAGINE_BICI_GIALLA = leggiImmagineBici(java.awt.Color.YELLOW);
	
	private static List<Coordinate> coordinateDisponibili = generaNposizioniCasuali(N_DESTINAZIONI);
	
	private static int progId; 
	
	private final int id;
	
	public Gialla(Zona zona) {
		super(zona);
		this.id = progId++;
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public Image getImmagine() {
		return IMMAGINE_BICI_GIALLA;
	}
	
	@Override
	public Coordinate decidiProssimaDestinazione() {
		Collections.shuffle(coordinateDisponibili);
		return coordinateDisponibili.get(0);
	}
}
