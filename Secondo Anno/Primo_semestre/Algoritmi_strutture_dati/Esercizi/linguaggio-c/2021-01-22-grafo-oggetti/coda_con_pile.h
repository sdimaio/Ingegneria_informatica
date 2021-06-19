#ifndef _CODA_CON_PILE_H
#define _CODA_CON_PILE_H

#include "pila_di_interi.h"

typedef struct cdi {

	pila_di_interi* p1;
	pila_di_interi* p2; 

} coda_con_pile;

coda_con_pile* new_queue(int default_size); 

int is_empty_coda_con_pile(coda_con_pile* pc);

int dequeue(coda_con_pile* pc);

void enqueue(coda_con_pile* pc, int x);

void stampa_coda_con_pile(coda_con_pile* pc);

#endif