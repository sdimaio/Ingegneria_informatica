
public class Studente {
	private String nome;
	
	public Studente(String nome) { 
		this.nome = nome; 
	}
	
	public String getNome() {
		return this.nome; 
	}
	
	@Override
	public int hashCode() {
		
		return this.getNome().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		Studente that = (Studente)o;
		return this.getNome().equals(that.getNome());
	}
}
