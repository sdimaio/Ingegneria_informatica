#include <stdlib.h>  
#include <stdio.h>

#include "grafo_oggetti.h"

grafo_oggetti* crea_grafo_oggetti() {

	grafo_oggetti* grafo = (grafo_oggetti*)malloc(sizeof(grafo_oggetti));

	grafo->numero_nodi = 0;
	grafo->numero_archi = 0;

	grafo->nodi = NULL;
	grafo->archi = NULL;

	return grafo;
}

nodo* aggiungi_oggetto_nodo(grafo_oggetti* g) {

	nodo* output = (nodo*)malloc(sizeof(nodo));

	elem_nodi* pos = (elem_nodi*)malloc(sizeof(elem_nodi));

	g->numero_nodi++;

	pos->prev = NULL;
	pos->next = g->nodi;
	pos->info = output;

	if ( g->nodi != NULL ) {
		g->nodi->prev = pos;
	}
	g->nodi = pos;

	output->pos = pos;
	output->color = 0;
	output->archi = NULL;

	return output;
}

arco* aggiungi_oggetto_arco(grafo_oggetti* g, nodo* n1, nodo* n2) {

	arco* mio_arco = (arco*)malloc(sizeof(arco));

	elem_archi* li1 = (elem_archi*)malloc(sizeof(elem_archi));  // nella lista del grafo
	elem_archi* li2 = (elem_archi*)malloc(sizeof(elem_archi));  // nella lista del primo nodo
	elem_archi* li3 = (elem_archi*)malloc(sizeof(elem_archi));  // nella lista del secondo nodo

	// inizializzo il list-item per la lista del grafo
	//
	li1->info = mio_arco;
	li1->prev = NULL;
	li1->next = g->archi;

	// mi metto nella lista del grafo
	//
	if( g->archi != NULL ) {
		g->archi->prev = li1;
	}
	g->archi = li1;
	g->numero_archi++;

	// inizializzo il list-item per la lista del primo nodo
	//
	li2->info = mio_arco;
	li2->prev = NULL;
	li2->next = n1->archi;

	// mi metto nella lista del primo nodo
	//
	if( n1->archi != NULL ) {
		n1->archi->prev = li2;
	}
	n1->archi = li2;

	// inizializzo il list-item per la lista del secondo nodo
	//
	li3->info = mio_arco;
	li3->prev = NULL;
	li3->next = n2->archi;

	// mi metto nella lista del secondo nodo
	//
	if( n2->archi != NULL ) {
		n2->archi->prev = li3;
	}
	n2->archi = li3;

	mio_arco->from = n1;
	mio_arco->to = n2;
	mio_arco->pos = li1;     // posizione nella lista del grafo
	mio_arco->frompos = li2; // posizione nella lista del primo nodo
	mio_arco->topos = li3;   // posizione nella lista del secondo nodo

	return mio_arco;
}

/* esempio di funzione per trovare l'estremo di un arco */

nodo* altro_nodo(arco* a, nodo* n) {

	if( n == a->from ) return a->to;
	return a->from;
}

/* visita in profondita' di un grafo rappresentato 
   con oggetti e riferimenti. I nodi visitati vengono
   colorati con l'intero mark. */

void dfs_visit_oggetti(nodo* n, int mark) {

	n->color = mark;
	
	elem_archi* la = n->archi;
	while ( la != NULL ) {
		nodo* n2;   // il nodo raggiunto tramite questo arco
		if( la->info->from == n ) {
			n2 = la->info->to;
		} else {
			n2 = la->info->from;
		}
		/* codice alternativo
		nodo* n2 = la->info->from;
		if (n2 == n) n2 = la->info->to;
		*/
		/* altro codice alternativo
		nodo* n2 = altro_nodo(la->info,n);
		*/
		if( n2->color == 0) {
			dfs_visit_oggetti(n2,mark);
		}
		la = la->next;
	}
}











