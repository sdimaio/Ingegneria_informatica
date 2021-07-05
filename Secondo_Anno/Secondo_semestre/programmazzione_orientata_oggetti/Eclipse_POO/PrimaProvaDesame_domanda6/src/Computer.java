
class Computer {
	public void dimensioni(Computer a) {
		System.out.print("Computer.dimensioni(Computer) ");
		fine();
	}

	public void dimensioni(Laptop b) {
		System.out.print("Computer.dimensioni(Laptop) ");
		fine();
	}

	public void fine() {
		System.out.print("Computer.fine()");
	}
}
