
package it.uniroma3.partita;


import it.uniroma3.ambienti.Stanza;
import it.uniroma3.giocatore.Giocatore;
import it.uniroma3.ambienti.Labirinto;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {



	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;

	Labirinto lab= new Labirinto();
	Giocatore giocatore= new Giocatore();
	public Partita(){
		
		lab.creaLabirinto();
		this.finita = false;

		 stanzaCorrente = lab.getCorrente();  
			stanzaVincente = lab.getFine();
	}

    
	public Stanza getStanzaVincente() {
		return stanzaVincente;
		
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

  public Giocatore getGiocatore() {
	  return giocatore;
  }


public boolean giocatoreIsVivo() {
	return this.getGiocatore().IsVivo();//* posso usare anche this.giocatore. isvivo ma è preferibile usare il getter
}
}
