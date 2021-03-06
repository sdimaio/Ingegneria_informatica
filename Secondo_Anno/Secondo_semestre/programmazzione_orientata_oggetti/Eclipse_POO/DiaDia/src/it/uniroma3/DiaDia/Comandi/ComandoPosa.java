package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;

public class ComandoPosa implements Comando {
	private String attrezzo;
	private IO io;
	
	public ComandoPosa() {
		this.setParametro(attrezzo);
	}
	/**
	 * Prende un oggetto dalla borsa e lo posa nella stanza
	 */
	@Override
	public void esegui(Partita partita) {
		if(partita.ciocatore.getBorsa().hasAttrezzo(attrezzo)) {
			boolean c =partita.getStanzaCorrente().addAttrezzo(partita.ciocatore.getBorsa().removeAttrezzo(attrezzo));
			if(!c)
				this.io.mostraMessaggio("Qualcosa ? andato storto");
			else
				this.io.mostraMessaggio("L'attrezzo ? stato posato");
		}
		else
			this.io.mostraMessaggio("L'attrezzo cercato non ? presente nella borsa");

	}
	
	/*
	 * @Override
    public void esegui(Partita partita) {
        if(partita.ciocatore.getBorsa().hasAttrezzo(attrezzo)) {
            if(partita.getStanzaCorrente().addAttrezzo(partita.ciocatore.getBorsa().removeAttrezzo(attrezzo))) {
                System.out.println("E' stato posato l'oggetto nella stanza!");
            }
            else
                System.out.println("Qualcosa ? andato storto, non ? stato posato l'oggetto nella stanza!");
        }
        else
            System.out.println("L'attrezzo cercato non ? presente nella borsa!");
    }
	 */

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
		return "posa";
	}
	@Override
	public void setIO(IO io) {
		this.io = io;
	}

}
