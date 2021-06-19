package it.uniroma3.comandi;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.IO;
import it.uniroma3.partita.Partita;

public class ComandoVai implements Comando {
private String direzione;
private IO io;
	@Override
	public void esegui(Partita partita) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			
			this.io.mostraMessaggio("ti trovi ancora in\t");}
		else{
		partita.setStanzaCorrente(prossimaStanza);
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1); 
			this.io.mostraMessaggio("hai\t"+ partita.getGiocatore().getCfu()+ "\tcfu");
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio(partita.getGiocatore().getBorsa());

	}

	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
		
	}

	@Override
	public String getParametro() {
		
		return this.direzione;
	}

	@Override
	public String getNome() {
		
		return "vai";
	}

}
