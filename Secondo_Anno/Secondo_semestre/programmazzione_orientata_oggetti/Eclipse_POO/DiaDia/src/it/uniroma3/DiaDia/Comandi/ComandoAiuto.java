package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;

public class ComandoAiuto implements Comando {

	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine","guarda"};
	private IO io;
	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		StringBuilder builder = new StringBuilder();
		for(String str : this.elencoComandi)
			builder.append(str + " ");

		this.io.mostraMessaggio(builder.toString());

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
		return "aiuto";
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
		
	}

}
