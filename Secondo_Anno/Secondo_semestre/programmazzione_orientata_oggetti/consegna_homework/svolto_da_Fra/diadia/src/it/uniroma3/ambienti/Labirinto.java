package it.uniroma3.ambienti;

import it.uniroma3.attrezzi.Attrezzo;
/**
 * classe che modella un labirinto all'interno del dia eaggiunge attrezzi alle vaie stanze interconnesse
 *
 * @author  Francesco Saverio Conforti
 */

public class Labirinto {
	
	private Stanza fine;
	private Stanza corrente;

public void creaLabirinto() {
	//*creo stanze
//	StanzaBloccata chiusa= new StanzaBloccata("chiusa", "est", "chiave");
//	StanzaMagica magica =new StanzaMagica("magica");
	Stanza atrio = new Stanza("Atrio");
	Stanza aulaN11 = new Stanza("Aula N11");
	Stanza aulaN10 = new Stanza("Aula N10");
	Stanza laboratorio = new Stanza("Laboratorio Campus");
	Stanza biblioteca = new Stanza("Biblioteca");
//	StanzaBuia oscura =new StanzaBuia("Oscura","torcia"); 
//	Stanza brutta= new Stanza("brutta");
	
	atrio.impostaStanzaAdiacente("nord", biblioteca);
	atrio.impostaStanzaAdiacente("est", aulaN11);
	atrio.impostaStanzaAdiacente("sud", aulaN10);
	atrio.impostaStanzaAdiacente("ovest", laboratorio);
	aulaN11.impostaStanzaAdiacente("est", laboratorio);
	aulaN11.impostaStanzaAdiacente("ovest", atrio);
//	aulaN11.impostaStanzaAdiacente("nord", oscura);
	aulaN10.impostaStanzaAdiacente("nord", atrio);
	aulaN10.impostaStanzaAdiacente("est", aulaN11);
	aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
	laboratorio.impostaStanzaAdiacente("est", atrio);
	laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
//	chiusa.impostaStanzaAdiacente("sud", aulaN11);
//	chiusa.impostaStanzaAdiacente("est", brutta);
//	aulaN11.impostaStanzaAdiacente("nord", chiusa);
	biblioteca.impostaStanzaAdiacente("sud", atrio);
	
//	brutta.impostaStanzaAdiacente("ovest", oscura);
//	magica.impostaStanzaAdiacente("nord", aulaN10);
//	aulaN10.impostaStanzaAdiacente("sud", magica);
	setFine(biblioteca);
	setCorrente(atrio);
//	Attrezzo chiave = new Attrezzo ("chiave",1);
//	Attrezzo torcia =new Attrezzo("torcia",1);
	Attrezzo lanterna = new Attrezzo("lanterna",3);
	Attrezzo osso = new Attrezzo("osso",1);
//	Attrezzo pisello = new Attrezzo("pisello",1);
	aulaN10.addAttrezzo(lanterna);
	atrio.addAttrezzo(osso);
//	oscura.addAttrezzo(pisello);
//	oscura.addAttrezzo(torcia);
//	chiusa.addAttrezzo(chiave);
	}

public Stanza getFine() {
	return fine;
}
public void setFine(Stanza fine) {
	this.fine = fine;
}
public Stanza getCorrente() {
	return corrente;
}
public void setCorrente(Stanza corrente) {
	this.corrente = corrente;
}
}
