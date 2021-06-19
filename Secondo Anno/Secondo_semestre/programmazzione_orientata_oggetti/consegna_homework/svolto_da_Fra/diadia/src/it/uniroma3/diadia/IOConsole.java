package it.uniroma3.diadia;
import java.util.Scanner;
/**
 * Classeche modella le funzioni base di input e output del gioco
 * @author  Francesco Saverio Conforti 
 */
public class IOConsole implements IO {
	public void mostraMessaggio(String msg) {
		 System.out.println(msg);
		}
		 public String leggiRiga() {
		 Scanner scannerDiLinee = new Scanner(System.in);
		 String riga = scannerDiLinee.nextLine();
//		 scannerDiLinee.close(); ometto per evitare errori
		 return riga;
		 }

}
