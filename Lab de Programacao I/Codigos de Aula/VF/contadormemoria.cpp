#include <iostream>

using namespace std;

class Count{
    static int contador;
    int valor;
public:
    Count(){
        contador++;
    }
    Count(const Count &c){
        valor = c.valor;
        contador++;
    }
    ~Count(){
        contador--;
    }
    static int getContador(){
        return contador;
    }
};

int Count::contador = 0;

int main(){
    Count c;
    cout << Count::getContador() << endl;

    Count *p; //nao conta
    Count &r = c; //nao conta
    cout << Count::getContador() << endl;

    p = new Count; //agora conta
    cout << Count::getContador() << endl;
    delete p; //desconta
    cout << Count::getContador() << endl;
   
    Count c1 = c; //conta como copia
    cout << Count::getContador() << endl;
    
    const Count c2 = c; //pode usar metodo static para const
    cout << Count::getContador() << endl;
}