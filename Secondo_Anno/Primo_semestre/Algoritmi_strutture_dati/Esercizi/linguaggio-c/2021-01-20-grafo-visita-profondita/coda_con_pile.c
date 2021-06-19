#include <stdlib.h>
#include <stdio.h>

#include "coda_con_pile.h"

coda_con_pile* new_queue(int default_size) {

	coda_con_pile* pc = (coda_con_pile*)malloc(sizeof(coda_con_pile));
	pc->p1 = new_stack(default_size);
	pc->p2 = new_stack(default_size);
	return pc;
}

int is_empty_coda_con_pile(coda_con_pile* pc);

/* il dequeue corrisponde ad un pop eseguito su p2
   previo rovesciamento di p1 su p2. */

int dequeue(coda_con_pile* pc) {

   while( !is_empty(pc->p1) ) {    // rovescio p1 dentro p2
   		push(pc->p2,pop(pc->p1));
   }
   return pop(pc->p2);
}

/* gli enqueue sulla coda corrispondono ad operazioni
   di push fatte sulla pila p1, previo rovesciamento
   (eventuale) degli elementi di p2 dentro p1 */

void enqueue(coda_con_pile* pc, int x) {

   while( !is_empty(pc->p2) ) {    // rovescio p2 dentro p1
   		push(pc->p1,pop(pc->p2));
   }
   push(pc->p1,x);
}

void stampa_coda_con_pile(coda_con_pile* pc) {
	print_pila_di_interi(pc->p1);
	print_pila_di_interi(pc->p2);
}
