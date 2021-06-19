package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;

public class ComandoGuarda implements Comando {
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio("Ciocatore: " + partita.ciocatore.getCfu() + " " + "CFU");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

}
