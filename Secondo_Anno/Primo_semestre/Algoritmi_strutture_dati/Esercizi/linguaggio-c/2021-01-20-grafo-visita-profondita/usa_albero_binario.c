#include <stdlib.h>
#include <stdio.h>
#include "albero_binario_interi.h"
#include "stampa_albero_binario.h"
#include "lista_interi.h"


int main() {


	albero a = NULL;

	aggiungi_radice(&a, 8);
	nodo* left = aggiungi_figlio_sinistro(a,10);
	nodo* right = aggiungi_figlio_destro(a,5);
	//nodo* left_right = aggiungi_figlio_destro(left,3);
	nodo* left_left = aggiungi_figlio_sinistro(left,3);
    nodo* left_right = aggiungi_figlio_destro(left,4);
    nodo* left_right_right = aggiungi_figlio_destro(left_right,2);

	nodo* scorri = right;
	int i;
	for( i = 10; i < 20; i++) {
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

    /*
    stampa_parentetica_simmetrica(a);
    printf("\n");
    stampa_parentetica_preordine(a);
    printf("\n");
    */
    stampa_albero_binario(a);

    printf("valore_nonno(a) = %d\n",valore_nonno(a));
    printf("num_nodi_info_maggiore_figli(a) = %d\n", num_nodi_info_maggiore_figli(a));
    printf("num_nodi_info_maggiore_sottoalberi(a) = %d\n", num_nodi_info_maggiore_sottoalberi(a));

    printf("lista_cammino(a,cerca_nodo_preordine(a,12)) = ");
    litem* mia_lista = lista_cammino(a,cerca_nodo_preordine(a,12));
    print_lista_interi(mia_lista);

    printf("lista_cammino(a,cerca_nodo_preordine(a,2)) = ");
    litem* mia_lista2 = lista_cammino(a,cerca_nodo_preordine(a,2));
    print_lista_interi(mia_lista2);

    printf("lista_cammino(a,cerca_nodo_preordine(right,19)) = ");
    litem* mia_lista3 = lista_cammino(right,cerca_nodo_preordine(a,19));
    print_lista_interi(mia_lista3);


    printf("grado_parentela(a,cerca_nodo_preordine(a,2),cerca_nodo_preordine(3)) = %d\n",
            grado_parentela(a,cerca_nodo_preordine(a,2),cerca_nodo_preordine(a,3)));

    printf("grado_parentela(a,cerca_nodo_preordine(a,2),cerca_nodo_preordine(19)) = %d\n",
            grado_parentela(a,cerca_nodo_preordine(a,2),cerca_nodo_preordine(a,19)));


    // deallocare lista1, lista2, lista3 albero a.

}