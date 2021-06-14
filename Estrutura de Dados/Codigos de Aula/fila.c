#include <stdio.h>
#include <stdlib.h>
#define TAM_FILA 4

int fila[TAM_FILA];
int i=-1;
int f=-1; //a pilha está vazia

int push(int x){
    if(i==-1){ //fila vazia
        i=0;
        f=0;
        fila[f]=x;
        return 1;
    } 
    else{
        if((f+1)%TAM_FILA==i) return 0; //fila cheia
        else{
            f=(f+1)%TAM_FILA;
            fila[f]=x;
            return 1;
        }
    }
}

int pop(){
    if(i==-1) return 0; //pilha vazia
    else{
        if(i==f){
            i=-1;
            f=-1;
            return 1;
        }
        else{
            i=(i+1)%TAM_FILA;
            return 1;
        }
    }
}

int main(){
    int x;
    push(10);
    push(20);
    push(30);
    push(40);
    x=i;
    while(x!=f){
        printf("%d ", fila[x]); 
        x=(x+1)%TAM_FILA;
    };
    printf("%d ", fila[f]); 
    
    
    pop();
    push(50);
    printf("\n");
    x=i;
    while(x!=f){
        printf("%d ", fila[x]); 
        x=(x+1)%TAM_FILA;
    };
    printf("%d ", fila[f]); 

    return 0;
}