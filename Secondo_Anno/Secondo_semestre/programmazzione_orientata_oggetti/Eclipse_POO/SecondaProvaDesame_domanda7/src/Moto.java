
class Moto implements Comparable<Moto> {
	public int cilindrata;
	public String marca;

	public Moto(String marca, int cilindrata) {
		this.cilindrata = cilindrata;
		this.marca = marca;
	}

	public int compareTo(Moto m) {
		return this.marca.compareTo(m.getMarca());
	}

	public int getCilindrata(){
		return this.cilindrata;
	}

	public String getMarca(){
		return this.marca;
	}
}