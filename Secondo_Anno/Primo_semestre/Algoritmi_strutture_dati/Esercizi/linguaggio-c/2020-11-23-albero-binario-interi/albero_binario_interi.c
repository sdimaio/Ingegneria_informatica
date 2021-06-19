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
