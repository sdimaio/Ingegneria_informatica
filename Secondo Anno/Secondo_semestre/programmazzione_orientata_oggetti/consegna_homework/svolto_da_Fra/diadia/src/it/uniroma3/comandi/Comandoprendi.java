package it.uniroma3.comandi;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.partita.Partita;

public class Comandoprendi implements Comando {
private IO io;
private String nomeoggetto;
	@Override
	public void esegui(Partita partita) {
		Attrezzo oggetto = partita.getStanzaCorrente().getAttrezzo(nomeoggetto);
    	if (partita.getStanzaCorrente().hasAttrezzo(nomeoggetto)) {
    	partita.getGiocatore().borsa.addAttrezzo(oggetto);
    	partita.getStanzaCorrente().removeAttrezzo(oggetto);
    	this.io.mostraMessaggio("Ho aggiunto l'attrezzo:\t"+nomeoggetto+"\tprendendolo dalla stanza:\t"+partita.getStanzaCorrente().getNome());
    	
    	this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
    	this.io.mostraMessaggio(partita.getGiocatore().getBorsa());
    	}
    	else
    		this.io.mostraMessaggio("non puoi prendere oggetti inesistenti");

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeoggetto=parametro;

	}

	@Override
	public void setIO(IO io) {
		this.io=io;

	}
     public String getparametro(){
    	 return this.nomeoggetto;
}

	@Override
	public String getParametro() {
		
		return this.nomeoggetto;
	}

	@Override
	public String getNome() {
		
		return "prendi";
	}
}
