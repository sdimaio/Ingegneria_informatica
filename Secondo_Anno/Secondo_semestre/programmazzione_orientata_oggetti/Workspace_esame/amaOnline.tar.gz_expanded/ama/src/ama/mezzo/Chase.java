package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_VERDE;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Chase extends Politica{

	static private int progId=0;
	
	private Citta citta;
	
	public Chase(Citta citta) {
		super();
		this.id = progId++;
		this.citta = citta;
	}
	
	public Citta getCitta() {
		return this.citta;
	}
	
	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		final Posizione posizioneRifiutoNelleVicinanze = 
				this.getCitta().getRifiutoVicinoA(corrente);
		if (posizioneRifiutoNelleVicinanze==null) 
			return corrente.traslazioneUnitaria(deltaCasuale(),deltaCasuale());
		else return posizioneRifiutoNelleVicinanze;
	}
	
	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_VERDE;
	}

}
