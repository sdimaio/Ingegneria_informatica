#include <stdlib.h>
#include <stdio.h>

#include "coda_con_pile.h"

int main() {

	coda_con_pile* pc = new_queue(4);
	stampa_coda_con_pile(pc);

	int i; 
	for( i = 1; i < 50; i++ ) {

		if( i % 3 == 0 ) {  // una volta ogni tre
			printf("dequeue dell'elemento %d\n",dequeue(pc));
			stampa_coda_con_pile(pc);
		} else {	
			printf("inserisco l'elemento %d\n",i);
			enqueue(pc,i);
			stampa_coda_con_pile(pc);
		}
	}

	/*
	for( i = 0; i < 2; i++ ) {

		printf("dequeue dell'elemento %d\n",dequeue(pc));
		stampa_coda_di_interi(pc);
	}
	*/


}