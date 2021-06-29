package car.auto;

import static car.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;
import java.util.Objects;
import java.util.Set;

import car.sim.Coordinate;
import car.sim.Direzione;
import car.sim.Tragitto;
import car.sim.Zona;

public abstract class Auto {

	static private int progId = 0;

	private int id;

	private Zona zona;

	private Coordinate posizione; // posizione corrente

	private Direzione direzione;  // direzione corrente

	private Coordinate origine;

	private Coordinate destinazione;

	public Auto(Zona zona) {		
		this.zona = zona;
		this.id = progId++;
		final Coordinate posizioneIniziale = posizioneCasuale();
		this.posizione = posizioneIniziale;
		this.origine = posizioneIniziale;
		this.destinazione = null;
		this.direzione = null;
	}
	
	public abstract Coordinate decidiProssimaDestinazione();
	
	public abstract Image getImmagine();

	public int getId() {
		return this.id;
	}

	public Zona getZona() {
		return this.zona;
	}

	protected void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public Direzione getDirezione() {
		return this.direzione;
	}

	protected void setDirezione(Direzione nuova) {
		this.direzione = nuova;
	}

	public void simula(int passo) {
		/* destinazione iniziale gia' fissata? */
		if (this.destinazione==null) {
			this.destinazione = decidiProssimaDestinazione();
		} else if (destinazioneRaggiunta()) {
			/* tieni traccia del tragitto percorso */
			final Tragitto tragitto = new Tragitto(this,this.origine,this.destinazione);
			this.getZona().add(tragitto);
			this.origine = this.destinazione;
			this.destinazione = decidiProssimaDestinazione();			
		}
		direzionaVerso(this.destinazione);
		eseguiSpostamento();
	}
 
		
	private boolean destinazioneRaggiunta() {
		return this.getPosizione().equals(this.destinazione);
	}

	private void direzionaVerso(Coordinate dest) {
		final Direzione verso = Direzione.verso(this.getPosizione(),dest);
		final Set<Direzione> possibili = getPossibiliDirezioni();
		if (possibili.contains(verso)) 
			this.setDirezione(verso);
		else this.setDirezione(Direzione.scegliAcasoTra(possibili));
	}

	private void eseguiSpostamento() {
		this.setPosizione(this.getPosizione().trasla(this.getDirezione()));
	}

	private Set<Direzione> getPossibiliDirezioni() {
		return this.getZona().getPossibiliDirezioni(this.getPosizione());
	}

	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public boolean equals(Object o) {
		final Bianca that = (Bianca)o;
		return Objects.equals(this.getId(), that.getId());
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}

