
class Laptop extends Computer {
	public void dimensioni(Computer a) {
		System.out.print("Laptop.dimensioni(Computer) ");
		fine();
	}

	public void dimensioni(Laptop b) {
		System.out.print("Laptop.dimensioni(Laptop) ");
		fine();
	}

	public void fine() {
		System.out.print("Laptop.fine()");
	}
}