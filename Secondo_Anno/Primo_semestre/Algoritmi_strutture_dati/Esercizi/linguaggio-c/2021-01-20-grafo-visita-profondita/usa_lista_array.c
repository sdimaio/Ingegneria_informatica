#include <stdlib.h>
#include <stdio.h>
#include "lista_array.h"


int main() {

	lista_array* l = create_lista_array(8);
	print_lista_array(l);

	int i; 
	for( i = 1; i < 20; i++) {

		if( i%3 == 0) {  // una volta ogni tre
			printf("cancello il primo elemento\n");
			delete_lista_array(l,l->head);
		} else {

			printf("inserisco l'elemento %d\n",i);
			insert_lista_array(l,i);
		}
		print_lista_array(l);
	}


}