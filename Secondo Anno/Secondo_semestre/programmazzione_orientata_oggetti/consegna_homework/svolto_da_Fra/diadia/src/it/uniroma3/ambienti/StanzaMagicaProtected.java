package it.uniroma3.ambienti;
import it.uniroma3.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	final static protected int SOGLIA_MAGICA_DEFAULT = 3;
	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
		}
	public StanzaMagicaProtected(String nome,int soglia) {
		super(nome);//*per usare il costruttore della vecchia stanza 
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
		attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
		}
	
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
		return attrezzo;
		}
	 
}
