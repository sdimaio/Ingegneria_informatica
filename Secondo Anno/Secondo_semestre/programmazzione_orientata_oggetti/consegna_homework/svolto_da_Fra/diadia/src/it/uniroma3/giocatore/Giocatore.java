package it.uniroma3.giocatore;
import it.uniroma3.attrezzi.*;
/**
 * classe che modella un giocatore 
 *
 * @author  Francesco Saverio Conforti
 */
public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	public Borsa borsa=new Borsa();
public  Giocatore() {//* se dichiaro cosi lancio direttamente il metodo senza fare giocatore.giocatore();
	
	this.cfu =CFU_INIZIALI;
	
}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
 public String getBorsa() {
	 return this.borsa.toString();
 }
	public void setAttrezzo(Attrezzo attrezzo) {
 	this.borsa.addAttrezzo(attrezzo);
 }
	public boolean IsVivo() {
		return this.cfu >0;
	}
}
