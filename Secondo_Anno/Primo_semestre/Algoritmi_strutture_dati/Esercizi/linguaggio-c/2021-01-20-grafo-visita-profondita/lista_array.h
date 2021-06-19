#ifndef _LISTA_ARRAY_H
#define _LISTA_ARRAY_H

typedef struct la {

	int  maxsize;
	int  head;
	int  free;
	int* info;
	int* next;
	int* prev; 

} lista_array;

int allocate_column(lista_array* l);

void free_column(lista_array* l, int c);

lista_array* create_lista_array(int maxsize);

void insert_lista_array(lista_array* l, int x);

void delete_lista_array(lista_array* l, int i); 

void print_lista_array(lista_array* l);

#endif