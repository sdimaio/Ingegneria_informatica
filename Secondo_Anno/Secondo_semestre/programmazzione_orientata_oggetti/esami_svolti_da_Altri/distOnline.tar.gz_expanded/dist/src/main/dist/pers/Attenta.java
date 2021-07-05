package dist.pers;

import static dist.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static dist.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dist.sim.Ambiente;
import dist.sim.Coordinate;


public class Attenta extends Persona{

	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto (RISORSA_IMMAGINE_BIANCO);
	static private int progId;
	private final int id;

	public Attenta(Ambiente ambiente) {
		super(ambiente);
		this.id = progId++;

	}
	
	//solo per test
	public Attenta(Ambiente a , Coordinate c) {
		super(a);
		super.setPosizione(c);
		this.id = progId++;
	}

	@Override
	public void mossa() {
		List<Coordinate> adiacenti = new LinkedList<>(super.getAmbiente().adiacentiA(super.getPosizione()));
		Collections.shuffle(adiacenti);
		for(Coordinate c : adiacenti){
			if(super.getAmbiente().getPersona(c).isEmpty()) {
				super.setPosizione(c);
				return;
			}
		}
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	}


}
