import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
	
	private List<Libro> elenco;
	
	public Biblioteca() {
		this.elenco = new ArrayList<>();
	}
	
	public void aggiungiLibro(Libro libro) {
		this.elenco.add(libro);
	}
	
	public List<Libro> elencoOrdinatoPerPagine(){
		ComparatorePerPagine comp = new ComparatorePerPagine();
		Collections.sort(this.elenco, comp);
		
		return this.elenco;
	}
	
}
