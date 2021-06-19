#include <stdlib.h>
#include <stdio.h>
#include "albero_binario_interi.h"


int main() {


	albero a = NULL;

	aggiungi_radice(&a, 1);
	nodo* left = aggiungi_figlio_sinistro(a,2);
	nodo* right = aggiungi_figlio_destro(a,5);
	//nodo* left_right = aggiungi_figlio_destro(left,3);
	nodo* left_left = aggiungi_figlio_sinistro(left,3);
	nodo* left_right = aggiungi_figlio_destro(left,4);

	nodo* scorri = right;
	int i;
	for( i = 10; i < 100; i++) {
		if( i%2 == 0 )
			scorri = aggiungi_figlio_sinistro(scorri,i);
		else
			scorri = aggiungi_figlio_destro(scorri,i); 
	}


    printf("only_left(a) = %d\n", only_left(a));

    int cercami = 1;
    printf("cerca_nodo_preordine(a,%d) = %d\n",cercami, cerca_nodo_preordine(a,cercami) != NULL);
    cercami = 6;
    printf("cerca_nodo_preordine(a,%d) = %d\n",cercami, cerca_nodo_preordine(a,cercami) != NULL);
    cercami = 4;
    printf("cerca_nodo_preordine(a,%d) = %d\n",cercami, cerca_nodo_preordine(a,cercami) != NULL);

    cercami = 1;
    printf("esiste_nodo_preordine(a,%d) = %d\n",cercami, esiste_nodo_preordine(a,cercami));
    cercami = 6;
    printf("esiste_nodo_preordine(a,%d) = %d\n",cercami, esiste_nodo_preordine(a,cercami));
    cercami = 4;
    printf("esiste_nodo_preordine(a,%d) = %d\n",cercami, esiste_nodo_preordine(a,cercami));

    cercami = 1;
    printf("cerca_nodo_postordine(a,%d) = %d\n",cercami, cerca_nodo_postordine(a,cercami) != NULL);
    cercami = 6;
    printf("cerca_nodo_postordine(a,%d) = %d\n",cercami, cerca_nodo_postordine(a,cercami) != NULL);
    cercami = 4;
    printf("cerca_nodo_postordine(a,%d) = %d\n",cercami, cerca_nodo_postordine(a,cercami) != NULL);

    printf("cammino_ricorsivo(a) = %d\n", cammino_ricorsivo(a));
    printf("cammino_iterativo(a) = %d\n", cammino_iterativo(a));
    printf("cammino_ricorsivo(right) = %d\n", cammino_ricorsivo(right));
    printf("cammino_iterativo(right) = %d\n", cammino_iterativo(right));

    printf("altezza_albero_binario(a) = %d\n", altezza_albero_binario(a));
    printf("altezza_albero_binario_2(a) = %d\n", altezza_albero_binario_2(a));
    
    int mio_id = 50;
    printf("cerca_profondita_nodo(a,%d) = %d\n", mio_id, cerca_profondita_nodo(a,mio_id));
    mio_id = 4;
    printf("cerca_profondita_nodo(a,%d) = %d\n", mio_id, cerca_profondita_nodo(a,mio_id));

    stampa_parentetica_simmetrica(a);
    printf("\n");
    stampa_parentetica_preordine(a);
    printf("\n");
}