
package it.uniroma3.partita;



import it.uniroma3.comandi.Comando;
import it.uniroma3.comandi.FabbricaDiComandi;
import it.uniroma3.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

/**
 
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
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
	

	private IO io;
	private Partita partita;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io= io;//*posso usare metodi di io
	}

	public void gioca() {
		String istruzione; 
		

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = io.leggiRiga();
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
		comandoDaEseguire = factory.costruisciComando(istruzione,io);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

		io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

		io.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
		}
	

	public static void main(String[] argc) {
		IO io= new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		
	}
}