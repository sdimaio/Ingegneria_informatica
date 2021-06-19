package it.uniroma3.DiaDia.Ambienti;


public class StanzaBuia extends Stanza {
	private String s;
	
	public StanzaBuia(String nome) {
		super(nome);
		this.s = new String("lanterna");
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(s)) {
			return this.toString();
		}
		return "Qui c'è buio pesto!!";
		
	}
	

}
