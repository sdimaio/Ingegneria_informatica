#ifndef _ALBERO_ARBITRARIO_INTERI_H
#define _ALBERO_ARBITRARIO_INTERI_H

#include "albero_binario_interi.h"

/* Le strutture sono le stesse dell'albero 
   binario, dove questa volta il campo left 
   deve essere interpretato come "puntatore al
   primo figlio" e il campo right deve essere
   interpretato come "puntatore al prossimo fratello"

   Anche la funzione aggiungi_radice() rimane invariata.
*/ 


nodo* aggiungi_un_figlio(nodo* n, int val);  

void stampa_figli(nodo* n); 

int conta_nodi_arbitrario(nodo* n);
int conta_nodi_arbitrario2(nodo* n);

nodo* cerca_nodo_arbitrario(nodo* n, int info);
nodo* cerca_nodo_arbitrario2(nodo* n, int info);

int profondita_arbitrario(nodo* n);
int profondita_arbitrario2(nodo* n);

int grado_massimo(nodo* n);


#endif