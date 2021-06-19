#include <stdlib.h>
#include <stdio.h>
#include "albero_arbitrario_interi.h"
#include "stampa_albero_binario.h"
#include "stampa_albero_arbitrario.h"


int main() {


	albero a = NULL;  // questa volta e' un albero arbitrario

	aggiungi_radice(&a, 1);
	int i;
	for(i = 1; i < 20; i++ ) {
		 nodo* figlio = aggiungi_un_figlio(a,i);
		 if( figlio->info % 10 == 0) {
		 	int j;
		 	for( j = 0; j < 5; j++) {
		 		aggiungi_un_figlio(figlio,20+j);
		 		printf("aggiungo il figlio %d a %d\n",20+j,figlio->info);
		 	}
		 }
	}
	stampa_figli(a);

	printf("conta_nodi_arbitrario(a) = %d\n", conta_nodi_arbitrario(a));
	printf("conta_nodi_arbitrario2(a) = %d\n", conta_nodi_arbitrario2(a));

	stampa_albero_arbitrario(a);

    printf("cerco il nodo 20 = %d\n", NULL != cerca_nodo_arbitrario(a, 20));
    printf("cerco il nodo 20 = %d\n", NULL != cerca_nodo_arbitrario2(a, 20));
    printf("cerco il nodo 30 = %d\n", NULL != cerca_nodo_arbitrario(a, 30));
    printf("cerco il nodo 30 = %d\n", NULL != cerca_nodo_arbitrario2(a, 30));
    printf("cerco il nodo 24 = %d\n", NULL != cerca_nodo_arbitrario(a, 24));
    printf("cerco il nodo 24 = %d\n", NULL != cerca_nodo_arbitrario2(a, 24));

    printf("profondita_arbitrario(a) = %d\n",profondita_arbitrario(a));
    printf("profondita_arbitrario2(a) = %d\n",profondita_arbitrario2(a));

    printf("grado_massimo(a) = %d\n",grado_massimo(a));
}