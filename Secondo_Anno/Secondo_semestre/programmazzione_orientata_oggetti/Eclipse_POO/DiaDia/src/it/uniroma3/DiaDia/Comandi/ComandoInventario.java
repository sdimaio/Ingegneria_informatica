package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;

public class ComandoInventario implements Comando{
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio(partita.ciocatore.getBorsa().getContenutoOrdinatoPerNome().toString());
		this.io.mostraMessaggio(partita.ciocatore.getBorsa().getContenutoOrdinatoPerPeso().toString());
		this.io.mostraMessaggio(partita.ciocatore.getBorsa().getContenutoRaggruppatoPerPeso().toString());
		this.io.mostraMessaggio(partita.ciocatore.getBorsa().getSortedSetOrdinatoPerPeso().toString());
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
		return "inventario";
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

}
