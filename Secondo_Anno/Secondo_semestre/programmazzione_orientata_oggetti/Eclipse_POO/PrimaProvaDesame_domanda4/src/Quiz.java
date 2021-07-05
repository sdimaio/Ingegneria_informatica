import java.util.LinkedList;
import java.util.List;

public class Quiz {

    public static void main(String[] argc) {
        List<Persona> l = new LinkedList<Persona>();

        Persona a = new Persona("Paolo");
        l.add(a);
        a.setNome("Luca");
        a = new Persona("Antonio");
        l.add(a);
        Persona b;
        b = a;
        b.setNome("Elisabetta");
        l.add(b);
        for(Persona p : l)
            System.out.print(p.toString()+" ");
    }
}
