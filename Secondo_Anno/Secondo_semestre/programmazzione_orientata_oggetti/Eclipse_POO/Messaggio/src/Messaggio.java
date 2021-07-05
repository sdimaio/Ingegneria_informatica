
class Messaggio {
	
	private static final int LUNGHEZZA_MAX_DEFAULT = 160;
	private int lunghezzaMassima;
	
	public Messaggio(int lunghezzaMassima) {
		this.lunghezzaMassima = lunghezzaMassima;
	}

	public Messaggio() {
		this(LUNGHEZZA_MAX_DEFAULT);
	}

	public int getLunghezzaMassima() {
		return lunghezzaMassima;
	}
	
}