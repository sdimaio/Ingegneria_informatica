package dist.stats;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dist.pers.Persona;
import dist.sim.Contatto;
import dist.sim.Simulatore;

/**
 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
 */
public class Statistiche {

	synchronized public void stampaFinale(Simulatore simulatore) {
		final Set<Contatto> contatti = simulatore.getContatti();

		System.out.println(contatti.size() + " contatti rilevati." );
		System.out.println(simulatore.getContatti());
		System.out.println();

		final Map<Persona, List<Contatto>> mappa = produciStatistiche(simulatore.getContatti());
		System.out.println("Statistica:");
		stampaStatistiche(mappa);
		System.out.println();
	}

	public Map<Persona, List<Contatto>> produciStatistiche(Set<Contatto> contatti) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		Map<Persona, List<Contatto>> stat = new HashMap<>();

		Comparator<Contatto> compare = new Comparator<Contatto>() {

			@Override
			public int compare(Contatto c1, Contatto c2) {
				// TODO Auto-generated method stub
				return c1.compareTo(c2);
			}
		};

		for(Contatto c : contatti) {
			for(Persona p : c.getCoinvolti()) {
				if(stat.containsKey(p)) 
					stat.get(p).add(c);

				else {
					stat.put(p, new ArrayList<Contatto>());
					stat.get(p).add(c);
				}
				stat.get(p).sort(compare);
			}
		}

		return stat;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 */
	private void stampaStatistiche(final Map<Persona, List<Contatto>> mappa) {
		for(Persona p : mappa.keySet()) {
			final List<Contatto> l = mappa.get(p);
			System.out.print(p + " è stato coinvolto in :");
			for(Contatto c : l) 
				System.out.print(c.toString() + " ");
			System.out.println();
		}
	}
}
