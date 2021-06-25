package it.uniroma3.DiaDia.Ambienti;

import java.util.Set;

import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private String dir;
	private String att;
	public StanzaBloccata(String nome) {
		super(nome);
		this.dir = new String("nord");
		this.att = new String("piedediporco");
	}

	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!direzione.equals(dir))
			return super.getStanzaAdiacente(direzione);
		else if(!hasAttrezzo(att))
			return this;
		return super.getStanzaAdiacente(direzione);
	}

	@Override 
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(getNome());
		risultato.append("\nUscite: ");
		for (String direzione : getDirezioni())
			if (direzione!=null) {
				if(!dir.equals(direzione))
					risultato.append(" " + direzione);
				else
					risultato.append(" " + "bloccata(" + dir + ")");
			}
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : getAttrezzi()) {
			if(attrezzo!=null) {
				risultato.append(attrezzo.toString()+" ");
			}
		}
		return risultato.toString();
	}

	@Override 
	public String getDescrizione() {
		return this.toString();
	}
	//	@Override
	//	public String getDescrizione() {
	//		System.out.println("Questa è una stanza bloccata nella direzione "+ dir );
	//		return this.toString();
	//	}

}
