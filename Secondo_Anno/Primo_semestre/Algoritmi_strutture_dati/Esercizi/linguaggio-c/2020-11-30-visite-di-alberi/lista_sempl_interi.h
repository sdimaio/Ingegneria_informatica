#ifndef _LISTA_SEMPL_INTERI_H
#define _LISTA_SEMPL_INTERI_H

typedef struct slitem {

	int info;
	struct slitem* next;

} slitem;

typedef slitem* lista_sempl_interi;

/*
    
                        ______
                   &l   |  o | (slitem**)
					    ---|--
                           |
    	                ___V__
lista_sempl_interi l;   |  o | (slitem*)
					    ---|--
                           |
    	                ___V__
			slitem      |    | info (int)
			            ------
		    	        |    | next (slitem*)
	            	    ------
*/



void insert_lista_sempl_interi(lista_sempl_interi* pl, int val);

int delete_first_lista_sempl_interi(lista_sempl_interi* pl);

slitem* search_lista_sempl_interi(lista_sempl_interi l, int val);

void delete_lista_sempl_interi(lista_sempl_interi* pl, slitem* pi);

void print_lista_sempl_interi(lista_sempl_interi l);



#endif