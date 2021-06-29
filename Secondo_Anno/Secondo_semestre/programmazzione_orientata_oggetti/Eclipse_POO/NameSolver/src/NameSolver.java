
public class NameSolver {
 private static final String RNS_R = "p/r.txt";
 private static final String ABS_R = "/p/r.txt";
 private static final String REL_R = "r.txt";
 
 private void testResourceSolver() {
 Class<?> clazz = this.getClass();
 ClassLoader loader = clazz.getClassLoader(); 
 System.out.println("ClassLoader.getResource(\""+ABS_R+"\")=\t"+
 loader.getResource(ABS_R));
 System.out.println(" Class.getResource(\""+ABS_R+"\")=\t"+ 
 clazz.getResource(ABS_R));
 System.out.println("ClassLoader.getResource(\""+RNS_R+"\")=\t"+loader.getResource(RNS_R));
 

 }
 public static void main(String[] args) {
 new NameSolver().testResourceSolver();
 }
}