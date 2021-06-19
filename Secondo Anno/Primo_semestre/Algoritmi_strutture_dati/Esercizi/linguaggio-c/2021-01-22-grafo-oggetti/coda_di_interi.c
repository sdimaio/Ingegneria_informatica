#include <stdlib.h>
#include <stdio.h>

#include "coda_di_interi.h"
#include "error.h"

/* crea una coda vuota */

coda_di_interi* new_queue(int default_size) {

	coda_di_interi* pc = (coda_di_interi*)malloc(sizeof(coda_di_interi));
	pc->size = default_size;
	pc->A = (int*)calloc(pc->size,sizeof(int));
	pc->head = 0;
	pc->tail = 0;
	return pc;
}

/* verifica se la coda e' vuota */

int is_empty(coda_di_interi* pc) {

	return pc->head == pc->tail;
}

/* estrae un elemento dalla coda */

int dequeue(coda_di_interi* pc) {

	if( pc->head == pc->tail ) 
		error("dequeue su coda vuota\n");
	int x = pc->A[pc->head];
	pc->head = (pc->head+1) % pc->size;
	return x;

}


void enqueue(coda_di_interi* pc, int x) {

	if( pc->head == (pc->tail+1) % pc->size ) {
		printf("raddoppio della dimensione dell'array: %d -> %d\n",pc->size,pc->size*2);
		int* B = (int*)calloc(pc->size*2,sizeof(int));
		int i;
		/* esempio pc->size = 8, devo copiare 7 elementi su B[0]...B[6] */
		for( i = 0; i < pc->size-1 ; i++) {
			B[i] = pc->A[(pc->head+i) % pc->size]; 
		}
		/* sostituisco A con B */
		free(pc->A);
		pc->A = B;
		/* aggiorno pc->head, pc->tail e pc->size */
		pc->head = 0;
		pc->tail = pc->size-1;
		pc->size = pc->size * 2;
	}
	pc->A[pc->tail] = x;
	pc->tail = (pc->tail+1)%pc->size;
}

void enqueue_senza_crescita_telescopica(coda_di_interi* pc, int x) {

	if( pc->head == (pc->tail+1) % pc->size ) {
		// printf("lancio la procedura di errore\n");
		error("enqueue in coda piena\n");
	}
	pc->A[pc->tail] = x;
	pc->tail = (pc->tail+1)%pc->size;
}


void stampa_coda_di_interi(coda_di_interi* pc) {

	printf("array corrente: [");
	int i;
	for(i = 0; i < pc->size; i++) {
		printf("%d ",pc->A[i]);
	}
	printf("]\n");
	printf(" coda corrente: [");
	for( i = pc->head; i != pc->tail; i = (i+1) % pc->size ) {
	   printf("%d ",pc->A[i]);
	}	
	printf("]\n");
}







