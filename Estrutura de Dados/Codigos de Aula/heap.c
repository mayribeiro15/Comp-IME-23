#include <stdio.h>

#define N 50
int heap[N+1]={0,40,10,50,20,30,80,70,60,90,110,100};

void subir (int *heap, int pos) {
    if (pos==1) return;
    int pai = pos/2;
    if(heap[pai]<heap[pos]){
        int aux = heap[pai];
        heap[pai] = heap[pos];
        heap[pos] = aux;
        subir(heap, pai);
    }
}

void descer (int *heap, int pos) {
    int filho_esq = 2*pos, filho_dir = 2*pos+1;
    int maior_filho;
    if(filho_esq > heap[0]) return; // é uma folha
    if(filho_esq == heap[0]){ //so tem esse filho
        maior_filho = filho_esq; 
    } else if (heap[filho_esq]>heap[filho_dir]) {
        maior_filho = filho_esq;
    } else {
        maior_filho = filho_dir;
    }
    if(heap[maior_filho]>heap[pos]){
        int aux = heap[maior_filho];
        heap[maior_filho] = heap[pos];
        heap[pos] = aux;
        descer(heap, maior_filho);
    }
}

int inserir (int *heap, int x) {
    if (heap[0]==N) return 0; //heap cheio
    heap[0]++;
    heap[heap[0]]=x;
    subir(heap,heap[0]);
    return 1;
}

int remover (int *heap){
    if(heap[0]==0) return 0;
    int x = heap[1];
    heap[1]=heap[heap[0]];
    heap[0]--;
    descer(heap,1);
    return x;
}

void const_heap (int *heap, int n){ //mandei subir todos os nós O(nlogn)
    for(int i=1; i<=n;i++){
        heap[0]++;
        subir(heap,i);
    }
}

void const_heap2 (int *heap, int n){ //O(n) mandando descer os nós internos (de h[0]/2 pra cima)
    heap[0]=n;
    for(int i=heap[0]/2; i>=1;i--){
        descer(heap,i);
    }
}

void heap_sort (int *heap){ //remoções sucessivas pois sempre remove o maior (h[1])
    int aux0 = heap[0];
    while(heap[0]>1){
        int aux = heap[1];
        heap[1] = heap[heap[0]];
        heap[heap[0]]=aux;
        heap[0]--;
        descer(heap,1);
    }
    heap[0] = aux0;
}

void imprimir (int *heap) {
    for(int i=1; i<=heap[0]; i++){
        printf("%d ",heap[i]);
    }
    printf("\n");
}

int main(){
    // heap[0]=0; //numero de elementos
    // inserir(heap,70);
    // inserir(heap,33);
    // inserir(heap,95);
    // imprimir(heap);
    // inserir(heap,78);
    // imprimir(heap);
    // inserir(heap,60);
    // inserir(heap,39);
    // inserir(heap,66);
    // inserir(heap,28);
    // imprimir(heap);
    // printf("%d\n",remover(heap));
    // imprimir(heap);

    const_heap2(heap,11);
    imprimir(heap);
    heap_sort(heap);
    imprimir(heap);

    return 0;
}