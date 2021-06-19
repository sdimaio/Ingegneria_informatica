#include <stdlib.h>  
#include <stdio.h>

#include "grafo_matrice.h"
#include "grafo_liste.h"
#include "grafo_oggetti.h"

void main() {

	grafo_matrice* g_matrice = crea_grafo_matrice(10);

	int i;
	for( i = 0; i < 9; i++) {
		aggiungi_arco_matrice(g_matrice, i, i+1);
	}

    stampa_grafo_matrice(g_matrice);


    grafo_liste* g_liste = crea_grafo_liste(10);

    aggiungi_arco_liste(g_liste, 0, 1);
    aggiungi_arco_liste(g_liste, 1, 2);
    aggiungi_arco_liste(g_liste, 8, 9);

    printf("\n");
    stampa_grafo_liste(g_liste);

    grafo_liste* g_liste2 = liste(g_matrice);

    printf("\n");
    stampa_grafo_liste(g_liste2);

    bfs_liste(g_liste2, 5);

    printf("\n");
    //bfs_matrice(g_matrice,5);

    printf("is_connected_liste(g_liste) =%d\n", is_connected_liste(g_liste));
    printf("is_connected_liste(g_liste2)=%d\n", is_connected_liste(g_liste2));

    // int color[g_liste2->numero_nodi];  // non e' ANSI C
    int* color = (int*)calloc(g_liste2->numero_nodi,sizeof(int));

    dfs_liste_color(g_liste2, color, 5);
    for( i = 0; i < g_liste2->numero_nodi; i++) {
        if ( color[i] == 0 )
            printf("trovato nodo %d non raggiunto dalla visita\n",i);
    }
    printf("terminato il test di connettivita' di g_liste2\n");

    /* da qui in poi analisi delle componenti connesse */

    printf("\n");
    int* color2 = (int*)calloc(g_liste->numero_nodi,sizeof(int));

    int mark = 0;
    for( i = 0; i < g_liste->numero_nodi; i++) {

        // lancio una visita su ogni nodo non colorato
        if ( color2[i] == 0) {
            mark = mark + 1;
            dfs_liste_color_mark(g_liste,color2,i,mark);
        }    
    }

    int dim_componente_maggiore = 0;
    int componente_maggiore = 0;     // un valore non legittimo
    printf("Le dimensioni delle %d componenti connesse sono le seguenti:\n", mark);
    int c;
    for( c = 1; c <= mark; c++ ) {
        int nodi_componente = 0;
        for( i = 0; i < g_liste->numero_nodi; i++ ) {
            if (color2[i] == c) {  // il nodo i appartiene alla componente c
                nodi_componente++;
            }
        }
        printf("la componente %d ha %d nodi\n",c,nodi_componente);
        if( nodi_componente > dim_componente_maggiore) {
            dim_componente_maggiore = nodi_componente;
            componente_maggiore = c;
        }
    } 
    printf("la componente maggiore e' la componente %d che ha %d nodi\n",
            componente_maggiore, dim_componente_maggiore);

    /* da qui in poi analisi delle componenti connesse */

    printf("\n");
    int* color3 = (int*)calloc(g_liste->numero_nodi,sizeof(int));

    for( i = 0; i < g_liste->numero_nodi; i++) {
        // lancio una visita su ogni nodo non colorato
        if ( color3[i] == 0) {
            printf("trovata componenente connessa di dimensione %d\n", 
                          dfs_liste_color_size(g_liste,color3,i));
        }    
    }
   
    /* da qui in poi esperimenti con un grafo rappresentato tramite
       oggetti e riferimenti */

    grafo_oggetti* grafo_oggetti = crea_grafo_oggetti();
    printf("\n");
    printf("creato il grafo con oggetti e riferimenti\n");

    nodo* n1 = aggiungi_oggetto_nodo(grafo_oggetti);
    nodo* n2 = aggiungi_oggetto_nodo(grafo_oggetti);
    nodo* n3 = aggiungi_oggetto_nodo(grafo_oggetti);
    nodo* n4 = aggiungi_oggetto_nodo(grafo_oggetti);
    nodo* n5 = aggiungi_oggetto_nodo(grafo_oggetti);

    aggiungi_oggetto_arco(grafo_oggetti, n1, n5);
    aggiungi_oggetto_arco(grafo_oggetti, n2, n4);

    printf("il grafo ha %d nodi e %d archi\n", 
            grafo_oggetti->numero_nodi,
            grafo_oggetti->numero_archi);

    // metto a zero tutti i colori dei nodi
    //
    elem_nodi* ln = grafo_oggetti->nodi;
    while( ln != NULL ) {
        ln->info->color = 0;
        ln = ln->next;
    }

    int comp = 0;
    ln = grafo_oggetti->nodi;
    while( ln != NULL ) {
        if( ln->info->color == 0 ) {
            comp++;
            dfs_visit_oggetti(ln->info,comp);
        }
        ln = ln->next;
    }

    printf("il grafo ha %d componenti connesse\n", comp);

    for( c = 1; c <= comp ; c++) {

        int conta_nodi = 0;
        ln = grafo_oggetti->nodi;
        while( ln != NULL ) {
            if( ln->info->color == c) {
                conta_nodi++;
            }
            ln = ln->next;
        }
        printf("la componente %d ha %d nodi\n",c,conta_nodi);
    }

    free(color);
    free(color2);
    free(color3);
}



