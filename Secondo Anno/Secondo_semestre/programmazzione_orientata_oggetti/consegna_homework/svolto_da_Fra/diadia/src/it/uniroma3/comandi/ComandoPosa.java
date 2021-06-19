package it.uniroma3.comandi;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.partita.Partita;

public class ComandoPosa implements Comando {
private String nomeoggetto;
private IO io;
	@Override
	public void esegui(Partita partita) {
		
	    	if(partita.getGiocatore().borsa.hasAttrezzo(nomeoggetto)) {
	    	Attrezzo oggetto = partita.getGiocatore().borsa.getAttrezzo(nomeoggetto);
	    	partita.getGiocatore().borsa.removeAttrezzo(nomeoggetto);
	    	partita.getStanzaCorrente().addAttrezzo(oggetto);
	    	
	   	
	    	this.io.mostraMessaggio("Ho aggiunto l'attrezzo:\t"+nomeoggetto+"\talla stanza:\t"+partita.getStanzaCorrente().getNome());
	    	this.io.mostraMessaggio(partita.getGiocatore().getBorsa());
	    	this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	    }
	    	else 
	    		this.io.mostraMessaggio("non puoi lasciare oggetti che non hai");
	    }

	

	@Override
	public void setParametro(String parametro) {
		this.nomeoggetto=parametro;

	}

	@Override
	public void setIO(IO io) {
		this.io=io;

	}



	@Override
	public String getParametro() {
	
		return this.nomeoggetto;
	}



	@Override
	public String getNome() {
		
		return "posa";
	}

}
