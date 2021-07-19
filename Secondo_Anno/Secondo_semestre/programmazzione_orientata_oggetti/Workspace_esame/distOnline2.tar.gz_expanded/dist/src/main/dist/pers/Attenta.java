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

	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);
	
	static private int progId;
	
	public Attenta(Ambiente ambiente) {
		super(ambiente, progId++);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	
	}
	
	public void mossa() {
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		List<Coordinate> possibili = new LinkedList<>();
		
		for(Coordinate c : adiacenti) {
			if(this.getAmbiente().getPersona(c).isEmpty())
				possibili.add(c);
		}
		Collections.shuffle(possibili);
		
		this.setPosizione(possibili.get(0));
	}


}
