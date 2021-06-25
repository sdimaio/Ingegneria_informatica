package it.uniroma3.DiaDia.Giocatore;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoAttuale;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); // speriamo che bastino...
		this.pesoAttuale = 0;
	}

	/* aggiunge un attrezzo alla borsa solamente se sia 
	 * ha peso minore di 10 e meno di 10 attrezzi*/

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		//		if (this.numeroAttrezzi==10)
		//			return false;
		Attrezzo vecchio = this.attrezzi.put(attrezzo.getNome(), attrezzo);
		if(vecchio != null)
			this.pesoAttuale -= vecchio.getPeso();
		this.pesoAttuale += attrezzo.getPeso();
		//		this.numeroAttrezzi++;
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	public int getPeso() {
//		int peso = 0;
		//		for(String chiave : this.attrezzi.keySet()) 
		//			peso += this.attrezzi.get(chiave).getPeso();
		//		for(Map.Entry<String, Attrezzo> entry : this.attrezzi.entrySet())
		//			peso += entry.getVaule().getPeso();
		return pesoAttuale;
	}
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.hasAttrezzo(nomeAttrezzo)) 
			this.pesoAttuale -= this.getAttrezzo(nomeAttrezzo).getPeso();
		
		return this.attrezzi.remove(nomeAttrezzo);

	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.attrezzi.values().toString());
		}
		else 
			s.append("Borsa vuota");
		return s.toString();
	}
}