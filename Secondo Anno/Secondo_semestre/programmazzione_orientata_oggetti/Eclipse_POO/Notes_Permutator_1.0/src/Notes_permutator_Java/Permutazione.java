package Notes_permutator_Java;

import java.lang.reflect.Array;
import java.util.*;

public class Permutazione {
	static final private String[] elencoAltezze = {" A "," A# "," B "," C "," C# "," D ", " D# ", " E ", " F ", " F# ", " G ", " G# ", " pausa "};
	
	private Nota[] permutazione;
	
	public String[] permutatore(String[] elencoAltezza) {
		int lung = elencoAltezze.length;
		String[] copiaAltezze = Arrays.copyOf(elencoAltezze, lung);
		Collections.shuffle(Arrays.asList(copiaAltezze));
		
		return copiaAltezze;
	}
	
	public static void main(String[] argc) {
		Permutazione p = new Permutazione();
		//String[] c = p.permutatore(elencoAltezze);
		System.out.println(Arrays.toString(p.permutatore(elencoAltezze)));
	}
	
}
