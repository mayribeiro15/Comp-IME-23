#include <stdio.h>
#include <stdlib.h>>
#define TAM_PILHA 10

int pilha[TAM_PILHA];
int topo = -1; //a pilha está vazia

int push(int x){
    if(topo==TAM_PILHA-1) return 0; //pilha cheia
    else{
        topo++;
        pilha[topo]=x;
        return 1;
    }
}

int pop(){
    if(topo==-1) return 0; //pilha vazia
    else{
        topo--;
        return 1;
    }
}

int main(){
    int i;
    push(10);
    push(20);
    push(30);
    pop();
    for(i=0; i<=topo; i++) printf("%d ", pilha[i]);
    return 0;
}