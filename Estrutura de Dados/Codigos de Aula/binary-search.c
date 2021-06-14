#include <stdio.h>
#include <stdlib.h>
#define TAM_LISTA 10

int lista[TAM_LISTA]={1,2,3,4,5,6,7,8,9,10};

int pesq_bin(int chave, int i, int f){
    int meio;
    if(i==f){
        if(lista[i]==chave) return i;
        else return -1;
    } else {
        meio = (i+f)/2;
        if(lista[meio]==chave) return meio;
        if(chave<lista[meio]) pesq_bin(chave, i, meio-1);
        if(chave<lista[meio]) pesq_bin(chave, meio+1, f);
    }
}

int main(){
    int x;
    x=pesq_bin(2,0,TAM_LISTA-1);
    printf("%d",x);
    return 0;
}