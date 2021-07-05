
public class Libro {
    private String titolo;

    public Libro(String titolo) {
        this.titolo = titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public static void main(String[] args) {
        Editore editore = new Editore();
        Libro l1; 
        Libro l2;

        l1 = new Libro("Anna Karenina");
        l2 = new Libro("Fratelli Karamazov");
        editore.cambiaTitolo(l2, "Madame Bovary");
        l1 = l2;
        System.out.println(l1.getTitolo());
        System.out.println(l2.getTitolo());
    }
}