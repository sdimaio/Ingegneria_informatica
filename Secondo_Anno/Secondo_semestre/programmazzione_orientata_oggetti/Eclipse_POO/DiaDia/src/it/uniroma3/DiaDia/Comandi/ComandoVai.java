package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.Ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IO io;

	public ComandoVai() {
		this.setParametro(direzione);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione == null) {
			this.io.mostraMessaggio("Dove vuoi andare? Devi specificare uan direzione");

			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		this.io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);


	}
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	public String getParametro() {
		return this.direzione;
	}

	public String getNome() {
		return "vai"; 
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
