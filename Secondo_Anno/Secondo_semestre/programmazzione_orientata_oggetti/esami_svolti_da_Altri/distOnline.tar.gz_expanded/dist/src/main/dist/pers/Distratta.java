package dist.pers;

import static dist.gui.CostantiGUI.RISORSA_IMMAGINE_ROSSO;
import static dist.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dist.sim.Ambiente;
import dist.sim.Coordinate;


public class Distratta extends Persona {

	static final private Image IMMAGINE_ROSSA = leggiImmagineOggetto (RISORSA_IMMAGINE_ROSSO);
	static private int progId;
	private final int id;

	public Distratta(Ambiente ambiente) {
		super(ambiente);
		this.id = progId++;
	}

	
	public Distratta(Ambiente a, Coordinate coordinate) {
		super(a);
		super.setPosizione(coordinate);
		this.id = progId++;
		
	}


	@Override
	public void mossa() {
		List<Coordinate> adiacenti = new LinkedList<>(super.getAmbiente().adiacentiA(super.getPosizione()));
		Collections.shuffle(adiacenti);
		super.setPosizione(adiacenti.get(0));
	}


	@Override
	public int getId() {
		return id;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_ROSSA;
	}

}
