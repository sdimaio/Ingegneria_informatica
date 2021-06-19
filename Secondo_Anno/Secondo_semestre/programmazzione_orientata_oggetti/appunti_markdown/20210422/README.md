# Appunti lezione giovedì 22 aprile

Generics per studiare il java collection framework.

Un concetto un po' più avanzato

#### Cosa sono i Generics?

 ![alt text](img1.png)

 Il nostro obbiettivo è di usare classi generiche e non crearle. Ma la cosa migliore per capirle è proggettare classi genereriche rudimentali: che noi chiameremo _Coppia_.

 ![alt text](img2.png)

 ![alt text](img3.png)

  Creiamo una classe coppia utilizzando il polimorfismo. Noi la creiamo utilizzando la classe Object perché ancora non abbiamo fatto i generics.

  ![alt text](img4.png)

  ![alt text](img5.png)
  Questo codice compila perché si fa una downcasting da Object a persona. L'analisi statica regge. Faccio get e mi da una classe Object e poi faccio un downcasting alla classe persona.

  __Funziona anche?__

  Si funziona perché in persona c'è un oggetto che a tempo dinamico e un oggetto persona.

  ### Proviamo questo caso

![alt text](img6.png)

non compila perché il tipo è una coppia di persone e non di generici oggetti.

![alt text](img7.png)

![alt text](img9.png)

il proiblema è che la nostra tipizzazzione è stata troppo lasca.

![alt text](img8.png)


![alt text](img10.png)

Prima die Generics si facevano scasting che funzionavano la erano brutti.

Generics introdotti in java 5 per tipizzazzione più stretta.

![alt text](img11.png)

Con in Generics si pùo cominciare a distinguere diversi tipi

![alt text](img12.png)

Tipo formale scritto con una sola lettera maiuscola

![alt text](img13.png)

per definire il tipo formale "T" bisogna saper cos'è il tipo "T".

>Generics valutato a tempo statico

LA differenza tra paramerto formale e attuale e Generics

Collezioni la E si riserva per elemento della collezione.

![alt text](img14.png)

Per avere classi mutabili metto anche dei set().


![alt text](img15.png)

è il compilatore che decide di quale tipo deve essere T.

Persona è il tipo attuale T tipo formale di coppia.

![alt text](img16.png)

Il compilatore ha dovuto quela tipo scegliere per ogni tipo generico.

![alt text](img17.png)

Non molto frequennte tranne che per le mappe.

__è errato dire Coppia<Persona>=new Coppia<Studente>(); con Studente sottotipo di Persona?__

Si dovrebbe compilare,


![alt text](img18.png)

I generics non si prestano a istanziare come parametro formale un tipo primitivo. Questo è uno dei motivo perché si introduce il meccanisco di boxing/unboxing.


Per ovviare a ciò cengono introdotte le classi wrapped.

![alt text](img19.png)

__Come faccia a fare unwrapp?__

![alt text](img20.png)




![alt text](img21.png)

Questi wrapping e unwrapping il compilatore lo fa da sol0 per noi.


![alt text](img22.png)

![alt text](img23.png)

![alt text](img24.png)

Diventato possiblile da java 5 in poi.

![alt text](img25.png)

poter chimare con modi diversi la stessa cosa fa male soprattutto ai programmatori non esperti.


#### Convensione tipo generico

![alt text](img26.png)

Andiamo avanti per vedere proprietà delle classi generiche.

![alt text](img27.png)

La semantica del metodo _copyAll()_ copia i parametri del parametro formale nell'oggetto sul quale viene chiamato il metodo.


![alt text](img28.png)

questo metodo riceve un'altra coppia.

![alt text](img29.png)

![alt text](img30.png)
