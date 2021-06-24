import java.util.Set;
import java.util.TreeSet;

public class Aula {

	private Set<Studente> studenti;

	public Aula() { 
		this.studenti = new TreeSet<Studente>(new ComparatoreStudente());
	}
	
	public boolean addStudente(Studente studente) {
		return this.studenti.add(studente);
	}
}