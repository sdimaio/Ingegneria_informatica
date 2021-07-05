import java.util.*;

public class Quiz {
    public static void main(String[] argc) {
        List<Auto> l = new LinkedList<Auto>();

        Auto a = new Auto("1600");
        l.add(a);
        a = new Auto("2000");
        l.add(a);
        a.setCilindrata("1300");
        Auto b;
        b = a;
        b.setCilindrata("1000");
        l.add(b);
        for(Auto p : l)
            System.out.print(p.getCilindrata()+" ");
    }
}