#include <stdio.h>
#include <stdlib.h>

//ARVORE BIN BUSCA
// int pre[9]={40,20,10,30,80,60,50,70,90};
// int sim[9]={10,20,30,40,50,60,70,80,90};

// struct no {
//     int rotulo;
//     struct no *esq;
//     struct no *dir;
// };

// struct no *arvore=NULL;

// void recupera(int *pre, int *sim, int ip, int fp, int is, int fs, struct no **raiz){
//     struct no *aux;
//     aux = malloc(sizeof(struct no));
//     aux->dir=NULL;
//     aux->esq=NULL;
//     aux->rotulo=pre[ip];
//     *raiz=aux;

//     //Busca da raiz na ordem simetrica
//     int i=is;
//     while (i <= fs && sim[i] != aux->rotulo) 
//         i++; //pos da raiz na arvore simetrica
//     if (i != is) //subarvore esquerda não vazia
//         recupera(pre, sim, ip+1, ip+(i-is), is, i-1, &(aux->esq));
//     if (i != fs) //subarvore direita não vazia 
//         recupera(pre, sim, ip+(i-is)+1, fp, i+1, fs, &(aux->dir));
// }

// struct no *busca(int chave, struct no *r, struct no **pai){
//     if(r==NULL) return r;
//     if(r->rotulo == chave) return r;
//     else if(chave > r->rotulo){
//         if (r->dir != NULL){
//             *pai = r;
//             return busca(chave, r->dir, pai);
//         } else return r;
//     }
//     else if(chave < r->rotulo){
//         if (r->esq != NULL){
//             *pai = r;
//             return busca(chave, r->esq, pai);
//         } else return r;
//     }
// }

// int insercao(int chave, struct no **r){
//     struct no *aux, *pai=NULL, *newno;
//     aux = busca(chave, arvore, &pai);
//     if(aux==NULL){ //arvore vazia
//         newno = malloc(sizeof(struct no));
//         newno->rotulo=chave;
//         newno->dir = NULL;
//         newno->esq = NULL;
//         *r = newno;
//         return 1;
//     }
//     if(aux->rotulo == chave) return 0;
//     else{
//         newno = malloc(sizeof(struct no));
//         newno->rotulo=chave;
//         newno->dir = NULL;
//         newno->esq = NULL;
//         if(chave < aux->rotulo) aux->esq=newno;
//         else aux->dir=newno;
//         return 1;
//     }
// }

//ROTACAO AVL

struct no_avl{
    int chave;
    int bal;
    struct no_avl *esq;
    struct no_avl *dir;
};

void caso1 (struct no_avl **p){ //p=-2
    struct no_avl *u=(*p)->esq;   
    if(u->bal==-1 || u->bal==0){ 
        if(u->bal==-1){
            u->bal=0;
            (*p)->bal=0;
        } else {
            u->bal=1;
            (*p)->bal=-1;
        }
        (*p)->esq=u->dir;
        u->dir=p;
        *p=u;
    } else {
        struct no_avl *v=u->dir;
        if(v->bal==1){
            v->bal=0;
            u->bal=-1;
            (*p)->bal=0;
        } else if(v->bal==-1) {
            v->bal=0;
            u->bal=0;
            (*p)->bal=1;
        } else {
            v->bal=0;
            u->bal=0;
            (*p)->bal=0;
        }
        (*p)->esq=v->dir;
        u->dir=v->esq;
        v->dir=*p;
        v->esq=u;
        *p=v;
    }
}
