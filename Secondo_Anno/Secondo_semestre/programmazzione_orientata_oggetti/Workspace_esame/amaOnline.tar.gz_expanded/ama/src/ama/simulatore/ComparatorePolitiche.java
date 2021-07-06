package ama.simulatore;

import java.util.Comparator;
import java.util.Map;

public class ComparatorePolitiche implements Comparator<Class<?>> {

	Map<Class<?>, Integer> mappa;
	
	public ComparatorePolitiche(Map<Class<?>, Integer> politica2quantita) {
		this.mappa = politica2quantita;
	}

	@Override
	public int compare(Class<?> o1, Class<?> o2) {
		if(mappa.get(o2) <= mappa.get(o1))
			return -1;
		else
			return 1;
	}

}
