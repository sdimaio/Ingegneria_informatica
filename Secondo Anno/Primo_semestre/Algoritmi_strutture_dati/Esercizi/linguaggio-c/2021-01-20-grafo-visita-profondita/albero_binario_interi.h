#ifndef _ALBERO_BINARIO_INTERI_H
#define _ALBERO_BINARIO_INTERI_H

#include "lista_interi.h"

typedef struct nodo {

	struct nodo* parent;
	struct nodo* left;
	struct nodo* right;
	int info;
} nodo;

typedef nodo* albero;

/* non ho bisogno di costruttori perche' un nuovo albero
   vuoto e' definito cosi' (tre scritture equivalenti):

   struct nodo* mio_albero = NULL;
   nodo* mio_albero = NULL;
   albero mio_albero = NULL;
*/

void aggiungi_radice(albero* pa, int val);

nodo* aggiungi_figlio_sinistro(nodo* n, int val);   

nodo* aggiungi_figlio_destro(nodo* n, int val);   

int only_left(albero a);

nodo* cerca_nodo_preordine(nodo* n, int val);
int esiste_nodo_preordine(nodo* n, int val);
nodo* cerca_nodo_postordine(nodo* n, int val);
nodo* cerca_nodo_simmetrica(nodo* n, int val);

int conta_nodi_postordine(nodo*);
int somma_nodi_postordine(nodo*);

int cammino_ricorsivo(nodo* n);
int cammino_iterativo(nodo* n);

int altezza_albero_binario(nodo* n);
int altezza_albero_binario_2(nodo* n);

int cerca_profondita_nodo(nodo* n, int mio_id);

void stampa_parentetica_simmetrica(nodo* n);
void stampa_parentetica_preordine(nodo* n);

int valore_nonno(nodo* n);
int num_nodi_info_maggiore_figli(nodo* n);

int num_nodi_info_maggiore_sottoalberi(nodo* n);

litem* lista_cammino(nodo* radice, nodo* n);

int grado_parentela(nodo* radice, nodo* n1, nodo* n2);

#endif