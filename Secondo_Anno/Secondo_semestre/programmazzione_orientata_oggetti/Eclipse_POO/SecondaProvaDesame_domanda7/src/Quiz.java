import java.util.*;

public class Quiz {
	public static void main(String[] args) {
		List<Moto> elenco = new LinkedList<Moto>();

		elenco.add(new Moto("Guzzi", 500));
		elenco.add(new Moto("Suzuki", 750));
		elenco.add(new Moto("Suzuki", 250));
		elenco.add(new Moto("Honda", 1500));
		Collections.sort(elenco, new ComparatoreMoto());

		for(Moto persona : elenco)
			System.out.print(persona.getMarca()+" ");
	}
}
