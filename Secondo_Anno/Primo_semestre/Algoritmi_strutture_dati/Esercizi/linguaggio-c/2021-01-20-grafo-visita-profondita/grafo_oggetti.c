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



