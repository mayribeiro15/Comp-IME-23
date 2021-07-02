#include <iostream>
using namespace std;

template<typename T>
class Conjunto{
    int tam, cap;
    T* elems;
public:
    Conjunto(int cap): cap(cap), tam(0){  
        elems = new T[cap];
    }
    ~Conjunto(){
        delete[] elems;
    }
    Conjunto(const Conjunto &c){ //por causa do ponteiro
        cap = c.cap;
        tam = c.tam;
        elems = new T[cap];
        for(int i=0;i<tam;i++){
            elems[i]=c.elems[i];
        }
    }
    Conjunto& operator+(const Conjunto &c){ //por causa do ponteiro
        if (this==&c)
            return *this;
        delete[] elems;

        cap = c.cap;
        tam = c.tam;
        elems = new T[cap];
        for(int i=0;i<tam;i++){
            elems[i]=c.elems[i];
        }
    }
    Conjunto& operator+=(const T &x){ //inserção
        if(tam==cap)
            return *this;
        for(int i=0;i<tam;i++){
            if(elems[i]==x)
                return *this;
        }
        elems[tam++] = x;
        return *this;
    }
    Conjunto& operator+=(const Conjunto &c){ //união
        for(int i=0;i<c.tam;i++)
            *this += c.elems[i];
        return *this;
    }
    void operator!(){
        for(int i=0;i<tam;i++)
            cout << elems[i] << " ";
        cout << endl;
    }
};

int main(){
    Conjunto<int> c1(10);
    c1 += 2;
    c1 += 3;
    !c1;

    Conjunto<int> c2(10);
    c1 += 2;
    c1 += 4;
    c2 += c1;
    !c2;
    return 0;
}