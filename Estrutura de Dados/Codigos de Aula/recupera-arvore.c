#include <stdio.h>
#include <stdlib.h>>

char pre[8]={'A','B','D','E','C','F','H','G'};
char sim[8]={'D','B','E','A','H','F','C','G'};

struct no {
    char rotulo;
    struct no *esq;
    struct no *dir;
};

struct no *arvore=NULL;

void recupera(char *pre, char *sim, int ip, int fp, int is, int fs, struct no **raiz){
    struct no *aux;
    int i=is;
    
    //Criação da Raiz
    aux = malloc(sizeof(struct no));
    aux->dir=NULL;
    aux->esq=NULL;
    aux->rotulo=pre[ip];
    *raiz=aux;

    //Busca da raiz na ordem simetrica
    while (i <= fs && sim[i] != aux->rotulo) 
        i++; //pos da raiz na arvore simetrica
    if (i != is) //subarvore esquerda não vazia
        recupera(pre, sim, ip+1, ip+i-is, is, i-1, &(aux->esq));
    if (i != fs) //subarvore direita não vazia 
        recupera(pre, sim, ip+i-is+1, fp, i+1, fs, &(aux->dir));
}

void print_pos(struct no *r){
    if (r != NULL){
        print_pos (r->esq);
        print_pos (r->dir);
        printf("%c ", r->rotulo);
    }
};

int main(){
    printf("pos = ");
    recupera(pre, sim, 0, 7, 0, 7, &arvore);
    print_pos(arvore);
    return 0;
}