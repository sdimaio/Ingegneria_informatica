package it.uniroma3.giocatore;
import it.uniroma3.attrezzi.*;
/**
 * classe che modella una borsa per il giocatore 
 *
 * @author  Francesco Saverio Conforti
 */
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}
	 /**
     * aggiunge un attrezzo alla borsa.
     *
     * @param attrezzo il nome dell'attrezzo.
     * @return boolean true se l'aggiunta ha avuto successo, false altrimenti
     */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		boolean ris;
		if (attrezzo!=null) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			ris =false;}
		
		if (this.numeroAttrezzi==10) {
			ris= false;}
		else {
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		ris= true;}
		}
		else {
			ris= false;}
		return ris;
		
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++) 
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	 /**
     * per sapere il peso della borsa
     *
     * 
     * @return int peso della borsa
     */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if(attrezzi[i]!=null)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	 /**
     * rimuove un attrezzo alla borsa.
     *
     * @param attrezzo il nome dell'attrezzo.
     * @return boolean true se la rimozione ha avuto successo, false altrimenti
     */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		boolean rimosso;
		rimosso =false;
		int i=0;
		while(!rimosso && i< this.attrezzi.length) {
			if (attrezzi[i]!=null) {
				if (attrezzi[i].getNome().equals(nomeAttrezzo)) {
					attrezzi[i]=null;
					rimosso=true;
					this.numeroAttrezzi--;
				attrezzi[i]=attrezzi[i+1];
				}
		}
			i++;
			
		}
		
		return rimosso;
	}
	 /**
     * riporta la borsa in stringa.
     *
     * 
     * @return  string contenente le specifiche di borsa
     */
		
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			
			for (int i= 0; i<this.numeroAttrezzi; i++) {
				if (attrezzi[i]!=null)
				s.append(attrezzi[i].toString()+" ");
			}
		}
		else 
			s.append("Borsa vuota");
		return s.toString();
	}
	
}
