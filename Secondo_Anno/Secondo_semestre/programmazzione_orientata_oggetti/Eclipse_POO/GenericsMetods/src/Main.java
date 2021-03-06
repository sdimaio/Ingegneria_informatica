
public class Main {

	public static void main(String args []) {

		Integer[] intArray = {1, 2, 3, 4, 5};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.6};
		Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
		String[] stringArray = {"B", "Y", "E"};
		
//		displayArray(intArray);
//		displayArray(doubleArray);
//		displayArray(charArray);
//		displayArray(stringArray);
		
		System.out.println(getFirst(intArray));
		System.out.println(getFirst(doubleArray));
		System.out.println(getFirst(charArray));
		System.out.println(getFirst(stringArray));
		
	}
	/*
	 * adesso scriveremo un metodo unico per fare la stampa di
	 * diversi tipi
	 * 
	 * public static void displayArray(Integer[] array) {

		for(Integer x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public static void displayArray(Double[] array) {

		for(Double x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public static void displayArray(Character[] array) {

		for(Character x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public static void displayArray(String[] array) {

		for(String x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
		
	}*/
	
	public static <T> void displayArray(T[] array) {

		for(T x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public static <T> T getFirst(T[] array) {
		return array[0];
	}
}
