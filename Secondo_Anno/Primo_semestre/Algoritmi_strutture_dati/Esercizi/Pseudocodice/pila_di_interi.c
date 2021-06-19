#include <stdlib.h>
#include <stdio.h>

#include "pila_di_interi.h"
#include "error.h"

/* creazione di una pila specificata dall'utente*/
pila_di_interi* new_stack(int default_size){

  pila_di_interi* mia_pila = (pila_di_interi*)malloc(sizeof(pila_di_interi));
  mia_pila->size = default_size;
  mia_pila->A = (int*)calloc(mia_pila->size, sizeof(int));
  mia_pila->top = -1;   /*la pila è vuota*/

  return mia_pila;
}

/*verifica che la pila sia vuota*/
int is_empty(pila_di_interi* pp){

  return pp->top == -1;
}

/*iserisci un elemento nella pila*/
void push(pila_di_interi* pp, int v){

  if(pp->top == pp->size-1){
    pp->size = 2*pp->size;      //raddoppio la dimensione
    pp->A = (int*)realloc(pp->A, pp->size*sizeof(int));
    printf("dimensione attuale dell'array = %d\n",pp->size);
  }
  pp->top++;
  pp->A[pp.>top] = v;
}


void push_con_overflow(pila_di_interi* pp, int v){

  if(pp->top == pp->size-1)
    error("overflow della pila");
  pp->top++;
  pp->A[pp.>top] = v;
}

int pop(pila_di_interi* pp){

  if( is_empty(pp))
    error("pop su pila vuota");

  pp->top--;
  return pp->A[pp->top+1];

  /* equivalente a "return pp->A[++pp->top]"*/
}

void print_pila_di_interi(pila_di_interi* pp{

  int i;
printf("Pila di interi = ");
for( i = 0; i <= pp->top; i++){
  printf("%d ",pp->A[i]);
}
printf("\n");
}
