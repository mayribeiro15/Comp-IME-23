#include <stdio.h>
#include <stdlib.h>
#define TAM_LISTA 10

int lista[TAM_LISTA]={1,2,3,4,5,6,7,8,9,10};
tam = 10;

//inserção e remoção tipo as outras, deslocando na remoção

int busca (int chave){
    int i=0;
    while((i<TAM_LISTA)&&(lista[i]!=chave)) i++;
    return i;
}

int main(){
    int x;
    x=busca(4);
    printf("%d",x);
    return 0;
}