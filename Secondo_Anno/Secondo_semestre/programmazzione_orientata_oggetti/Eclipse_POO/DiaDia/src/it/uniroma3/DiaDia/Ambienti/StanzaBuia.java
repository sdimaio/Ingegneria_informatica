package it.uniroma3.DiaDia.Ambienti;


public class StanzaBuia extends Stanza {
	private String s;
	
	public StanzaBuia(String nome, String attrezzoPerVedere) {
		super(nome);
		this.s = attrezzoPerVedere;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(s)) {
			return this.toString();
		}
		return "Qui c'è buio pesto!!";
		
	}
	

}
