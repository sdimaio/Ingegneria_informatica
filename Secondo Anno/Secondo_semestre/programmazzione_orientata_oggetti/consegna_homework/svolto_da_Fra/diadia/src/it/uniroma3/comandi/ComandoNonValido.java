package it.uniroma3.comandi;


import it.uniroma3.diadia.IO;

import it.uniroma3.partita.Partita;

public class ComandoNonValido implements Comando{

private IO io;

	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("cosa vuoi fare? inserisci comando valido");

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
		
		return "comando non valido";
	}


}
