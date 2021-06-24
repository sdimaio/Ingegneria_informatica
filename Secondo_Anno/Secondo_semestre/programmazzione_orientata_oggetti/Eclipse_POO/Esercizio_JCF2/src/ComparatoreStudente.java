import java.util.Comparator;

public class ComparatoreStudente implements Comparator<Studente> {
	
	
	public int compare(Studente s1, Studente s2) {
		return s1.getNome().compareTo(s2.getNome());
	}
}
