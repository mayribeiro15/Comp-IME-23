#include <stdio.h>
#include <stdlib.h>

struct no {
    int chave;
    struct no *esq;
    struct no *dir;
    int bal;
};

void caso1(struct no **p){ //regulagem esquerda p->bal==-2 
    struct no *u = (*p)->esq;
    struct no *v = u->dir;

    if(u->bal==-1 || u->bal==0){ //1a rotacao direita
        if(u->bal==-1){
            u->bal=0;
            (*p)->bal=0;
        }else{
            u->bal=1;
            (*p)->bal=-1;
        }
        (*p)->esq=u->dir;
        u->dir=*p;
        *p=u;
    } 
    else{ //1b rotacao dupla direita
        if(v->bal==1){
            u->bal=-1;
            (*p)->bal=0;
        }else if(v->bal==-1){
            u->bal=0;
            (*p)->bal=1;
        }else{
            u->bal=0;
            (*p)->bal=0;
        }
        v->bal=0;

        u->dir=v->esq;
        (*p)->esq=v->dir;
        v->esq=u;
        v->dir=*p;
        *p=v;
    }
}

void caso2(struct no **p){ //regulagem direita p->bal=2
    struct no *z = (*p)->dir;
    struct no *y = z->esq;

    if(z->bal==1){ //2a rotacao esquerda
        if (z->bal==1){
            z->bal=0;
            (*p)->bal=0;
        }else{
            z->bal=-1;
            (*p)->bal=1;
        }

        (*p)->dir=z->esq;
        z->esq=*p;
        *p=z;
    } 
    else{ //2b rotacao dupla esquerda
        if(y->bal==-1){
            z->bal=0;
            (*p)->bal=-1;
        }else if (y->bal == 1){
            z->bal=1;
            (*p)->bal=0;
        }else{
            z->bal=1;
            (*p)->bal=0;
        }
        y->bal=0;

        z->esq=y->dir;
        (*p)->dir=y->esq;
        y->dir=z;
        y->esq=*p;
        *p=y;
    }
}

int inserir_avl(struct no **r, int chave){
    struct no *aux;
    int cresceu = 0;
    if(*r==NULL){
        aux=malloc(sizeof(struct no));
        aux->chave=chave;
        aux->bal=0;
        aux->dir=NULL;
        aux->esq=NULL;
        *r=aux;
        return 1; //arvore cresceu
    } else {
        if((*r)->chave == chave) return 0;
        else if(chave < (*r)->chave){
            cresceu=inserir_avl(&((*r)->esq),chave);
            if(cresceu) (*r)->bal--;
            if((*r)->bal==-2){
                caso1(r);
                return 0;
            }else if((*r)->bal==-1) return 1;
            else return 0;
        } else {
            cresceu=inserir_avl(&((*r)->dir),chave);
            if(cresceu) (*r)->bal++;
            if((*r)->bal==2){
                caso2(r);
                return 0;
            }else if((*r)->bal==1) return 1;
            else return 0;
        }
    }
}

void print_pre(struct no *r){
    if(r!=NULL){
        printf("(%3d,%2d), ",r->chave,r->bal);
        print_pre(r->esq);
        print_pre(r->dir);
    }
}


int main(){
    struct no *raiz = NULL;
    inserir_avl(&raiz,100);
    print_pre(raiz);
    printf("\n");
    inserir_avl(&raiz,50);
    print_pre(raiz);
    printf("\n");
    inserir_avl(&raiz,150);
    print_pre(raiz);
    printf("\n");
    inserir_avl(&raiz,20);
    print_pre(raiz);
    printf("\n");
    inserir_avl(&raiz,70);
    print_pre(raiz);
    printf("\n");
    inserir_avl(&raiz,10);
    print_pre(raiz);
    printf("\n");
    return 0;
}