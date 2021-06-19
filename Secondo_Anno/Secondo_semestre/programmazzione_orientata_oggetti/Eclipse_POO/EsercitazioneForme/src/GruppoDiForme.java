
public class GruppoDiForme implements Forma{

	Forma[] f = new Forma[10];
	int numeroDiForme = 0;

	@Override
	public void trasla(int deltaX, int deltaY) {

	}

	public void aggiungiForma(Forma forma) {
		if(forma != null && numeroDiForme < 10) {
			f[numeroDiForme] = forma;
			numeroDiForme ++;
		}
		else {
			System.out.println("Operazione non riuscita");
		}
	}

	public static void main (String[] argc) {
		Punto p1 = new Punto(0,0);	
		Rettangolo r1 = new Rettangolo(p1,2,4);
		Punto p2 = new Punto(1,1);	
		Rettangolo r2 = new Rettangolo(p2,2,4);
		Cerchio c1 = new Cerchio(p1,10);
		Cerchio c2 = new Cerchio(p2,100);

		GruppoDiForme gf = new GruppoDiForme();
		gf.aggiungiForma(r1);
		System.out.println("Operazione non riuscita");
		gf.aggiungiForma(r2);
		System.out.println("Operazione non riuscita");
		gf.aggiungiForma(c1);
		System.out.println("Operazione non riuscita");
		gf.aggiungiForma(c2);
		System.out.println("Operazione non riuscita");

		gf.trasla(+1,+1);
	}


}

