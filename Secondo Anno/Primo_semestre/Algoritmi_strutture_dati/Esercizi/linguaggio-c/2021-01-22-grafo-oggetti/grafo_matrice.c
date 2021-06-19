#include <stdlib.h>  
#include <stdio.h>

#include "grafo_matrice.h"
#include "coda_di_interi.h"

grafo_matrice* crea_grafo_matrice(int numero_nodi) {

	grafo_matrice* grafo = (grafo_matrice*)malloc(sizeof(grafo_matrice));

	grafo->numero_nodi = numero_nodi;
	grafo->matrice = (int**)calloc(grafo->numero_nodi,sizeof(int*));
	int r;
	for( r = 0; r < grafo->numero_nodi; r++) {
		grafo->matrice[r] = (int*)calloc(grafo->numero_nodi,sizeof(int));
	}

	// grafo->matrice[5][6] = 1   // cosi' inseriro' un arco tra 5 e 6

	return grafo;
}

void aggiungi_arco_matrice(grafo_matrice* g, int i, int j) {

	g->matrice[i][j] = 1;
	g->matrice[j][i] = 1;	// arco non orientato => metto anche l'opposto

}

void stampa_grafo_matrice(grafo_matrice* g) {

	int r, c;
	for( r = 0; r < g->numero_nodi; r++ ) {

		for( c = 0; c < g->numero_nodi; c++) {
			printf("%d ", g->matrice[r][c]);
		}
		printf("\n");

	}

}

void bfs_matrice(grafo_matrice* g, int v) {

	// alloco un array di interi (gia' inizializzato dalla calloc)
	//
	int* color = (int*)calloc(g->numero_nodi,sizeof(int));

	coda_di_interi* q = new_queue(g->numero_nodi);

	enqueue(q,v);
	color[v] = 1;

	while ( !is_empty(q) ) {

		int u = dequeue(q);
		printf("dequeue del nodo %d\n",u);

		int i;
		for( i = 0; i < g->numero_nodi ; i++) {
			if( g->matrice[u][i] != 0 ) {  // c'e' un arco da u ad i
				if( color[i] == 0 ) {  // il nodo i non e' visitato
					enqueue(q,i);
					color[i] = 1;
				}
			}
		}
	} 
}
