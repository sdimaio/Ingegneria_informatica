import java.util.Set;
import java.util.TreeSet;

public class Aula {

	private Set<Studente> studenti;

	public Aula() { 
		studenti = new TreeSet<Studente>(); 
	}
	
	public boolean addStudente(Studente studente) {
		return studenti.add(studente);
	}
}