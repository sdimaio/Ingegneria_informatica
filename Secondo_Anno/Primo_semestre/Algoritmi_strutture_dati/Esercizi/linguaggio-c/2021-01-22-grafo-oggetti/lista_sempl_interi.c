#include <stdlib.h>
#include <stdio.h>
#include "lista_sempl_interi.h"
#include "error.h"

void insert_lista_sempl_interi(lista_sempl_interi* pl, int val) {

  // pl è un puntatore alla lista, cioè un puntatore ad un puntatore a slitem
  // (*pl) è proprio la lista esterna (come se fosse passata per riferimento)

 	slitem* nuovo_elem = (slitem*)malloc(sizeof(slitem));
 	nuovo_elem->info = val;
 	nuovo_elem->next = (*pl);
 	(*pl) = nuovo_elem;  
}

int delete_first_lista_sempl_interi(lista_sempl_interi* pl) {

	if( (*pl) == NULL ) error("delete_first_lista_sempl_interi() su lista vuota");

	int output = (*pl)->info;
	lista_sempl_interi punt_primo_elem = (*pl);
	(*pl) = (*pl)->next;
	free(punt_primo_elem); 
	return output;
}

/* ritorna un puntatore all'elemento della lista contenente il 
   valore specificato oppure NULL se l'elemento non c'e' */

slitem* search_lista_sempl_interi(lista_sempl_interi l, int val) {

	while (l != NULL) {
		if (l->info == val)
			return l;
		l = l-> next;
	}
	return NULL;
}

/* Cancella l'elemento puntato da pi. Controlla se la lista sia non vuota. */

void delete_lista_sempl_interi(lista_sempl_interi* pl, slitem* pi) {

	if( (*pl) == NULL ) error("delete_lista_sempl_interi() con lista NULL");
	if( pi == NULL ) error("delete_lista_sempl_interi() con puntatore NULL");
	if( (*pl) == pi )  {  // stai cancellando il primo elemento della lista
		delete_first_lista_sempl_interi(pl);
	}

	slitem* x = (*pl);  // x e' un iteratore per scorrere la lista
	while( x != NULL ) {
		if( x->next == pi ) {     // cerco l'elemento che precede pi
			x->next = pi->next;   // potrebbe essere NULL (se pi e' l'ultimo elemento)
			free(pi);
			return;
		}
		x = x->next;
	}

	/*  // codice equivalente

	slitem* x = (*pl);  // x e' un iteratore per scorrere la lista
	while( x->next != pi ) {
		x = x->next;
		if ( x == NULL) break;
	}
	x->next = pi->next;
	free(pi);
	return;
	*/
}

void print_lista_sempl_interi(lista_sempl_interi l) {

	printf("lista = ");
	while( l != NULL) {
		printf("%d ", l->info);
		l = l->next;
	}
	printf("\n");
}
