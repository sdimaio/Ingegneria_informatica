#include <stdlib.h>
#include <stdio.h>
#include "albero_arbitrario_interi.h"


int main() {


	albero a = NULL;  // questa volta e' un albero arbitrario

	aggiungi_radice(&a, 1);
	int i;
	for(i = 0; i < 20; i++ ) {
		 aggiungi_un_figlio(a,i);

	}
	stampa_figli(a);
}