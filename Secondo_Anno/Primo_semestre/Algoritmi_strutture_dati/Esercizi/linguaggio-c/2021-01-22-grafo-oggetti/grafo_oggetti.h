#ifndef _GRAFO_OGGETTI_H
#define _GRAFO_OGGETTI_H

typedef struct elem_lista_nodi elem_nodi;   // forward declaration
typedef struct elem_lista_archi elem_archi; // forward declaration

typedef struct nodo_struct {
	elem_nodi* pos;  /* posizione nodo nella lista del grafo */ 
	elem_archi* archi;   // lista archi incidenti
    int color;
} nodo;

typedef struct arco_struct {
	elem_archi* pos;  // pos. arco lista grafo
	nodo* from;  
	nodo* to;
	elem_archi* frompos;  // pos. arco nodo from
	elem_archi* topos;       // pos. arco nodo to
} arco;

typedef struct elem_lista_nodi {   
	struct elem_lista_nodi* prev;
	struct elem_lista_nodi* next;
	nodo* info;
} elem_nodi;   // elemento di una lista di nodi

typedef struct elem_lista_archi {
	struct elem_lista_archi* prev;
	struct elem_lista_archi* next;
	arco* info;
} elem_archi;  // elemento di una lista di archi

typedef struct {
	int numero_nodi;
	int numero_archi;
	elem_archi* archi;  // lista degli archi
	elem_nodi* nodi;    // lista dei nodi
} grafo_oggetti;

grafo_oggetti* crea_grafo_oggetti();

nodo* aggiungi_oggetto_nodo(grafo_oggetti* g);

arco* aggiungi_oggetto_arco(grafo_oggetti* g, nodo* n1, nodo* n2);

void dfs_visit_oggetti(nodo* n, int mark);


#endif