package it.uniroma3.DiaDia.Giocatore;

public class Giocatore {
	
	private int cfu;
	private Borsa bag;
	
	public Giocatore(){
		bag = new Borsa();
		
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public Borsa getBorsa() {
		return this.bag;
	}
	
	public boolean isVivo() {
		return this.cfu>0;
	}
		
}
