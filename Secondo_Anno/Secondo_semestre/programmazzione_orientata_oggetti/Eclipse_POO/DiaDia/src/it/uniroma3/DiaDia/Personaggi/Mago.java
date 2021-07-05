package it.uniroma3.DiaDia.Personaggi;

import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{

	private Attrezzo attrezzo;
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
