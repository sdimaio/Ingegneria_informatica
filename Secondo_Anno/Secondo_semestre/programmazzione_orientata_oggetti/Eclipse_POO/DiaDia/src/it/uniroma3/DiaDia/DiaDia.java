package it.uniroma3.DiaDia;



import it.uniroma3.DiaDia.Ambienti.Labirinto;
import it.uniroma3.DiaDia.Ambienti.LabirintoBuilder;
import it.uniroma3.DiaDia.Comandi.*;
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
	

	private Partita partita;
	private IO console;

	public DiaDia(IO io, Labirinto labirinto) {
		this.partita = new Partita(labirinto);
		this.console = io;
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
		Comando comandoDaEseguire;
		 FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione, this.console);
		comandoDaEseguire.esegui(this.partita); 
		if (this.partita.vinta())
			console.mostraMessaggio("Hai vinto!");
		if (!this.partita. GiocatoreIsVivo())
			console.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
		}

	

	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				 .addStanzaIniziale("LabCampusOne")
				 .addStanzaVincente("Biblioteca")
				 .addStanzaBloccata("Atrio", "piedediporco", "est")
				// .addAttrezzo("piedediporco", 2)
				 .addAdiacenza("LabCampusOne","Atrio","est")
				 .addAdiacenza("Atrio", "Biblioteca", "est")
				 .getLabirinto();

		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
	}
	
	
}