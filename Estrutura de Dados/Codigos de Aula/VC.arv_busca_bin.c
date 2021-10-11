/*
LETRA A: para as árvores binárias de busca, sabemos que o percurso em ordem
simétrica é dado pelos nós em ordem crescente. Como a pré-ordem está dada, 
podemos utilizar o algoritmo de recuperação para ávores binárias de modo geral, 
pois temos os 2 percursos.

LETRA B: o algoritmo é dado pelo código abaixo:
*/

#include <stdio.h>
#include <stdlib.h>

struct no{
    int rotulo;
    struct no *dir;
    struct no *esq;
};

struct no *arvore;

int pre[6]={20,10,15,12,16,30};
int sim[6]={10,12,15,16,20,30};

void recupera(int *pre, int *sim, int ip, int fp, int is, int fs, struct no **r){
    
    struct no *aux;
    aux=malloc(sizeof(struct no));
    aux->dir=NULL;
    aux->esq=NULL;
    aux->rotulo=pre[ip];
    *r=aux;

    int i=is;
    while(i!=fs && aux->rotulo!=sim[i]) i++; //pos em sim
    if(i!=is) //tem nos a esquerda
        recupera(pre, sim, ip+1, ip+i-is, is, i-1, &(aux->esq));
    if(i!=fs) //tem nos a esquerda
        recupera(pre, sim, ip+i-is+1, fp, i+1, fs, &(aux->dir));

}

void printpos(struct no *r){
    if (r != NULL){
        printpos (r->esq);
        printpos (r->dir);
        printf("%d ", r->rotulo);
    }
};

int main(){
    recupera(pre, sim, 0, 5, 0, 5, &arvore);
    printpos(arvore);
    return 0;
}