#include <stdlib.h>
#include <stdio.h>
#include "lista_sempl_interi.h"

int main() {

	lista_sempl_interi l = NULL;  // equivale a "slitem* l = NULL;"
	                              // equivale a "struct slitem* l = NULL;"
	int i;
	for ( i = 1; i < 20; i++) {

		if ( i%3 == 0 ) {
			printf("rimosso dalla lista %d\n", delete_first_lista_sempl_interi(&l));
			print_lista_sempl_interi(l);
		} else {
			printf("inserisco %d nella lista\n", i);
			insert_lista_sempl_interi(&l, i);
			print_lista_sempl_interi(l);
		}
	}

	int j = 20;
	slitem* output = search_lista_sempl_interi(l,j);
	if (output != NULL)
	 	printf("trovato l'elemento %d\n",j);
	else
		printf("elemento %d non trovato\n",j);

	j = 17;
	output = search_lista_sempl_interi(l,j);
	if (output != NULL)
	 	printf("trovato l'elemento %d\n",j);
	else
		printf("elemento %d non trovato\n",j);

	j = 10;
	output = search_lista_sempl_interi(l,j);
	if (output != NULL) {
	 	printf("trovato l'elemento %d\n",j);
	 	printf("cancello l'elemento trovato\n");
	 	delete_lista_sempl_interi(&l, output);
	 	print_lista_sempl_interi(l);
	} else
		printf("elemento %d non trovato\n",j);


	j = 1;
	output = search_lista_sempl_interi(l,j);
	if (output != NULL) {
	 	printf("trovato l'elemento %d\n",j);
	 	printf("cancello l'elemento trovato\n");
	 	delete_lista_sempl_interi(&l, output);
	 	print_lista_sempl_interi(l);
	} else
		printf("elemento %d non trovato\n",j);


}