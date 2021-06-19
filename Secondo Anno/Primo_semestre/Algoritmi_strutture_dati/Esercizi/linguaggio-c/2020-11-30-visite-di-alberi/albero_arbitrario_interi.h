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

#endif