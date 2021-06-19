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
		// printf("()");
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
		// printf("()");
		return;
	}

	printf("(");
	printf("%d",n->info);
	stampa_parentetica_preordine(n->left);
	stampa_parentetica_preordine(n->right);
	printf(")");
}






