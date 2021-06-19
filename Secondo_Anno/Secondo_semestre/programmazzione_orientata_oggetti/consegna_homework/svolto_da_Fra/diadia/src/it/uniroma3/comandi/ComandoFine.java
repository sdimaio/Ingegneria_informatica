package it.uniroma3.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.partita.Partita;

public class ComandoFine implements Comando {
private IO io;
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Grazie di aver giocato!");

	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public void setIO(IO io) {
		 this.io=io;

	}

	@Override
	public String getParametro() {
		
		return null;
	}

	@Override
	public String getNome() {
		
		return "fine";
	}

	

}
