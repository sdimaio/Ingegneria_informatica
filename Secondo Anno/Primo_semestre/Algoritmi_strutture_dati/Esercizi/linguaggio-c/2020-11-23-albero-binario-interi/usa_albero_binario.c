#include <stdlib.h>
#include <stdio.h>
#include "albero_binario_interi.h"


int main() {


	albero a = NULL;

	aggiungi_radice(&a, 1);
	nodo* left = aggiungi_figlio_sinistro(a,2);
	nodo* left_right = aggiungi_figlio_destro(left,3);

}