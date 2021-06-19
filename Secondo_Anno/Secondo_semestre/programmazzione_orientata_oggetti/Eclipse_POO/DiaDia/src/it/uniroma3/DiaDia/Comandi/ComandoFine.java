package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;

public class ComandoFine implements Comando {
	private IO io;
	/**
	 * Comando "Fine".
	 */
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Grazie di aver giocato!");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		return "fine";
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

}
