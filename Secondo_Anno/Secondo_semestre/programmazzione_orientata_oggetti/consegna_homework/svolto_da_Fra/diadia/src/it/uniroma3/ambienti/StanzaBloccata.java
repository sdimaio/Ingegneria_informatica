package it.uniroma3.ambienti;



public class StanzaBloccata extends Stanza {
	private String DirezioneBloccata;
	private String Passepartout;
	private boolean spostamenti;
 public StanzaBloccata(String nome, String direzione, String oggetto) {
		super(nome);
		this.DirezioneBloccata=direzione;
		this.Passepartout=oggetto;		
 }
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		 Stanza stanza = null;
		 spostamenti=false;
		if(direzione.equals(DirezioneBloccata)&&! super.hasAttrezzo(Passepartout)) {
			spostamenti =false;
			stanza = this;
		}
		else {
		spostamenti=true;
		stanza= super.getStanzaAdiacente(direzione);}
		return stanza;
	}
	@Override
	public String getDescrizione() {
		String out =null;
	if(!this.hasAttrezzo(Passepartout)&&!spostamenti) {
		out =("La stanza è bloccata, non puoi andare avanti/n"+"ti trovi in:\n"+this.toString());
	}
	else 
		out =super.toString();
	return out;
	}
}
