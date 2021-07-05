
public class Motocicletta {
    private int anno;
    private String targa;

    public Motocicletta(String targa, int anno) {
        this.targa = targa;
        this.anno = anno;
    }

    public void cambioTarga(String targa){
        this.targa = targa;
    }

    public String toString() {
        return this.targa + " " + this.anno;
    }

    public static void main(String[] args) {
        Motocicletta m1 = new Motocicletta("1111",1);
        Motocicletta m2 = new Motocicletta("2222", 2);
        Motocicletta m3 = m1; 

        System.out.println(m1.toString());
        System.out.println(m2.toString());

        m2 = m3;
        m2.cambioTarga("3333");

        System.out.println(m2.toString());
        System.out.println(m3.toString());
    }
}
