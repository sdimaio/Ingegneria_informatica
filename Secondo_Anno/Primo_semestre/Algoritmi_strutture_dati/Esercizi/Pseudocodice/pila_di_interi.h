#ifndef _PILA_DI_INTERI_H
#difine _PILA_DI_INTERI_H

#include <stdlib.h>

typedef struct pdi {
  int* A;
  int size;
  int top;        //indice elemento affiorante
} pila_di_interi;

pila_di_interi* new_stack(int default_size);

int is_empty(pila_di_interi* pp);

void push(pila_di_interi* pp, int v);

int pop(pila_di_interi* pp)

void print_pila_di_interi(pila_di_interi* pp);



#endif
