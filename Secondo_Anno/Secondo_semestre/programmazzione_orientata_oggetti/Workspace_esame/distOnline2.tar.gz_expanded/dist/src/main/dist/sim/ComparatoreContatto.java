package dist.sim;

import java.util.Comparator;

public class ComparatoreContatto implements Comparator<Contatto> {
	
	@Override
	public int compare(Contatto c1, Contatto c2) {
		if(c1.numeroCoinvolti() - c2.numeroCoinvolti() == 0)
			return c1.getPassoSimulazione() - c2.getPassoSimulazione();
		
		return c1.numeroCoinvolti() - c2.numeroCoinvolti();
		
	}

}
