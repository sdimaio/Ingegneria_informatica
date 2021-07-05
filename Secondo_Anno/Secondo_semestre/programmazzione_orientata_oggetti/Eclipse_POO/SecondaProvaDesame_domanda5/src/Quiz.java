
public class Quiz {
    public static void main(String[] args) {
        Officina officina = new Officina();
        Auto piccola = new Auto(2000);
        Auto grande = piccola;

        System.out.print(grande.getCilindrata()+" ");
        System.out.print(piccola.getCilindrata()+" ");
        System.out.print(". ");

        officina.cambiaCilindrata(grande, 1500);
        System.out.print(grande.getCilindrata()+" ");
        System.out.print(piccola.getCilindrata()+" ");
        System.out.print(". ");

        officina.cambiaCilindrata(piccola, 1000);
        System.out.print(grande.getCilindrata()+" ");
        System.out.print(piccola.getCilindrata()+" ");
    }
}