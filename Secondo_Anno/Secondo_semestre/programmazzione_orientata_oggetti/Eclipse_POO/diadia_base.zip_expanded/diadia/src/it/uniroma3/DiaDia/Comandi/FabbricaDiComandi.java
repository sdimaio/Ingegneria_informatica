package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;

public interface FabbricaDiComandi {
	public Comando costruisciComando(String istruzione, IO io);
}