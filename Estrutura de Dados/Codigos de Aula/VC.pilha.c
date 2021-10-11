/*Para que o vetor compartilhe 2 pilhas, a operação push deve inserir o elemento da pilha no vetor e
a operação pop deve tirar do vetor o último elemento adicionado nessa pilha. Para que ocorra de forma 
otimizada, uma pilha preencherá o vetor pelo inicio e a outra pelo fim de forma que o tamanho somado 
das 2 pilhas seja M. Será armazenada a variável topo, com o último elemento inserido em cada pilha.

O armazenamento das 2 pilhas pode ser visto consecutivamente no print "Vetor Preenchido" e os campos 
sem armazenamento são preenchidos de 0's, como visto no print "Vetor Completo".*/ 


#include <stdio.h>
#include <stdlib.h>
#define T 10

int M[T]; //posições de 0 a T-1
int topo2=T;
int topo1=-1;


int push1(int chave){
    if(topo1==T-1 || topo1==topo2-1) return 0; //vetor cheio;
    topo1++;
    M[topo1]=chave;
    return 1;
}

int pop1(){
    if(topo1==-1) return 0;
    M[topo1]=0;
    topo1--;
    return 1;
}

int push2(int chave){
    if(topo2==-1 || topo1==topo2-1) return 0; //vetor cheio;
    topo2--;
    M[topo2]=chave;
    return 1;
}

int pop2(){
    if(topo2==T) return 0;
    M[topo2]=0;
    topo2++;
    return 1;
}

void printavetorpreench(){
    int i;
    printf("Vetor Preenchido: ");
    for(i=0;i<=topo1;i++) printf("%d ",M[i]);
    for(i=T-1;i>=topo2;i--) printf("%d ",M[i]);
    printf("\n");
}

void printavetorcomp(){
    int i;
    printf("Vetor Completo: ");
    for(i=0;i<T;i++) printf("%d ",M[i]);
    printf("\n");
}

int main(){
    push1(10);
    push1(20);
    pop1();
    push1(30);
    push2(1);
    push2(2);
    printavetorpreench();
    printavetorcomp();
    return 0;
}