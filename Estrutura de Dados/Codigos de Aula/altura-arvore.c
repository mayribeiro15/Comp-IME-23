#include <stdio.h>
#include <stdlib.h>

struct no{
    int rotulo;
    struct no *dir;
    struct no *esq;
};

int altura(struct no *r){
    int hdir, hesq;
    if(r==NULL)
        return 0;
    else{
        hdir=1+altura(r->dir);
        hesq=1+altura(r->esq);
        if(hdir>hesq) return hdir;
        else return hesq;
    }   
}

struct no* novo(int rotulo)
{
    struct no* no = malloc(sizeof(struct no));
    no->rotulo = rotulo;
    no->esq = NULL;
    no->dir = NULL;

    return (no);
}

int main()
{
    int h;
    struct no* arvore = novo(1);
    arvore->esq = novo(2);
    arvore->dir = novo(3);
    arvore->esq->esq = novo(4);
    h = altura(arvore);
    printf("%d",h);
    return 0;
}