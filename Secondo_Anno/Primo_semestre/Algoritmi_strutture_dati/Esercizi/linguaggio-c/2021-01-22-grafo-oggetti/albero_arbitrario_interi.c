#include <stdlib.h>
#include <stdio.h>
#include "albero_arbitrario_interi.h"
#include "error.h"

/* aggiunge un figlio con info uguale a val 
   ad un nodo di un albero di grado arbitrario
   di interi rappresentato con la strategia
   figlio-sinistro fratello-destro. */ 

nodo* aggiungi_un_figlio(nodo* n, int val) {

	if( n == NULL ) {
		error("aggiungi_un_figlio() con parametro NULL");
	}

	nodo* nuovo_nodo = (nodo*)malloc(sizeof(nodo));
	nuovo_nodo->parent = n;
	nuovo_nodo->info = val;
	nuovo_nodo->left = NULL;      // il nuovo_nodo non ha figli
	nuovo_nodo->right = n->left;  // potrebbe essere NULL (se n non aveva figli)

	n->left = nuovo_nodo;

	return nuovo_nodo;
}


void stampa_figli(nodo* n) {

	printf("figli del nodo %d = ",n->info);

	n = n->left;
	while( n != NULL ) {
		printf("%d ", n->info);
		n = n->right;
	}
	printf("\n");
}

// procedura in postordine
//
int conta_nodi_arbitrario(nodo* n) {

	if( n == NULL ) return 0;

	int output = 0;

	nodo* x = n->left;  // primo figlio (sinistro)
	while( x != NULL ) {
		output = output + conta_nodi_arbitrario(x);
		x = x->right;
	}

	return output + 1;
}



int conta_nodi_arbitrario2(nodo* n) {

	return conta_nodi_postordine(n);  // funzione per gli alberi binari
}

/* ritorna il puntatore al nodo che contiene la info 
   specificata oppure ritorna NULL se tale nodo non esiste. */

nodo* cerca_nodo_arbitrario(nodo* n, int info) {

	if (n == NULL) return NULL;

	if (n->info == info) return n;

	nodo* figlio = n->left;
	while( figlio != NULL ) {
		nodo* output = cerca_nodo_arbitrario(figlio, info);
		if (output != NULL) 
			return output;
		figlio = figlio->right;
	}
	return NULL;
}


nodo* cerca_nodo_arbitrario2(nodo* n, int info) {

	if( n == NULL ) return NULL;

	if( n->info == info ) return n;

	nodo* left = cerca_nodo_arbitrario2(n->left,info);
	if (left != NULL) return left;

	return cerca_nodo_arbitrario2(n->right,info);

    /* alternativamente */

	// nodo* right = cerca_nodo_arbitrario2(n->right,info);
	// if (right != NULL) return right;
	// return NULL;
}


int profondita_arbitrario(nodo* n) {

	if( n == NULL ) return -1;

	int prof = -1;
	nodo* figlio = n->left;
	while( figlio != NULL ) {
		int prof_figlio = profondita_arbitrario(figlio);
		if (prof_figlio > prof) prof = prof_figlio;
		figlio = figlio->right;
	}

	// prof = -1 se non ho figli
	// prof = 0 se ho figli che sono foglie
	// prof > 0 se ho almeno un figlio con un sottoalbero significativo
	return prof+1;
}

int profondita_arbitrario2(nodo* n) {

	if( n == NULL ) return -1;

    /* poiche' a sinistra ho un figlio, l'albero corrente
       ha un profondita' incrementata di uno */
	int left = 1 + profondita_arbitrario2(n->left);

	/* poiche' a destra ho un fratello, l'altezza riportata
	   lanciando su right non deve essere incrementata */
	int right = profondita_arbitrario2(n->right);

	if (left > right) return left;
	return right;
}


int grado_massimo(nodo* n) {

	if (n == NULL) return -1;  // convenzionale 

	int mio_grado = 0;
	int massimo = 0; // grado massimo di un nodo contenuto
	                       // in un sottoalbero

	nodo* figlio = n->left;
	while( figlio != NULL) {
		mio_grado = mio_grado + 1;
		int grado_max_figlio = grado_massimo(figlio);
		if( grado_max_figlio > massimo )
				massimo = grado_max_figlio;
		figlio = figlio->right;
	}

	// ora mio_grado contiene il mumero dei miei figli
	// grado_massimo contiene il grado massimo di un nodo contenuto nei sottalberi

	if ( mio_grado > massimo ) return mio_grado;
	return massimo;
}



