package it.uniroma3.DiaDia.Ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class LabirintoBuilder {

	private Labirinto labirinto;
	private Stanza ultimaAggiunta;
	private Map<String, Stanza> stanze;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.stanze = new HashMap<String, Stanza>();
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
		Stanza iniziale = new Stanza(nomeStanzaIniziale);
		this.labirinto.setStanzaCorrente(iniziale);
		this.aggiungiAMappaEAggiornaUltima(iniziale);
		return this;
	}

	public LabirintoBuilder addStanza(String s) {
		Stanza stanza = new Stanza(s);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String s) {
		Stanza stanza = new StanzaMagica(s);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String s, String attrezzoPerVedere) {
		Stanza stanza = new StanzaBuia(s, attrezzoPerVedere);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String s, String attrezzoSloccante, String direzioneBloccata) {
		Stanza stanza = new StanzaBloccata(s, attrezzoSloccante, direzioneBloccata);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		this.ultimaAggiunta.addAttrezzo(attrezzo);
		return this;
	}
	public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
		Stanza vincente = new Stanza(nomeStanzaVincente);
		this.labirinto.setStanzaVincente(vincente);
		this.aggiungiAMappaEAggiornaUltima(vincente);
		return this;
	}
	public LabirintoBuilder addAdiacenza(String origine, String adiacente, String direzione ) {
		this.stanze.get(origine).impostaStanzaAdiacente(direzione, this.stanze.get(adiacente));
		return this;
	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	private void aggiungiAMappaEAggiornaUltima(Stanza s) {
		this.ultimaAggiunta = s;
		this.stanze.put(s.getNome(), s);
	}

}
