package it.uniroma3.DiaDia;

import it.uniroma3.DiaDia.Ambienti.Labirinto;
import it.uniroma3.DiaDia.Ambienti.Stanza;
import it.uniroma3.DiaDia.Giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	
	static final private int CFU_INIZIALI = 20;
	private boolean finita;

	
	
	public Labirinto labirintoCorrente;
	public Giocatore ciocatore;
	
	public Partita(Labirinto labirinto){
		labirintoCorrente = labirinto;
		//this.labirintoCorrente.creaStanze();
		this.finita = false;
		ciocatore = new Giocatore();
		ciocatore.setCfu(CFU_INIZIALI);
	}
	/*
	 * stanzaCorrente = labirintoCorrente.getStanzaCorrente()
	 * stanzaVincente = labirintoCorrente.getStanzaVincente()
	 * */

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirintoCorrente.getStanzaCorrente()== this.labirintoCorrente.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (ciocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Stanza getStanzaCorrente() {
		return labirintoCorrente.getStanzaCorrente();
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		labirintoCorrente.setStanzaCorrente(stanzaCorrente);
	}
	
	public Giocatore getGiocatore() {
		return this.ciocatore;
	}
	
	public boolean GiocatoreIsVivo() {
		return ciocatore.isVivo();
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirintoCorrente = labirinto;
	}
	
	
}
