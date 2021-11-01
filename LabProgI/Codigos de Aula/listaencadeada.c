#include <stdio.h>
#include <stdlib.h>

struct lista{
    int info;
    struct lista* prox;
};
typedef struct lista Lista;

Lista* insere(Lista* l, int i){
    Lista* nova = (Lista*) malloc(sizeof(Lista));
    nova->info=i;
    nova->prox=l;
    return nova;
}
Lista* retira(Lista* l, int i){
    Lista* ant;
    Lista* p=l;
    while(p!=NULL&&p->info!=i){
        ant=p;
        p=p->prox;
    }
    if(p==NULL)
        return l;
    if(ant==NULL){
        l=p->prox;
        return l;
    } else {
        ant->prox=p->prox;
    }
    free(p);
    return l;
}
void imprime(Lista* l){
    Lista* p;
    for(p=l;p!=NULL;p=p->prox)
        printf("%d ",p->info);
    printf("\n");
}
int busca(Lista* l, int i){
    Lista* p;
    for(p=l;p!=NULL;p=p->prox){
        if((p->info)==i)
            return 1;
    }
    return 0;
}

int main(){
    Lista* l=NULL;
    l = insere(l,5);
    l = insere(l,4);
    l = insere(l,3);
    l = insere(l,2);
    l = insere(l,1);
    imprime(l);
    l = retira(l,4);
    imprime(l);
    int i = busca(l,3);
    printf("%d",i);
    return 0;
}