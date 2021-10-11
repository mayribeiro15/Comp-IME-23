#include <stdio.h>
#include <stdlib.h>


struct registro {
    struct registro *ant;
    struct registro *prox;
    int chave;
};

struct registro *hash[100];

void inserir (int chave, struct registro **hash) {
    int aux;
    struct registro *noaux;
    aux = chave % 100;
    if (hash[aux] == NULL){ //ngm na chave
        noaux = malloc (sizeof(struct registro));
        noaux->chave = chave;
        noaux->ant = NULL;
        noaux->prox = NULL;
        hash[aux] = noaux;
    } else { //novo no na 1a posicao
        noaux = malloc (sizeof (struct registro));
        noaux->chave = chave;
        noaux->prox = hash[aux];
        hash[aux]->ant = noaux;
        noaux->ant = NULL;
        hash[aux] = noaux;
    }
}

int remover (int chave, struct registro **hash)
{
    int aux;
    
    struct registro *noaux;
    
    aux = chave % 100;
    
    if (hash [aux]!= NULL)
    {
        noaux = hash[aux];
        
        while (noaux != NULL && noaux->chave != chave)
            noaux = noaux->prox;
        
        if (noaux != NULL)
        {
            if (noaux->ant == NULL)
            {
                hash[aux] = noaux->prox;
                if (noaux->prox != NULL)
                {
                    (noaux->prox)->ant = NULL;
                }
                free (noaux);
            }
            else
            {
                (noaux->ant)->prox = noaux->prox;
                if (noaux->prox != NULL)
                {
                    (noaux->prox)->ant = noaux ->ant;
                }
                free (noaux);
            }
        }
        return chave;
    }
    return 0;
}

int busca (int chave)
{
    int aux;
    
    struct registro *noaux;
    
    aux = chave % 100;
    
    if (hash[aux] != NULL)
    {
        noaux = hash [aux];
        
        while (noaux != NULL && noaux->chave != chave)
            noaux = noaux->prox;
        
        if (noaux != NULL)
            return noaux->chave;
        else
            return 0;
    }
    else
        return 0;
}





int main(int argc, const char * argv[]) {
  
    int i;
    
    for (i=0; i<100; i++)
    {
        hash[i]=NULL;
    }
    
    inserir (52,hash);
    inserir (64,hash);
    inserir (152,hash);
    remover (152,hash);
    remover (52,hash);
    
    printf ("%d \n", busca(64));
    
    printf ("%d \n", busca (22));
    
    printf ("%d \n",busca (52));
    
    
    
    return 0;
}