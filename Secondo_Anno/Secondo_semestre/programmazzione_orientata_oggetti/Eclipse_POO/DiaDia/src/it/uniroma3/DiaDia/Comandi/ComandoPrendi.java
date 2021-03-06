package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;

public class ComandoPrendi implements Comando {
	private String attrezzo;
	private IO io;
	
	public ComandoPrendi() {
		this.setParametro(attrezzo);
	}
	/**
	 * Prende un oggetto dalla stanza e lo inserisce nella borsa
	 */
	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().hasAttrezzo(attrezzo)){
			boolean a =	partita.ciocatore.getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(attrezzo));
			boolean b = partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(attrezzo));
			if(a && b)
				this.io.mostraMessaggio("Attrezzo preso con successo");
			else
				this.io.mostraMessaggio("Vi ? stato un problema nel prendere l'attrezzo");

		}
		else {
			this.io.mostraMessaggio("L'attrezzo cercato non ? presente nella stanza");
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;

	}
	@Override
	public String getParametro() {
		return this.attrezzo;
	}
	@Override
	public String getNome() {
		return "prendi";
	}
	@Override
	public void setIO(IO io) {
		this.io = io;
	}

}
