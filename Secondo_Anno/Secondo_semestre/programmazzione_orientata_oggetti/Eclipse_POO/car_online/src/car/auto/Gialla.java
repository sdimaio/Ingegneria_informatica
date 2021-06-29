package car.auto;

import static car.gui.LettoreImmagini.leggiImmagineVettura;
import static car.sim.GeneratoreCasuale.generaNposizioniCasuali;

import java.awt.Image;
import java.util.Collections;
import java.util.List;

import car.sim.Coordinate;
import car.sim.Zona;

public class Gialla extends Auto{
	
	static final private Image IMMAGINE_VETTURA_GIALLLA = leggiImmagineVettura(java.awt.Color.YELLOW);
	static private List<Coordinate> destinazioni = generaNposizioniCasuali(5);
	
	public Gialla(Zona zona) {
		super(zona);
	}
	
	@Override
	public  Image getImmagine() {
		return IMMAGINE_VETTURA_GIALLLA;
	}

	@Override
	public Coordinate decidiProssimaDestinazione() {
		Collections.shuffle(destinazioni);
		return destinazioni.get(0);
	}
}
