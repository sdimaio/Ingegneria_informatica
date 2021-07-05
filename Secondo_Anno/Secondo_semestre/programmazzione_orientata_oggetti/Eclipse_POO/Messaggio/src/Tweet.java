
class Tweet extends Messaggio {
	
	private static final int LUNGHEZZA_MAX_TWEET = 280;
	private String user;
	
	public Tweet(String user) {
		super(LUNGHEZZA_MAX_TWEET);
		this.user = user;
	}	
}
