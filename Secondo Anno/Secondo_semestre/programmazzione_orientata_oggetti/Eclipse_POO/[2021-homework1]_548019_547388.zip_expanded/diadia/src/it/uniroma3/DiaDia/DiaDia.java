package it.uniroma3.DiaDia;



import it.uniroma3.DiaDia.Ambienti.Stanza;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;
	private IOConsole console;
	//private Labirinto labirintoCorrente;

	public DiaDia() {
		this.partita = new Partita();
		this.console = new IOConsole();
		//labirintoCorrente = new Labirinto();
		//this.labirintoCorrente.creaStanze();
	}

	public void gioca() {
		String istruzione; 

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if(comandoDaEseguire.getNome() == null) {
			console.mostraMessaggio("Non hai inserito nessun comando, prova ad inserirne uno valido");
			console.mostraMessaggio("Ecco a te la lista dei comandi: ");
			this.aiuto();
		}
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else 
			console.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		StringBuilder builder = new StringBuilder();
		for(String str : this.elencoComandi)
			builder.append(str + " ");
			
		console.mostraMessaggio(builder.toString());
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = partita.labirintoCorrente.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			partita.labirintoCorrente.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.ciocatore.getCfu();
			this.partita.ciocatore.setCfu(cfu--);
		}
		console.mostraMessaggio(partita.labirintoCorrente.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	private void prendi(String attrezzo) {
		if(partita.labirintoCorrente.getStanzaCorrente().hasAttrezzo(attrezzo)){
			boolean a =	partita.ciocatore.getBorsa().addAttrezzo(partita.labirintoCorrente.getStanzaCorrente().getAttrezzo(attrezzo));
			boolean b = partita.labirintoCorrente.getStanzaCorrente().removeAttrezzo(partita.labirintoCorrente.getStanzaCorrente().getAttrezzo(attrezzo));
			if(a && b)
				console.mostraMessaggio("Attrezzo preso con successo");
			else
				console.mostraMessaggio("Vi è stato un problema nel prendere l'attrezzo");

		}
		else {
			console.mostraMessaggio("L'attrezzo cercato non è presente nella stanza");
		}
	}
	
	private void posa(String attrezzo) {
		if(partita.ciocatore.getBorsa().hasAttrezzo(attrezzo)) {
			boolean c =partita.labirintoCorrente.getStanzaCorrente().addAttrezzo(partita.ciocatore.getBorsa().removeAttrezzo(attrezzo));
			if(!c)
				console.mostraMessaggio("Qualcosa è andato storto");
		}
		else
			console.mostraMessaggio("L'attrezzo cercato non è presente nella begga");
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
	
	
}