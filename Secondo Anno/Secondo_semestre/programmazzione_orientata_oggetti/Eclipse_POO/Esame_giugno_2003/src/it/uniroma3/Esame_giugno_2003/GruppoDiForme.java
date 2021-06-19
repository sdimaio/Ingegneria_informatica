package it.uniroma3.Esame_giugno_2003;

public class GruppoDiForme implements Forma {

	private static final int MX_NUMERO_DI_FORME_GRUPPO = 10;
	private Forma[] componenti; 
	//Rappresentazione sparsa: Forma[i] nullo se non presente

	//Rappresentazione compatta: la prime "n" posizioni sone sempre occupate
	// da un rif. non nulla se il gruppo ospita n forme

	public GruppoDiForme() {
		this.componenti = new Forma[MX_NUMERO_DI_FORME_GRUPPO];
	}

	public void trasla(int deltaX, int deltaY) {
		//semantica: trasla tutte le componenti
		for(int i=0; i<this.componenti.length; i++) {
			if(this.componenti[i] != null){
				this.componenti[i].trasla(deltaX, deltaY);
			}
		}
	}

	public boolean aggiungiForma(Forma nuovaArrivata) {
		for(int i=0; i<this.componenti.length; i++) {
			if(this.componenti[i] == null){
				this.componenti[i] = nuovaArrivata;
				return true;
			}
		}
		return false;
	}

	public Object getNumeroDiForme() {
		int counter = 0;
		for(int i=0; i<this.componenti.length; i++) {
			if(this.componenti[i] != null){
				counter++;
			}
		}
		return counter;
	}
}
