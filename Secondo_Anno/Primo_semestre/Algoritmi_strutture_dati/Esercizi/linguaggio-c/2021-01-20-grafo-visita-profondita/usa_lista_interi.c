#include <stdlib.h>
#include <stdio.h>
#include "lista_interi.h"

int main() {

	lista_interi l = NULL;  // equivale a "litem* l = NULL;"
	                        // equivale a "struct litem* l = NULL;"
	int i;

	// INSERIMENTI E RIMOZIONI

    /*
	for ( i = 1; i < 20; i++) {

		if ( i%3 == 0 ) {
			printf("rimosso dalla lista %d\n", delete_first_lista_interi(&l));
			print_lista_interi(l);
		} else {
			printf("inserisco %d nella lista\n", i);
			insert_lista_interi(&l, i);
			print_lista_interi(l);
		}
	}
	*/

    /*
	for ( i = 1; i < 20; i++) {

		if ( i%3 == 0 ) {
			printf("rimosso dalla lista %d\n", delete_first_lista_interi(&l));
			print_lista_interi(l);
		} else {
			int inseriscimi;
			if( i%2 == 0 ) inseriscimi = i;
			else inseriscimi = i/2;
			printf("inserisco %d nella lista\n", inseriscimi);
			insert_lista_interi_ordinata(&l, inseriscimi);
			print_lista_interi(l);
		}
	}
	*/

	lista_interi l1 = NULL;
	lista_interi l2 = NULL;

	for ( i = 1; i < 80; i++) {

		if ( i%3 == 0 ) {
			insert_lista_interi_ordinata(&l1,i);
		} else {
			insert_lista_interi_ordinata(&l2,i);
		}
	}

	print_lista_interi(l1);
	print_lista_interi(l2);

    lista_interi l3 = merge_di_liste_interi_ordinate(l1,l2);

    print_lista_interi(l3);




    /*

	// RICERCHE

	int j = 20;
	litem* output = search_lista_interi(l,j);
	if (output != NULL)
	 	printf("trovato l'elemento %d\n",j);
	else
		printf("elemento %d non trovato\n",j);

	j = 17;
	output = search_lista_interi(l,j);
	if (output != NULL)
	 	printf("trovato l'elemento %d\n",j);
	else
		printf("elemento %d non trovato\n",j);

	// RICERCHE E CANCELLAZIONI

	j = 10;
	output = search_lista_interi(l,j);
	if (output != NULL) {
	 	printf("trovato l'elemento %d\n",j);
	 	printf("cancello l'elemento trovato\n");
	 	delete_lista_interi(&l, output);
	 	print_lista_interi(l);
	} else
		printf("elemento %d non trovato\n",j);


	j = 1;
	output = search_lista_interi(l,j);
	if (output != NULL) {
	 	printf("trovato l'elemento %d\n",j);
	 	printf("cancello l'elemento trovato\n");
	 	delete_lista_interi(&l, output);
	 	print_lista_interi(l);
	} else
		printf("elemento %d non trovato\n",j);

	*/
}





















