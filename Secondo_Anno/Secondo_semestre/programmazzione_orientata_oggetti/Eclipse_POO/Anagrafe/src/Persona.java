
public class Persona {
	private String nome;

	public Persona(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public static void main(String[] args) {
        Anagrafe anagrafe = new Anagrafe();
        Persona p = new Persona("Bonnie");
        
        System.out.print(p.getNome());
        System.out.print("-");
        anagrafe.cambiaNome(p, "Clyde");
        System.out.print(p.getNome());
    }
}