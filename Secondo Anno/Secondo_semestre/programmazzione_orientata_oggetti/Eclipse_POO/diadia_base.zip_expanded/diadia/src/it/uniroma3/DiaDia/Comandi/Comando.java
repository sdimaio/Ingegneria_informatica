package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;

public interface Comando {

	public void esegui(Partita partita);
	
	public void setParametro(String parametro);
	
	public String getParametro();
	
	public String getNome();
	
	public void setIO(IO io);

}
