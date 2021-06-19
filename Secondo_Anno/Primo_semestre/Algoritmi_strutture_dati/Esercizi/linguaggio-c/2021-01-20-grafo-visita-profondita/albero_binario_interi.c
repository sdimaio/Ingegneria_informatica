#include <stdlib.h>
#include <stdio.h>
#include "albero_binario_interi.h"
#include "error.h"



void aggiungi_radice(albero* pa, int val) {

	/* 

	Questo passaggio di parametro e' equivalente a 
	definire una variabile locale inizializzata da fuori
	come segue (suppomiamo di chiamare "aggiungi_radice(&a, 5)"
	dove a è di tipo albero, oppure node*): 

	albero* pa = <indirizzo della variabie esterna di tipo albero>;

	D'ora in poi le operazioni su "(*pa)"" sono a tutti gli effetti 
	operazioni su "a"

	*/

	if( (*pa) != NULL ) {  // l'albero ha gia' una radice
		error("aggiungi_radice() su albero non vuoto");
	}

	nodo* nuovo_nodo = (nodo*)malloc(sizeof(nodo));
	nuovo_nodo->parent = NULL;
	nuovo_nodo->left = NULL;
	nuovo_nodo->right = NULL;
	nuovo_nodo->info = val;

	(*pa) = nuovo_nodo;
}

/* Suppongo che n sia diverso da NULL */

nodo* aggiungi_figlio_sinistro(nodo* n, int val) {

	if( n->left != NULL ) {  // il nodo ha gia' un figlio sinistro
		error("aggiungi_figlio_sinistro() su un nodo che ha gia' il figlio");
	}

	n->left = (nodo*)malloc(sizeof(nodo));
	n->left->parent = n;
	n->left->left = NULL;
	n->left->right = NULL;
	n->left->info = val;

	return n->left;
}


nodo* aggiungi_figlio_destro(nodo* n, int val) {

	if( n->right != NULL ) {  // il nodo ha gia' un figlio destro
		error("aggiungi_figlio_destro() su un nodo che ha gia' il figlio");
	}

	n->right = (nodo*)malloc(sizeof(nodo));
	n->right->parent = n;
	n->right->left = NULL;
	n->right->right = NULL;
	n->right->info = val;

	return n->right;

}  

/* Ritorna true (1) se l'albero e' composto da nodi
   che non hanno il figlio destro, oppure se e' un 
   albero vuoto */

int only_left(albero a) {

	// rimosso perche' supefluo
	//
	// if( a == NULL ) return 1;

	while( a != NULL ) {

		if( a->right != NULL) {
			return 0;
		}
		a = a->left;
	}
	return 1;
}

int only_left_ricorsivo(albero a) {

	if( a == NULL ) return 1;

	if( a->right != NULL ) {
			return 0;
	}
	return only_left_ricorsivo(a->left);
}

/* Primo modo di realizzare la funzione: si assume che n non sia mai NULL  */

nodo* cerca_nodo_preordine1(nodo* n, int val) {

	/* controllo il nodo corrente */
	if( n->info == val ) return n;

    /* controllo il sottoalbero sinistro */
	if( n->left != NULL) {
		nodo* nodo_trovato = cerca_nodo_preordine(n->left,val);
		if( nodo_trovato != NULL ) return nodo_trovato;
	}

    /* controllo il sottoalbero destro */
	if( n->right != NULL ) {
		return cerca_nodo_preordine(n->right,val);
	}

	return NULL;
}


/* Secondo modo di realizzare la funzione: n puo' essere NULL  */

nodo* cerca_nodo_preordine(nodo* n, int val) {

	if( n == NULL ) return NULL;

	/* controllo il nodo corrente */
	if( n->info == val ) return n;

    /* controllo il sottoalbero sinistro */
	nodo* nodo_trovato = cerca_nodo_preordine(n->left,val);
	if( nodo_trovato != NULL ) return nodo_trovato;

    /* controllo il sottoalbero destro */
	return cerca_nodo_preordine(n->right,val);

	/* ATTENZIONE: non ha senso il codice seguente

	return cerca_nodo_preordine(n->left,val) || cerca_nodo_preordine(n->right,val);
	
	*/

}

/* Secondo modo di realizzare la funzione: n puo' essere NULL.
   Nota che in questo caso il codice della visita in preordine o
   postoridine e' lo stesso (l'ordine di valutazione dipende dal
   compilatore)  */

int esiste_nodo_preordine(nodo* n, int val) {

	if( n == NULL ) return 0;  // qui il nodo val non c'e'
	return (n->info == val) || esiste_nodo_preordine(n->left,val) || esiste_nodo_preordine(n->right,val);
}


nodo* cerca_nodo_postordine(nodo* n, int val) {

	if( n == NULL ) return NULL;

    /* controllo il sottoalbero sinistro */
	nodo* nodo_trovato = cerca_nodo_postordine(n->left,val);
	if( nodo_trovato != NULL ) return nodo_trovato;

    /* controllo il sottoalbero destro */
	nodo_trovato = cerca_nodo_postordine(n->right,val);
	if( nodo_trovato != NULL ) return nodo_trovato;

	/* controllo il nodo corrente */
	if( n->info == val ) return n;
	return NULL;
}


nodo* cerca_nodo_simmetrica(nodo* n, int val) {

	if( n == NULL ) return NULL;

    /* controllo il sottoalbero sinistro */
	nodo* nodo_trovato = cerca_nodo_simmetrica(n->left,val);
	if( nodo_trovato != NULL ) return nodo_trovato;

	/* controllo il nodo corrente */
	if( n->info == val ) return n;

    /* controllo il sottoalbero destro */
	nodo_trovato = cerca_nodo_simmetrica(n->right,val);
	if( nodo_trovato != NULL ) return nodo_trovato;

	return NULL;
}


int conta_nodi_postordine(nodo* n) {

	if( n == NULL ) return 0;
	return 1 + conta_nodi_postordine(n->left) + conta_nodi_postordine(n->right);
}

/* Calcola la somma degli id dei nodi dell'albero */

int somma_nodi_postordine(nodo* n) {

	if( n == NULL ) return 0;
	return n->info + somma_nodi_postordine(n->left) + somma_nodi_postordine(n->right);
}


int cammino_ricorsivo(nodo* n) {

	if ( n == NULL ) return 1;

	if ( (n->left != NULL) && (n->right != NULL) ) {  // ho entrambi i figli
		return 0; // c'e' una diramazione, dunque non sono un cammino
	}

	// almeno uno tra n->left e n->right e' NULL
    return cammino_ricorsivo(n->left) && cammino_ricorsivo(n->right);
}

int cammino_iterativo(nodo* n) {

	while ( n != NULL) {
		if ( (n->left != NULL) && (n->right != NULL) ) {  // ho entrambi i figli
			return 0; // c'e' una diramazione, dunque non sono un cammino
		}
		if( n->left != NULL) n = n->left;
		else n = n->right;
	}
	return 1;
}

/* Calcola l'altezza di un (sotto)albero binario radicato al nodo passato come parametro */

int altezza_albero_binario(nodo* n) {

	if( n == NULL ) return -1;   // un albero vuoto ha altezza -1 (un albero con un solo
		                         // nodo ha altezza zero)
	int left = altezza_albero_binario(n->left);
	int right = altezza_albero_binario(n->right);

	if( left > right ) 
		return left + 1;
	return right + 1;
}

/* Ritorna la profondita' (rispetto alla radice dell'albero) 
   della foglia piu' profonda del sottoalbero 
   radicato ad n. Il parametro prof e' la profondità del nodo n 
   nell'albero completo. */

int altezza_albero_binario_2_ric(nodo* n, int prof) {

	if (n == NULL) return -1; // valore convenzionale per albero inesistente

	if( (n->left == NULL) && (n->right == NULL) ) 
		return prof;

	int left = altezza_albero_binario_2_ric(n->left, prof+1);
	int right = altezza_albero_binario_2_ric(n->right, prof+1);

	if (left > right)
		return left;
	return right;
}

/* Calcola l'altezza dell'albero passato come parametro */

int altezza_albero_binario_2(nodo* n) {

	if( n == NULL ) return -1;
	return altezza_albero_binario_2_ric(n,0); // zero = profondità della radice

}

/* Ritorna la profondita' espressa rispetto alla radice dell'albero
   del nodo nel sottoalbero corrente (n). Il parametro prof e' la 
   profondita' del nodo corrente. */

int cerca_profondita_nodo_ric(nodo* n, int mio_id, int prof) {

	if( n == NULL ) return -1;  // qui non c'e' il nodo "mio_id"

	if( n->info == mio_id ) return prof;  

	int left = cerca_profondita_nodo_ric(n->left, mio_id, prof+1);
	if (left != -1) return left;

	int right = cerca_profondita_nodo_ric(n->right, mio_id, prof+1);
	if (right != -1) return right;

	return -1;  // non sono io, non l'ho trovato a sinistra ne' a destra.
}

/* Ritorna la profondita' del nodo con id "mio_id" nell'albero
   passato tramite il parametro n. Se n e' NULL oppure se nell'albero
   non c'e' un nodo con questo id allora ritorna -1. */

int cerca_profondita_nodo(nodo* n, int mio_id) {

	if( n == NULL ) return -1;
	return cerca_profondita_nodo_ric(n, mio_id, 0);   // zero profondita' della radice
}

void stampa_parentetica_simmetrica(nodo* n) {

	if( n == NULL ) {
		printf("()");
		return;
	}

	printf("(");
	stampa_parentetica_simmetrica(n->left);
	printf("%d",n->info);
	stampa_parentetica_simmetrica(n->right);
	printf(")");
}

void stampa_parentetica_preordine(nodo* n) {

	if( n == NULL ) {
		printf("()");
		return;
	}

	printf("(");
	printf("%d",n->info);
	stampa_parentetica_preordine(n->left);
	stampa_parentetica_preordine(n->right);
	printf(")");
}

/* Ritorna il numero dei nodi dell'albero che hanno
   il campo info uguale a quello del genitore del genitore */

int valore_nonno(nodo* n) {

	if( n == NULL ) return 0;

	int left = valore_nonno(n->left);
	int right = valore_nonno(n->right);

	int soddisfo = 0;  // booleano (intero) che mi dice se io soddisfo
	                   // la proprieta' richiesta
	if( n->parent != NULL ) {			   // se esite il genitore
		if( n->parent->parent != NULL)	{  // se esiste il genitore del genitore
			if( n->parent->parent->info == n->info) {
				soddisfo = 1;  // il nodo corrente deve essere contato
			}
		}
	}
	return soddisfo + left + right;
}

int ho_info_uguale_a_nonno(nodo* n) {
	int soddisfo = 0;  // booleano (intero) che mi dice se io soddisfo
	                   // la proprieta' richiesta
	if( n->parent != NULL ) {			   // se esite il genitore
		if( n->parent->parent != NULL)	{  // se esiste il genitore del genitore
			if( n->parent->parent->info == n->info) {
				soddisfo = 1;  // il nodo corrente deve essere contato
			}
		}
	}
	return soddisfo;
}

int valore_nonno2(nodo* n) {

	if( n == NULL ) return 0;

	int left = valore_nonno2(n->left);
	int right = valore_nonno2(n->right);

	int soddisfo =  ho_info_uguale_a_nonno(n);
	return soddisfo + left + right;

	// equivalentemente
	//
	// return ho_info_uguale_a_nonno(n) + valore_nonno2(n->left) + valore_nonno2(n->right);
}

/* Verifica se il nodo corrente (che non e' mai NULL) abbia 
   un campo info che è strettamente maggiore della somma dei 
   campi info dei due figli (se presenti).  */

int ho_info_maggiore_figli(nodo* n) {

	int verifico = 0;
	int somma_valori_figli = 0;

	// scommentare questa riga se non si vogliono contare le foglie 
	//
	// if( (n->left == NULL) && (n->right == NULL) ) return 0;

	if( n->left != NULL) {
		somma_valori_figli = n->left->info;
	}
	if( n->right != NULL) {
		somma_valori_figli = somma_valori_figli + n->right->info;
	}

	// ora somma_valori_figli contiene effettivamente la somma dei valori dei figli

	if( n->info > somma_valori_figli ) {
		verifico = 1;
	}
	return verifico;
}

/* Ritorna il numero dei nodi dell'albero binario di interi
   radicato ad n che hanno il campo info maggiore della somma
   del campo info dei due figli. Se il nodo non ha figli 
   viene contato comunque. */

int num_nodi_info_maggiore_figli(nodo* n) {

	if( n == NULL ) return 0;

	int left = num_nodi_info_maggiore_figli(n->left);
	int right = num_nodi_info_maggiore_figli(n->right);

	int soddisfo =  ho_info_maggiore_figli(n);
	return soddisfo + left + right;
}


int ho_info_maggiore_discendenti(nodo* n) {

	if (n == NULL) return 0;

	if ( (n->left == NULL) && (n->right == NULL) ) return 0;

	int somma_valori_discendenti = somma_nodi_postordine(n);
	somma_valori_discendenti = somma_valori_discendenti - n->info;

	/* ora somma_valori_discendenti contiene effettivamente la somma
	   dei campi info di tutti i discenti (escludendo il nodo corrente). */

	if ( n->info  > somma_valori_discendenti )
		return 1;
	else
		return 0;
}


/* Ritorna il numero dei nodi dell'albero binario di interi
   radicato ad n che hanno il campo info maggiore della somma
   del campo info di tutti i discendenti. Se il nodo non ha figli 
   non viene contato. */

int num_nodi_info_maggiore_sottoalberi(nodo* n) {

	if( n == NULL ) return 0;

	int left = num_nodi_info_maggiore_sottoalberi(n->left);
	int right = num_nodi_info_maggiore_sottoalberi(n->right);

	int soddisfo =  ho_info_maggiore_discendenti(n);
	return soddisfo + left + right;
}

/* ritorna una lista di interi con gli id del cammino
   dalla radice al nodo n (inclusi). */

litem* lista_cammino(nodo* radice, nodo* n) {

	if ( n == NULL) {
		error("lista_cammino() con nodo destinazione NULL");
	}

	litem* lista = NULL;

	insert_lista_interi(&lista, n->info);
	while( n != radice) {
		n = n->parent;
		insert_lista_interi(&lista, n->info);
	}

	/* assumendo che la radice abbia radice->parent == NULL

	while( n != NULL ) {
	
		insert_lista_interi(&lista, n->info);
		n = n->parent;
	}

	*/

	return lista;
}

/* Ritorna il grado di parentela di due nodi dell'albero, 
   cioe' la lunghezza dell'unico cammino che connette i 
   due nodi. Si assume che i due nodi facciano parte dell'albero a.
   Si assume anche che i nodi dell'albero siano univocamente 
   identificati dal loro campo info (e' una chiave). */

int grado_parentela(nodo* radice, nodo* n1, nodo* n2) {

	int output = 0;

    if( n1 == n2 ) return 0;  // ogni nodo ha grado di parentela zero con se stesso

	litem* lista1 = lista_cammino(radice, n1);
	litem* lista2 = lista_cammino(radice, n2);

	litem* i1 = lista1;
	litem* i2 = lista2;

	// non utilizziamo questo test perche' non c'e' certezza
	// dell'ordine di valutazione delle clausole in and
	//
    // while(((i1 != NULL) && (i2 != NULL)) && (i1->info == i2->info) )

	while( i1->info == i2->info ) {
		i1 = i1->next;  // scorro lista1
		i2 = i2->next;  // scorro lista2
		if((i1 == NULL) || (i2 == NULL)) {
			break;
		} 
	}

	// gli elementi restanti (da i1 ed i2, compresi, in poi) delle due
	// liste corrispondono al grado di parentela certato

	output = output + lunghezza_lista_interi(i1);
	output = output + lunghezza_lista_interi(i2);

	// dealloca lista1, lista2

	dealloca_lista_interi(lista1);
	dealloca_lista_interi(lista2);

	// attenzione: dopo queste deallocazioni afferire a lista1 e lista2 darebbe errore

	return output;
}




