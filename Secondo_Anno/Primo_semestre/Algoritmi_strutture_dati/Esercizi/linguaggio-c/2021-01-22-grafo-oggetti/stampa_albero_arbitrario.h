#ifndef _STAMPA_ALBERO_ARBITRARIO_H
#define _STAMPA_ALBERO_ARBITRARIO_H

#include "albero_arbitrario_interi.h"

void indenta_ascii(int* prefix, int prof);
void stampa_albero_arbitrario_ricorsiva(nodo* n, int* prefix, int prof);
void stampa_albero_arbitrario(nodo* root);

#endif