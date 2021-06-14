#include <stdio.h>
#include <stdlib.h>

struct no{
    int chave;
    struct no *prox;
};

struct no *lista=NULL;

struct no *busca (int chave, struct no *lista, struct no **ant){
    struct no *aux=lista;
    *ant = NULL;
    
    while((aux!=NULL)&&(aux->chave!=chave)){
        *ant=aux;
        aux = aux->prox;
    }

    return aux;
}

int inserir (int chave, struct no **lista){
    struct no *aux=NULL;
    struct no *ant = NULL;

    aux = busca(chave, *lista, &ant);

    if(aux != NULL) return 0;
    else{
        aux=malloc(sizeof(struct no));
        aux->chave=chave;
        aux->prox=NULL;
        if(ant==NULL) *lista=aux;
        else ant->prox = aux;
        return 1;
    }
}

int remover (int chave, struct no **lista){
    struct no *aux=NULL;
    struct no *ant = NULL;

    aux = busca(chave, *lista, &ant);

    if(aux == NULL) return 0;
    else{
        if (ant==NULL) *lista=aux->prox;
        else ant->prox=aux->prox;
        free(aux);
        return 1;
    }
}

void print_lista (struct no *lista){
    struct no *aux=lista;
    while(aux!=NULL){
        printf("%d ",aux->chave);
        aux=aux->prox;
    }
    printf("\n");
}

int main()
{
    inserir (10,&lista);
    print_lista (lista);
    inserir (30,&lista);
    print_lista (lista);
    inserir (20,&lista);
    print_lista (lista);
    inserir (5,&lista);
    print_lista (lista);
    remover (10,&lista);
    print_lista (lista);
    remover (20,&lista);
    print_lista (lista);
    return 0;
}