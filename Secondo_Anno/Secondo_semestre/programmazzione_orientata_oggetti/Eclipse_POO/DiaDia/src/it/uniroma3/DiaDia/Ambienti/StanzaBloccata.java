package it.uniroma3.DiaDia.Ambienti;



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
		super.toString();
		return "La stanza è bloccata nella direzione:" + dir;
		
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
