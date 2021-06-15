#include <stdio.h>
#include <stdlib.h>

struct no *rem_avl (int chave, struct no **raiz, int *reduziu, int substituto);

struct no {
    int chave;
    struct no *esq;
    struct no *dir;
    int bal;
};

void caso1 (struct no **p) // p->bal = -2
{
    struct no *u = (*p)->esq;
    struct no *v = u->dir;
    
    if ((u->bal == -1) || (u->bal == 0)) // caso 1.a
    {
        if (u->bal == -1)
        {
            u->bal = 0;
            (*p)->bal = 0;
        }
        else
        {
            u->bal = 1;
            (*p)->bal = -1;
        }
       
        (*p)->esq = u->dir;
        u->dir = *p;
        *p = u;
    }
    else  // caso 1.b
    {
        if (v->bal == 1)
        {
            u->bal = -1;
            (*p)->bal = 0;
        }
        else if (v->bal == -1)
        {
            u->bal = 0;
            (*p)->bal = 1;
        }
        else
        {
            u->bal = 0;
            (*p)->bal = 0;
        }
        v->bal = 0;
        u->dir = v->esq;
        (*p)->esq = v->dir;
        v->esq = u;
        v->dir = *p;
        *p = v;
    }
}

void caso2 (struct no **p) // p->bal == 2
{
    struct no *z = (*p)->dir;
    struct no *y = z->esq;
    
    if (z->bal == 1) // Caso 2.a
    {
        if (z->bal == 1)
        {
            z->bal = 0;
            (*p)->bal = 0;
        }
        else
        {
            z->bal = -1;
            (*p)->bal = 1;
        }
        
        (*p)->dir = z->esq;
        z->esq = *p;
        *p = z;
    }
    else // Caso 2.b
    {
        if (y->bal == -1)
        {
            (*p)->bal = -1;
            z->bal = 0;
        }
        else if (y->bal == 1)
        {
            (*p)->bal = 0;
            z->bal = 1;
        }
        else
        {
            (*p)->bal = 0;
            z->bal = 0;
        }
        y->bal = 0;
        (*p)->dir = y->esq;
        z->esq = y->dir;
        y->esq = *p;
        y->dir = z;
        *p = y;
    }
}

int ins_avl (struct no **raiz, int chave)
{
    struct no *aux;
    int cresceu = 0;
    if (*raiz == NULL)
    {
        aux = malloc (sizeof(struct no));
        aux->chave = chave;
        aux->bal = 0;
        aux->esq = NULL;
        aux->dir = NULL;
        *raiz = aux;
        return 1;
    }
    else
    {
        if ((*raiz)->chave == chave)
            return 0;
        else
        {
            if (chave < (*raiz)->chave)
            {
                cresceu = ins_avl (&((*raiz)->esq),chave);
                if (cresceu == 1)
                {
                    (*raiz)->bal --;
                    if ((*raiz)->bal == -2)
                    {
                        caso1 (raiz);
                        return 0;
                    }
                    else if ((*raiz)->bal == -1)
                        return 1;
                    else
                        return 0;
                }
                else
                    return 0;
               
            }
            else if (chave > (*raiz)->chave)
            {
                cresceu = ins_avl (&((*raiz)->dir),chave);
                if (cresceu == 1)
                {
                    (*raiz)->bal++;
                    if ((*raiz)->bal == 2)
                    {
                        caso2 (raiz);
                        return 0;
                    }
                    else if ((*raiz)->bal == 1)
                        return 1;
                    else
                        return 0;
                }
                else
                    return 0;
            }
        }
    }
    return 0;
}


struct no *remove_no (struct no **r, int *reduziu)
{
    struct no *aux;
    struct no *auxs;
    if (((*r)->esq == NULL) && ((*r)->dir == NULL)) // remoção de uma folha
    {
        aux = *r;
        *r = NULL;
        *reduziu = 1;
        return aux;
    }
    else if (((*r)->esq == NULL) || ((*r)->dir == NULL)) // remoção de um nó com 1 filho
    {
        aux = *r;
        *reduziu = 1;
        if ((*r)->dir != NULL)
            *r = (*r)->dir;
        else
            *r = (*r)->esq;
        return aux;
    }
    else // remoção de um nó interno
    {
        auxs = rem_avl ((*r)->chave, &((*r)->esq), reduziu, 1);
        aux = *r;
        *r = auxs;
        (*r)->esq = aux->esq;
        (*r)->dir = aux->dir;
        (*r)->bal = aux->bal;
        if (*reduziu == 1)
        {
            (*r)->bal++;
            if ((*r)->bal == 0)
                *reduziu = 1;
            else if ((*r)->bal == 1)
                *reduziu = 0;
            if ((*r)->bal == 2)
            {
                caso2 (r);
                *reduziu = 1;
            }
        }
        return aux;
    }
}

struct no *rem_avl (int chave, struct no **raiz, int *reduziu, int substituto)
{
    struct no *no_removido=NULL;
    
    if (*raiz == NULL)
    {
        *reduziu = 0;
        return NULL;
    }
    else
    {
        if ((*raiz)->chave == chave)
        {
            no_removido = remove_no (raiz, reduziu);
            return no_removido;
        }
        else if (chave < (*raiz)->chave)
        {
            if ((*raiz)->esq != NULL)
            {
                no_removido = rem_avl (chave, &((*raiz)->esq), reduziu, substituto);
            }
            else if (substituto == 1)
            {
                no_removido = remove_no (raiz, reduziu);
                return no_removido;
            }
            if (*reduziu == 1)
            {
                (*raiz)->bal++;
                if ((*raiz)->bal == 0)
                {
                    *reduziu = 1;
                }
                else if ((*raiz)->bal == 1)
                {
                    *reduziu = 0;
                }
                else if ((*raiz)->bal == 2)
                {
                    caso2 (raiz);
                    *reduziu = 1;
                }
            }
            return no_removido;
        }
        else if (chave > (*raiz)->chave)
        {
            if ((*raiz)->dir != NULL)
            {
                no_removido = rem_avl (chave,&((*raiz)->dir), reduziu, substituto);
            }
            else if (substituto == 1)
            {
                no_removido = remove_no (raiz, reduziu);
                return no_removido;
            }
            if (*reduziu == 1)
            {
                (*raiz)->bal--;
                if ((*raiz)->bal == -2)
                {
                    caso1(raiz);
                    *reduziu = 1;
                }
                else if ((*raiz)->bal == -1)
                {
                    *reduziu = 0;
                }
                else if ((*raiz)->bal == 0)
                {
                    *reduziu = 1;
                }
            }
            return no_removido;
        }
    }
    return no_removido;
}


void print_pre (struct no *raiz)
{
    if (raiz != NULL)
    {
        printf ("(%d,%d), ",raiz->chave,raiz->bal);
        print_pre (raiz->esq);
        print_pre (raiz->dir);
    }
}



int main(int argc, const char * argv[]) {
    struct no *raiz = NULL;
    
    ins_avl (&raiz,100);
    ins_avl (&raiz,50);
    ins_avl (&raiz,150);
    ins_avl (&raiz,20);
    ins_avl (&raiz,70);
    ins_avl (&raiz,10);
    ins_avl (&raiz,40);
    ins_avl (&raiz,30);
    ins_avl (&raiz,45);
    ins_avl (&raiz,5);
    ins_avl (&raiz,25);
    print_pre (raiz);
    printf ("\n");
    
    struct no *aux;
    int red=0;
    
    aux = rem_avl (150,&raiz,&red,0);
    print_pre (raiz);
    printf ("\n");

    aux = rem_avl (100,&raiz,&red,0);
    print_pre (raiz);
    printf ("\n");

    aux = rem_avl (40,&raiz,&red,0);
    print_pre (raiz);
    printf ("\n");

    aux = rem_avl (25,&raiz,&red,0);
    print_pre (raiz);
    printf ("\n");
    
}