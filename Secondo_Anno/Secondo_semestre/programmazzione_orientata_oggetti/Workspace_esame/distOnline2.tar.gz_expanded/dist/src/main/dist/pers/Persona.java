package dist.pers;


import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dist.sim.Ambiente;
import dist.sim.Coordinate;
import dist.sim.GeneratoreCasuale;

public abstract class Persona {

	
	private final int id;
	private Ambiente ambiente;
	private Coordinate posizione;    // posizione corrente

	
	public Persona(Ambiente ambiente, int progId) {		
		this.ambiente = ambiente;
		this.posizione = GeneratoreCasuale.posizioneCasuale();
		this.id = progId;
	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public abstract Image getImmagine();

	public abstract void mossa();

	public int getId() {
		return this.id;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}


	@Override
	public String toString() {
		return this.getClass().getSimpleName()+getId();
	}

}
