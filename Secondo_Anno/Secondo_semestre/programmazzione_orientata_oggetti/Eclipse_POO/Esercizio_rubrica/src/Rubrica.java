import java.util.*;

public class Rubrica {
	private Map<String,Integer> rubrica;
	public Rubrica() { 
		this.rubrica = new HashMap<String,Integer>();
		// this.rubrica = new HashMap<>(); // solo da Java7…
	}
	
	public void inserisci(String nome, Integer numero) {
		this.rubrica.put(nome, numero);
	}
	
	public void rimuovi(String nome) {
		this.rubrica.remove(nome);
	}
	
	public Set<String> nomiInRubrica() {
		return this.rubrica.keySet();
	}
	
	public Integer dammiIlNumeroDi(String nome) {
		return this.rubrica.get(nome);
	}
	
	public Integer aggiornaNumero(String nome, Integer numero) {
		return this.rubrica.put(nome, numero);
	}
	
	public void svuota() {
		this.rubrica.clear();
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("---------------------------\n");
				str.append("Rubrica\n");
						Set<String> nomi = this.rubrica.keySet();
						for(String s : nomi) {
							str.append(s);
							str.append(": ");
							str.append(this.rubrica.get(s));
							str.append("\n");
						}
						str.append("---------------------------\n");
								return str.toString();
	}
	public static void main(String[] args) {
		Rubrica r = new Rubrica();
		String s1 = new String("Paolo"), s2 = new String("Fabio");
		String s3 = new String("Anna"), s4 = new String("Carla");
		r.inserisci(s1, 390112461); 	// inserisco Paolo->390112461 in rubrica
		r.inserisci(s2, 390108361); 	// inserisco Fabio->390108361 in rubrica
		r.inserisci(s3, 39062888); 		// inserisco Anna->39062888 in rubrica
		System.out.println(r.toString()); 	// stampo la rubrica
											// verifico se ho il numero di Carla
		Integer numeroCercato = r.dammiIlNumeroDi(s4);
		if (numeroCercato == null)
			System.out.println("Il numero di "+s4+" non esiste");
		else
			System.out.println("Il numero di "+s4+" è "+numeroCercato);
		r.rimuovi(s2); 	// tolgo i dati relativi a Fabio dalla rubrica
						// cambio il numero di Paolo (e mi faccio stampare il numero vecchio)
		Integer nuovoNumero = 39066777;
		Integer vecchioNumero = r.aggiornaNumero(s1,nuovoNumero);
		System.out.println("Aggiornato il numero di "+s1+
				" da "+vecchioNumero+" a "+nuovoNumero);
		System.out.println(r.toString()); // stampo la rubrica
	}
}
