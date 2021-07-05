package ama.mezzo;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

public class Pendo extends Politica {

	static private int progId=0;
	
	private Citta citta;
	private boolean toccato;
	
	public Pendo(Citta citta) {
		super();
		this.id = progId++;
		this.citta = citta;
		this.toccato = false;
	}
	
	public Citta getCitta() {
		return this.citta;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

	
	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		Posizione p = new Posizione(corrente.getX()+1, corrente.getY()); 
		Posizione p1 = new Posizione(corrente.getX()-1, corrente.getY()); 
		
		if(!this.getCitta().sulBordo(p) && !toccato)
			return corrente.traslazioneUnitaria(1, 0);
		else if(this.getCitta().sulBordo(p) && !toccato) {
			this.toccato = true;
			return corrente.traslazioneUnitaria(-1, 0);
		}
		else if(!this.getCitta().sulBordo(p1) && toccato)
			return corrente.traslazioneUnitaria(-1, 0);
		else {
			this.toccato = false;
			return corrente.traslazioneUnitaria(1, 0);
		}
	}
	

}
