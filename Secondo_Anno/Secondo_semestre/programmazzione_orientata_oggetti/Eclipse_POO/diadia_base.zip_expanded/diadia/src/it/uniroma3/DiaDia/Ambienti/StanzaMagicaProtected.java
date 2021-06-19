package it.uniroma3.DiaDia.Ambienti;

import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	static final private int SOGlIA_MAGICA_DEFAULT = 3;

	private int sogliaMagica;
	private int contatoreAttrezziPosati;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGlIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		sogliaMagica = soglia;
		contatoreAttrezziPosati = 0; 
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati > this.sogliaMagica) 
			attrezzo = this.modificaAttrezzo(attrezzo);
		if (this.numeroAttrezzi<this.attrezzi.length) { 
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else return false;
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoDoppio = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoDoppio);

		return attrezzo;
	}

}
