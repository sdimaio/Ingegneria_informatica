
class Scooter {
	public void tipo(Scooter a) {
		System.out.print("Scooter.tipo(Scooter) ");
                costo();
        }

        public void tipo(Vespa b) {
		System.out.print("Scooter.tipo(Vespa) ");
		costo();
	}

        public void costo() {
		System.out.print("Scooter.costo()");
	}
}
