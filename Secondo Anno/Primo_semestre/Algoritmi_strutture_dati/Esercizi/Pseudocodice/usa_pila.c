#include <stdio.h>
#include <strlib.h>
#include "pila_di_interi.h"

int main(){

  pila_di_interi* pp = new_stack(4);

  /*
  errore di underflow
  printf("pop sulla pipla vuota");
  printf("pop = %d\n", pop(pp));
  print_pila_di_interi(pp);
  */

  printf("push di 1\n" );
  push(pp, 1);
  print_pila_di_interi(pp);

  printf("push di 2\n" );
  push(pp, 2);
  print_pila_di_interi(pp);

  printf("push di 3\n" );
  push(pp, 3);
  print_pila_di_interi(pp);

  printf("push di 4\n" );
  push(pp, 4);
  print_pila_di_interi(pp);

  printf("pop = %d\n",pop(pp));
  print_pila_di_interi(pp);

  printf("push di 5\n" );
  push(pp, 5);
  print_pila_di_interi(pp);

  printf("push di 6\n" );
  push(pp, 6);
  print_pila_di_interi(pp);

  printf("push di 7\n" );
  push(pp, 7);
  print_pila_di_interi(pp);
}
