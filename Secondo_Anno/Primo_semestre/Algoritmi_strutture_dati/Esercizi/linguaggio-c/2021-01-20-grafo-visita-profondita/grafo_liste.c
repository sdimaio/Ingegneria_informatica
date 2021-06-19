#include <stdlib.h>  
#include <stdio.h>

#include "grafo_liste.h"
#include "coda_di_interi.h"

grafo_liste* crea_grafo_liste(int numero_nodi) {

	grafo_liste* grafo = (grafo_liste*)malloc(sizeof(grafo_liste));

	grafo->numero_nodi = numero_nodi;
	grafo->array = (elem_int**)calloc(grafo->numero_nodi,sizeof(elem_int*));

	return grafo;
}


void stampa_grafo_liste(grafo_liste* g) {

	int i; 
	for( i = 0; i < g->numero_nodi; i++) {
		printf("[%d] ",i);
		elem_int* x = g->array[i];  // iteratore per le liste di adiacenza
        while( x != NULL ) {
        	printf("-> %d ",x->info);
        	x = x->next;
        }
        printf("\n");	
	}
}

/* Aggiunge un arco non diretto tra il nodo i e il nodo j.
   Si assume che l'arco non esista nel grafo. */

void aggiungi_arco_liste(grafo_liste* g, int i, int j) {

	if( i == j) {  // l'utente vuole inserire un loop

		elem_int* arcoii = (elem_int*)malloc(sizeof(elem_int));

		arcoii->prev = NULL; // lo inserisco come primo elemento della lista di i
		arcoii->next = g->array[i]; // il suo next e' quello che prima era il primo elemento
		arcoii->info = i;

		// aggiungo l'oggetto puntato da arcoij alla lista di adiacenza di i
		//
		if( g->array[i] != NULL ) {  // nella lista di i c'era gia' un elemento
			g->array[i]->prev = arcoii;
		}
		g->array[i] = arcoii;
		return;
	}


	elem_int* arcoij = (elem_int*)malloc(sizeof(elem_int));
	elem_int* arcoji = (elem_int*)malloc(sizeof(elem_int));

	arcoij->prev = NULL; // lo inserisco come primo elemento della lista di i
	arcoij->next = g->array[i]; // il suo next e' quello che prima era il primo elemento
	arcoij->info = j;

	arcoji->prev = NULL; // lo inserisco come primo elemento della lista di j
	arcoji->next = g->array[j]; // il suo next e' quello che prima era il primo elemento
	arcoji->info = i;

	// aggiungo l'oggetto puntato da arcoij alla lista di adiacenza di i
	//
	if( g->array[i] != NULL ) {  // nella lista di i c'era gia' un elemento
		g->array[i]->prev = arcoij;
	}
	g->array[i] = arcoij;

	// aggiungo l'oggetto puntato da arcoji alla lista di adiacenza di j
	//
	if( g->array[j] != NULL ) {  // nella lista di i c'era gia' un elemento
		g->array[j]->prev = arcoji;
	}
	g->array[j] = arcoji;

}

/* traduce un grafo rappresentato con una matrice di adiacenza
   in un grafo rappresentato tramite liste di adiacenza */

grafo_liste* liste(grafo_matrice* gm) {

	grafo_liste* gl = crea_grafo_liste(gm->numero_nodi);

	int r, c;
	for( r = 0; r < gm->numero_nodi; r++ ) {
		for( c = r; c < gm->numero_nodi; c++ ) {
			if( gm->matrice[r][c] == 1) {
				aggiungi_arco_liste(gl,r,c);
			}
		}

	}
	return gl;
}


void bfs_liste(grafo_liste* g, int v) {

	// alloco un array di interi (gia' inizializzato dalla calloc)
	//
	int* color = (int*)calloc(g->numero_nodi,sizeof(int));

	coda_di_interi* q = new_queue(g->numero_nodi);

	enqueue(q,v);
	color[v] = 1;

	while ( !is_empty(q) ) {

		int u = dequeue(q);
		printf("dequeue del nodo %d\n",u);

		elem_int* x = g->array[u];
		while ( x != NULL) {
			if( color[x->info] == 0 ) {
				enqueue(q,x->info);
				color[x->info] = 1;
			}
			x = x->next;
		}
	} 
}

/* Visita in ampiezza di un grafo non diretto in cui l'array 
   color viene passato dall'esterno. La dimensione dell'array
   color non e' specificata perche' e' sempre g->numero_nodi. */

void bfs_liste_color(grafo_liste* g, int* color, int v) {

	coda_di_interi* q = new_queue(g->numero_nodi);

	enqueue(q,v);
	color[v] = 1;

	while ( !is_empty(q) ) {

		int u = dequeue(q);
		printf("dequeue del nodo %d\n",u);

		elem_int* x = g->array[u];
		while ( x != NULL) {
			if( color[x->info] == 0 ) {
				enqueue(q,x->info);
				color[x->info] = 1;
			}
			x = x->next;
		}
	} 
}

int is_connected_liste(grafo_liste* g) {

	// alloco un array di interi (gia' inizializzato dalla calloc)
	//
	int* color = (int*)calloc(g->numero_nodi,sizeof(int));

	bfs_liste_color(g, color, 0);  // lancio una visita a partire dal nodo 0

	int i;
	for( i = 0; i < g->numero_nodi; i++) {
		if( color[i] == 0) {  	// ho trovato un nodo non visitato
			return 0;         	// il grafo non e' connesso
		}
	}
	return 1; 					// il grafo e' connesso
}

int componenti_connesse_liste(grafo_liste* g) {

	// alloco un array di interi (gia' inizializzato dalla calloc)
	//
	int* color = (int*)calloc(g->numero_nodi,sizeof(int));

	int componenti = 0;

	int i;
	for( i = 0; i < g->numero_nodi; i++) {
		if( color[i] == 0) {  	// ho trovato un nodo non visitato
			componenti++;
			bfs_liste_color(g, color, i);
		}
	}
	return componenti;
}

void dfs_liste_color(grafo_liste* g, int* color, int v) {

	color[v] = 1;  // marco il nodo v come visitato
	elem_int* x = g->array[v];
	while( x != NULL) {
		if( color[x->info] == 0) {  // il nodo x->info non e' visitato
			dfs_liste_color(g, color, x->info);
		}
		x = x->next;
	}
}

/* Esegue una visita in profondita' del grafo a partire dal nodo
   dato marcando tutti i nodi con il colore mark */


void dfs_liste_color_mark(grafo_liste* g, int* color, int v, int mark) {

	color[v] = mark;  // marco il nodo v come visitato
	elem_int* x = g->array[v];
	while( x != NULL) {
		if( color[x->info] == 0) {  // il nodo x->info non e' visitato
			dfs_liste_color_mark(g, color, x->info, mark);
		}
		x = x->next;
	}

}

/* Ritorna il numero dei nodi visitati a partire dal nodo v */

int dfs_liste_color_size(grafo_liste* g, int* color, int v) {

	int output = 1;  // conto intanto il nodo v stesso
	color[v] = 1;  // marco il nodo v come visitato
	elem_int* x = g->array[v];
	while( x != NULL) {
		if( color[x->info] == 0) {  // il nodo x->info non e' visitato
			output = output + dfs_liste_color_size(g, color, x->info);
		}
		x = x->next;
	}
	return output;
}

/* Ritorna il doppio del numero degli archi visti a partire dal nodo v.
   Assumiamo che non ci siano loop nel grafo. */

int dfs_liste_color_archi(grafo_liste* g, int* color, int v) {

	int output = 0;  // se il nodo e' isolato devo ritornare zero
	color[v] = 1;  // marco il nodo v come visitato
	elem_int* x = g->array[v];
	while( x != NULL) {
		output++;
		if( color[x->info] == 0) {  // il nodo x->info non e' visitato
			output = output + dfs_liste_color_archi(g, color, x->info);
		}
		x = x->next;
	}
	return output;
}