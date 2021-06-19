#ifndef _GRAFO_LISTE_H
#define _GRAFO_LISTE_H

#include "grafo_matrice.h"

typedef struct elem_lista_int {   
	struct elem_lista_int* prev;
	struct elem_lista_int* next;
	int info; // identificatore di un nodo
} elem_int;   // elemento di una lista di interi

typedef struct {

	int   numero_nodi;
	elem_int**  array;

} grafo_liste;


grafo_liste* crea_grafo_liste(int numero_nodi);

void stampa_grafo_liste(grafo_liste* g);

void aggiungi_arco_liste(grafo_liste* g, int i, int j);

grafo_liste* liste(grafo_matrice* gm);

void bfs_liste(grafo_liste* g, int v);

void bfs_liste_color(grafo_liste* g, int* color, int v);

int is_connected_liste(grafo_liste* g);

int componenti_connesse_liste(grafo_liste* g);

void dfs_liste_color(grafo_liste* g, int* color, int v);

void dfs_liste_color_mark(grafo_liste* g, int* color, int v, int mark);

int dfs_liste_color_size(grafo_liste* g, int* color, int v);

int dfs_liste_color_archi(grafo_liste* g, int* color, int v);

#endif