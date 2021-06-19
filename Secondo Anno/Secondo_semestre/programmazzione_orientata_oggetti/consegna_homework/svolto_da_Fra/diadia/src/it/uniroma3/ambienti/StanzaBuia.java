package it.uniroma3.ambienti;



public class StanzaBuia extends Stanza{
	
	private String sblocco;	
	/**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */ 
    public StanzaBuia(String nome, String oggetto) {
        super(nome);
        this.sblocco=oggetto;
    }
    
    
    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
   */
  
     @Override
    public String getDescrizione() {
    	String risultato= new String();
    	if (this.hasAttrezzo(sblocco))
         risultato=this.toString();
    	else 
    		risultato= ("non si vede nulla\n");
  return risultato;
    }

   
}
