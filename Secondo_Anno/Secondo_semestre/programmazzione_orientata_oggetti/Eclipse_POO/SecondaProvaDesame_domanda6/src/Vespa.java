
class Vespa extends Scooter {
        public void tipo(Scooter a) {
	    System.out.print("Vespa.tipo(Scooter) ");
	    costo();
        }

        public void tipo(Vespa b) {
	    System.out.print("Vespa.tipo(Vespa) ");
  	    costo();
        }

        public void costo() {
	    System.out.print("Vespa.costo()");
        }
}
