package it.uniroma3.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.partita.Partita;

public class ComandoAiuto implements Comando {
private IO io;
static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi","posa","guarda"};
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");

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
		
		return "aiuto";
	}

}
