package it.uniroma3.DiaDia.Ambienti;



public class StanzaBloccata extends Stanza{
	private String dir;
	private String att;
	public StanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		super(nome);
		this.att = attrezzoSbloccante;
		this.dir = direzioneBloccata;
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
		
		return (super.toString()+"\nLa stanza è bloccata nella direzione:" + dir);
		
	}
	
	

	@Override 
	public String getDescrizione() {
		return this.toString();
	}
	//	@Override
	//	public String getDescrizione() {
	//		System.out.println("Questa ï¿½ una stanza bloccata nella direzione "+ dir );
	//		return this.toString();
	//	}

}
