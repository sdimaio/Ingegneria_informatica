
public class Quiz {
	public static void main(String[] args) {
		Messaggio messaggio = new SMS("gigi", "damiano");
		
		Messaggio tweet = new Tweet("@gigi");

		Messaggio msg = new Messaggio();
		
		System.out.println(messaggio.getLunghezzaMassima());
		System.out.println(msg.getLunghezzaMassima());
		System.out.println(tweet.getLunghezzaMassima());
	}
}