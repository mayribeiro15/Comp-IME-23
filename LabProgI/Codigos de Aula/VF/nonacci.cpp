#include <iostream>
using namespace std;

template<int N>
#define N 2

class Nonacci{
    ostream *os;
public:
    Nonacci(){  
    }
    ~Nonacci(){
    }
    int elemento(int v){
        if(v<=N)
            return 1;
        else{
            int e=0;
            for(int i=0;i<N;i++){
                e += elemento(v-1-i);
            }
            return e;
        }
    }
    ostream &operator<<(const int &v){
        return *os << elemento(v);
    }
    friend Nonacci<N> &operator<<(ostream& os, Nonacci<N> &X){
        X.os = &os;
        return X;
    }
};

int main(){
    int v = 6;
    Nonacci<N> X;
    cout << X << v << endl;
    return 0;
}