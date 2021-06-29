package car.auto;

import static car.gui.LettoreImmagini.leggiImmagineVettura;
import static car.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;

import car.sim.Coordinate;
import car.sim.Zona;

/**
 * Modella le fasi del ciclo di vista di una vettura {@link Bianca}.
 * <B>(VEDI DOMANDA 2)</B>
 */
public class Bianca extends Auto{
	
	static final private Image IMMAGINE_VETTURA_BIANCA = leggiImmagineVettura(java.awt.Color.WHITE);

	public Bianca(Zona zona) {		
		super(zona);
	}

	public Coordinate decidiProssimaDestinazione() {
		return posizioneCasuale();
	}

	public Image getImmagine() {
		return IMMAGINE_VETTURA_BIANCA;
	}

}
