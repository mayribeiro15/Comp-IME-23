#include <stdio.h>
#include <stdlib.h>

int pre[9]={40,20,10,30,80,60,50,70,90};
int sim[9]={10,20,30,40,50,60,70,80,90};

struct no {
    int rotulo;
    struct no *esq;
    struct no *dir;
};

struct no *arvore=NULL;

void recupera(int *pre, int *sim, int ip, int fp, int is, int fs, struct no **raiz){
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

void print_pre(struct no *r){
    if (r != NULL){
        printf("%d ", r->rotulo);
        print_pre (r->esq);
        print_pre (r->dir);
    }
};

void print_pos(struct no *r){
    if (r != NULL){
        print_pos (r->esq);
        print_pos (r->dir);
        printf("%d ", r->rotulo);
    }
};

void print_sim(struct no *r){
    if (r != NULL){
        print_sim (r->esq);
        printf("%d ", r->rotulo);
        print_sim (r->dir);
    }
};

struct no *busca(int chave, struct no *r, struct no **pai){
    if(r==NULL) return r;
    if(r->rotulo == chave) return r;
    else if(chave > r->rotulo){
        if (r->dir != NULL){
            *pai = r;
            return busca(chave, r->dir, pai);
        } else return r;
    }
    else if(chave < r->rotulo){
        if (r->esq != NULL){
            *pai = r;
            return busca(chave, r->esq, pai);
        } else return r;
    }
}

int insercao(int chave, struct no **r){
    struct no *aux, *pai=NULL, *newno;
    aux = busca(chave, arvore, &pai);
    if(aux==NULL){ //arvore vazia
        newno = malloc(sizeof(struct no));
        newno->rotulo=chave;
        newno->dir = NULL;
        newno->esq = NULL;
        *r = newno;
        return 1;
    }
    if(aux->rotulo == chave) return 0;
    else{
        newno = malloc(sizeof(struct no));
        newno->rotulo=chave;
        newno->dir = NULL;
        newno->esq = NULL;
        if(chave < aux->rotulo) aux->esq=newno;
        else aux->dir=newno;
        return 1;
    }
}

struct no *remocao(int chave, struct no**r, int subt){
    struct no *aux=NULL, *pai=NULL;
    aux = busca(chave, *r, &pai);
    if(aux==NULL) //arvore vazia
        return NULL;
    if(aux->rotulo == chave || subt==1){
        if(aux->dir==NULL && aux->esq==NULL){ //folha
            if(pai==NULL){
                *r=NULL;
                return aux;
            }
            else{
                if(chave < pai ->rotulo){
                    pai->esq=NULL;
                    return aux;
                }
                else{
                    pai->dir=NULL;
                    return aux;
                }
            }
        }
        else if(aux->dir==NULL || aux->esq==NULL){ //só tem 1 subarvore
            if(pai==NULL){
                if(aux->dir!=NULL) *r=aux->dir;
                else *r=aux->esq;
                return aux;
            }
            else{
                if(pai->dir==aux){
                    if(aux->dir!=NULL) pai->dir=aux->dir;
                    else pai->dir=aux->esq;
                    return aux;
                }
                else{
                    if(aux->dir!=NULL) pai->esq=aux->dir;
                    else pai->esq=aux->esq;
                }
                return aux;
            }
        }
        else{ //tem ambas subarvores
            struct no *auxsub;
            auxsub = remocao(chave,&(aux->esq),1);
            if(pai==NULL){
                *r=auxsub;
                auxsub->dir= aux->dir;
                auxsub->esq= aux->esq;
                return aux;
            }
            else{
                if(pai->dir==aux){
                    pai->dir=auxsub;
                    auxsub->dir= aux->dir;
                    auxsub->esq= aux->esq;
                    return aux;
                }
                else{
                    pai->esq=auxsub;
                    auxsub->dir= aux->dir;
                    auxsub->esq= aux->esq;
                    return aux;
                }
            }
        }
    } else return NULL; //a arvore nao tem chave
}

int main(){
    recupera(pre, sim, 0, 8, 0, 8, &arvore);
    printf("\n pos = ");
    print_pos(arvore);
    printf("\n sim = ");
    print_sim(arvore);

    printf("\nTESTE BUSCA:");
    struct no *aux, *pai=NULL;
    aux = busca(50, arvore, &pai);
    printf("\n busca = %d", aux->rotulo);
    printf("\n pai = %d", pai->rotulo);
    aux = busca(75, arvore, &pai);
    printf("\n busca = %d", aux->rotulo);
    printf("\n pai = %d", pai->rotulo);
    
    printf("\nTESTE INSERCAO:");
    int inserir;
    inserir = insercao(55,&arvore);
    printf("\n sim = ");
    print_sim(arvore);
    printf("\n pre = ");
    print_pre(arvore);

    printf("\nTESTE REMOCAO:");
    aux = remocao(30, &arvore, 0);
    printf("\n pre = ");
    print_pre(arvore);
    aux = remocao(20, &arvore, 0);
    printf("\n pre = ");
    print_pre(arvore);
    aux = remocao(80, &arvore, 0);
    printf("\n pre = ");
    print_pre(arvore);

    return 0;
}