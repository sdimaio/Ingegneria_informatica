package it.uniroma3.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.partita.Partita;

public class ComandoGuarda implements Comando {
private IO io;

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("stai guardando le caratteristiche della stanza \t"+partita.getStanzaCorrente().getNome());
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("le statistiche di questa partita sono:\n"+"hai \t"+ partita.getGiocatore().getCfu()+"\tcfu\n"+
		"ti trovi nella stanza:\t"+partita.getStanzaCorrente().getDescrizione()+"\n"+
		partita.getGiocatore().getBorsa());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
		
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		
		return "guarda";
	}

}
