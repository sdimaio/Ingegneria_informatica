#include <stdlib.h>
#include <stdio.h>
#include "lista_array.h"
#include "error.h"


lista_array* create_lista_array(int maxsize) {

	lista_array* l = (lista_array*)malloc(sizeof(lista_array));
	l->maxsize = maxsize;
	l->info = (int*)calloc(l->maxsize,sizeof(int));
	l->next = (int*)calloc(l->maxsize,sizeof(int));
	l->prev = (int*)calloc(l->maxsize,sizeof(int));
	int i;
	for(i = 0; i < l->maxsize; i++) {
		l->next[i] = i+1;
		l->prev[i] = i-1;
	}
	l->next[l->maxsize-1] = -1;
	l->head = -1;
	l->free = 0;
	return l;
}


int allocate_column(lista_array* l) {

	if( l->free == -1 )
		error("allocate_column() su lista piena\n");

	int output = l->free;
	l->free = l->next[l->free];  // potrebbe essere -1
	if( l->free != -1 )          // se e' rimasta un'altra colonna libera...
		l->prev[l->free] = -1;   // ... diventa la prima colonna della lista libera
	return output;
}

void free_column(lista_array* l, int c) {

	l->next[c] = l->free;  // potrebbe essere -1
    l->prev[c] = -1;       // c diventa il primo elemento della lista libera
    if( l->free != -1)     // se c'era gia' un elemento nella lista libera...
    	l->prev[l->free] = c;   // ... e' diventato il secondo elemento
    l->free = c;
}

void insert_lista_array(lista_array* l, int x) {

	int c = allocate_column(l);
	l->info[c] = x;
	l->next[c] = l->head;  // potrebbe essere -1 se la lista era vuota
	l->prev[c] = -1;       // sono il primo della lista
	if( l->head != -1) // se c'era già un elemento nella lista...
		l->prev[l->head] = c;  // ... e' diventato il secondo elemento
	l->head = c;
}

void delete_lista_array(lista_array* l, int i) {

	if (l->head == -1 ){
		error("delete_lista_array() su lista vuota");
	}

    /* MODIFICA "A MONTE" DI i */

	if(l->head == i) {  // sto cancellando il primo elemento della lista
		l->head = l->next[i];   // la lista comincia dal "prossimo" elemento
								// se i fosse stato l'unico elemento ora l->head = -1
	} else {
		l->next[l->prev[i]] = l->next[i];  // potrebbe essere -1 se i era l'ultimo elemento
	}

    /* MODIFICA "A VALLE" DI i */

	if(l->next[i] != -1) {  // c'e' un elemento che segue i
		l->prev[l->next[i]] = l->prev[i];	// se i fosse stato il primo elemento allora
	 										// l->prev[i] = -1 e dunque adesso il primo
	 										// elemento della lista corrente ha prev = -1
	}

	free_column(l,i);
}

void print_lista_array(lista_array* l) {

	printf("elementi della lista: ");
	int i = l->head;
	while (i != -1) {
		printf("%d ", l->info[i]);
		i = l->next[i];
	}
	printf("\n");

	printf("l->head = %d; l->free = %d\n", l->head, l->free);
	for( i=0; i < l->maxsize; i++ ) {
		printf("%d\t",l->next[i]);
	}
	printf("\n");
	for( i=0; i < l->maxsize; i++ ) {
		printf("%d\t",l->info[i]);
	}
	printf("\n");
	for( i=0; i < l->maxsize; i++ ) {
		printf("%d\t",l->prev[i]);
	}
	printf("\n");

}