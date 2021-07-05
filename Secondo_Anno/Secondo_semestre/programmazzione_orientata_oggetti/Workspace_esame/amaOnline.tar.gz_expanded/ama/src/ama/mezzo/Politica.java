package ama.mezzo;

import java.awt.Image;
import java.util.Random;

import ama.Posizione;

public abstract class Politica {
	
	final private Random rnd;
	
	public int id;
	
	public Politica() {
		rnd = new Random();
	}
	
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
	
	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */
	public int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}
	
	public int getId() {
		return this.id;
	}
	

	public abstract Image getImmagine();
	
	public abstract Posizione decidiDirezione(Posizione p);
}
