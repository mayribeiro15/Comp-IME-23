#include <stdio.h>
#include <stdlib.h>

struct no {
    int chave;
    struct no *esq;
    struct no *dir;
    int bal;
};

struct no* remover_avl(int chave, struct no **r, int *reduziu, int subst);

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
            (*p)->bal=-1;
            z->bal=0;
        }else if (y->bal == 1){
            (*p)->bal=0;
            z->bal=1;
        }else{
            (*p)->bal=0;
            z->bal=0;
        }
        y->bal=0;

        (*p)->dir=y->esq;
        z->esq=y->dir;
        y->esq=*p;
        y->dir=z;
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
        if((*r)->chave == chave) 
            return 0;
        else if(chave < (*r)->chave){
            cresceu=inserir_avl(&((*r)->esq),chave);
            if(cresceu==1){
                (*r)->bal--;
                if((*r)->bal==-2){
                    caso1(r);
                    return 0;
                }
                else if((*r)->bal==-1) return 1;
                else return 0;
            }
            else return 0;
        } else {
            cresceu=inserir_avl(&((*r)->dir),chave);
            if(cresceu==1){
                (*r)->bal++;
                if((*r)->bal==2){
                    caso2(r);
                    return 0;
                }else if((*r)->bal==1) return 1;
                else return 0;
            }
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

struct no* remover_no(struct no **r, int *reduziu){
    struct no *aux = NULL;
    struct no *auxsub = NULL;
    if((*r)->dir==NULL && (*r)->esq==NULL){ //folha
        aux = *r;
        *r=NULL;
        *reduziu = 1;
        return aux;
    }
    else if((*r)->dir==NULL || (*r)->esq==NULL){ //1 filho
        aux = *r;
        if((*r)->dir!=NULL)  *r=(*r)->dir;
        else *r=(*r)->esq;
        *reduziu = 1;
        return aux;
    }
    else{ //2 filhos
        auxsub = remover_avl((*r)->chave, &((*r)->esq), reduziu, 1);
        aux = *r;
        *r = auxsub;
        (*r)->dir = aux->dir;
        (*r)->esq = aux->esq;
        (*r)->bal = aux->bal;
        if(*reduziu == 1){
            (*r)->bal++;
            if((*r)->bal==0) 
                *reduziu = 1;
            else if((*r)->bal==1) 
                *reduziu = 0;
            else{ //(*r)->bal==2
                caso2(r);
                *reduziu = 1;
            }
        }
        return aux;
    }
}

struct no* remover_avl(int chave, struct no **r, int *reduziu, int subst){
    struct no *aux = NULL;
    if(*r==NULL){
        *reduziu=0;
        return NULL;
    }
    if((*r)->chave==chave){
        aux = remover_no(r, reduziu);
        return aux;
    }
    else if(chave < (*r)->chave){
        if((*r)->esq!=NULL) 
            aux=remover_avl(chave, &((*r)->esq), reduziu, subst);
        else if(subst==1){
            aux=remover_no(r, reduziu);
            return aux;
        }
        if(*reduziu == 1){
            (*r)->bal++;
            if((*r)->bal==0) 
                *reduziu = 1;
            else if((*r)->bal==1) 
                *reduziu = 0;
            else{ //(*r)->bal==2
                caso2(r);
                *reduziu = 1;
            }
        }
        return aux;
    }
    else if(chave > (*r)->chave){
        if((*r)->dir!=NULL) 
            aux = remover_avl(chave, &((*r)->dir), reduziu, subst);
        else if(subst==1){
            aux = remover_no(r, reduziu);
            return aux;
        }
        else return NULL;
        if(*reduziu == 1){
            (*r)->bal--;
            if((*r)->bal==-2){
                caso1(r);
                *reduziu = 1;
            } 
            else if((*r)->bal==-1) *reduziu = 0;
            else *reduziu = 1; //(*r)->bal==0
        }
        return aux;
    }
}

int main(){
    struct no *raiz = NULL;
    int red;
    inserir_avl(&raiz,100);
    inserir_avl(&raiz,50);
    inserir_avl(&raiz,150);
    inserir_avl(&raiz,20);
    inserir_avl(&raiz,70);
    inserir_avl(&raiz,10);
    inserir_avl(&raiz,40);
    inserir_avl(&raiz,30);
    inserir_avl(&raiz,45);
    inserir_avl(&raiz,5);
    inserir_avl(&raiz,25);
    print_pre(raiz);
    printf("\n");

    remover_avl(150,&raiz,&red,0);
    print_pre(raiz);
    printf("\n");

    remover_avl(100,&raiz,&red,0);
    print_pre(raiz);
    printf("\n");

    remover_avl(40,&raiz,&red,0);
    print_pre(raiz);
    printf("\n");

    return 0;
}