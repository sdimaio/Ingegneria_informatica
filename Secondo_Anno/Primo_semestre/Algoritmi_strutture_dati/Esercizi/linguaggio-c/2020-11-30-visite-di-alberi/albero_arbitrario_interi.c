



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
