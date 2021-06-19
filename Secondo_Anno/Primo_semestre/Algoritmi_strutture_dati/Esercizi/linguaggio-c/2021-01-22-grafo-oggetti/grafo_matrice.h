#ifndef _GRAFO_MATRICE_H
#define _GRAFO_MATRICE_H

typedef struct {

	int   numero_nodi;
	int** matrice;

} grafo_matrice;


grafo_matrice* crea_grafo_matrice(int numero_nodi);

void aggiungi_arco_matrice(grafo_matrice* g, int i, int j);

void stampa_grafo_matrice(grafo_matrice* g);

void bfs_matrice(grafo_matrice* g, int v);

#endif