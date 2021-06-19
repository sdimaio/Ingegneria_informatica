#include <stdlib.h>
#include <stdio.h>

#include "error.h"

void error(char* errore, int length){

  printf("%s\n",errore);
  exit(1);
}
