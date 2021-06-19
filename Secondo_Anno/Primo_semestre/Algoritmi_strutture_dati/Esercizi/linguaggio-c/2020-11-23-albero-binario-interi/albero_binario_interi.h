#ifndef _ALBERO_BINARIO_INTERI_H
#define _ALBERO_BINARIO_INTERI_H

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

void aggiungi_radice(albero* a, int val);

nodo* aggiungi_figlio_sinistro(nodo* n, int val);   

nodo* aggiungi_figlio_destro(nodo* n, int val);   



#endif