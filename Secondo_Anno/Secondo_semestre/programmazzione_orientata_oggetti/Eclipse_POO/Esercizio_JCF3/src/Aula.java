import java.util.HashSet;
import java.util.Set;

public class Aula {

	private Set<Studente> studenti;

	public Aula() { 
		this.studenti = new HashSet<Studente>();
	}
	public boolean addStudente(Studente studente) {
		return this.studenti.add(studente);
	}
}