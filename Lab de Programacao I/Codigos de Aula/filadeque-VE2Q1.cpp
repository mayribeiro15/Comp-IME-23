#include <cstdlib>
#include <iostream>
using namespace std;

enum modoDeque {frente=0, retaguarda};

class Deque{
private:
    int tamanho, tamanhoMax;
    int *vetor;
public:
    Deque(int tamanhoMax):tamanhoMax(tamanhoMax){
        tamanho=0;
        vetor = new int[tamanho];
    }
    ~Deque(){
        delete[] vetor; 
    }
    int inserir(int valor, modoDeque modo){
        if(tamanho==tamanhoMax) return 0;
        if(modo==retaguarda){
            vetor[tamanho]=valor;
            tamanho++;
            return 1;
        }
        if(modo==frente){
            for(int i=tamanho;i>0;i--){
                vetor[i]=vetor[i-1];
            }
            vetor[0]=valor;
            tamanho++;
            return 1;
        }
    }
    int remover(modoDeque modo){
        if(tamanho==0) return 0;
        if(modo==retaguarda){
            tamanho--;
            return 1;
        }
        if(modo==frente){
            for(int i=0;i<tamanho-1;i++){
                vetor[i]=vetor[i+1];
            }
            tamanho--;
            return 1;
        }
    }
    void imprimir(){
        if(tamanho==0) cout<<"Vazio";
        for(int i=0; i<tamanho; i++){
            if(i==tamanho-1) cout << vetor[i];
            else cout << vetor[i] << ",";
        }
        cout << endl;
    }
};

class Fila:public Deque{
public:
    Fila(int tamanhoMax):Deque(tamanhoMax){
    }
    int inserir(int valor){
        Deque::inserir(valor, retaguarda);
    }
    int remover(){
        Deque::remover(frente);
    }
};

int main(){
    cout << "Testes Deque" << endl;
    Deque teste1(3);
    teste1.inserir(1, retaguarda);
    teste1.imprimir();
    teste1.inserir(2, frente);
    teste1.imprimir();
    teste1.inserir(3, retaguarda);
    teste1.imprimir();
    teste1.inserir(4, retaguarda); //não consegue, tam max
    teste1.imprimir();
    teste1.remover(retaguarda);
    teste1.imprimir();
    teste1.remover(frente);
    teste1.imprimir();
    teste1.remover(frente);
    teste1.imprimir();
    teste1.remover(frente); //não consegue, 0 elementos
    teste1.imprimir();
    
    cout << "Testes Fila" << endl;
    Fila teste2(3);
    teste2.inserir(1);
    teste2.imprimir();
    teste2.inserir(2);
    teste2.imprimir();
    teste2.inserir(3);
    teste2.imprimir();
    teste2.inserir(4); //não consegue, tam max
    teste2.imprimir();
    teste2.remover();
    teste2.imprimir();
    teste2.remover();
    teste2.imprimir();
    teste2.remover();
    teste2.imprimir();
    return 0;
}