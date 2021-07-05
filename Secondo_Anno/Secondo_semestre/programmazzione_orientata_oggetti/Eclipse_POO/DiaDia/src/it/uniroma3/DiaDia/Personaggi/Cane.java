package it.uniroma3.DiaDia.Personaggi;

import it.uniroma3.DiaDia.Partita;

public class Cane extends AbstractPersonaggio {

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		return null;
	}

	@Override
	public String saluta() {
		return "BARK!! BARK!!";
	}

}
