package dist.pers;


import java.awt.Image;
import dist.sim.Ambiente;
import dist.sim.Coordinate;
import dist.sim.GeneratoreCasuale;

public abstract class  Persona {



	private Ambiente ambiente;
	private Coordinate posizione;    // posizione corrente

	public Persona(Ambiente ambiente) {		
		this.ambiente = ambiente;
		this.posizione = GeneratoreCasuale.posizioneCasuale();

	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public abstract int getId();
	public abstract Image getImmagine();
	public abstract void mossa();
	
	
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
