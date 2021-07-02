#include <iostream>
using namespace std;

template<typename T>
class Classe{
    T n;
public:
    Classe(T n): n(n){
    }
    T get(){
        return n;
    }
    T operator++(int){
        n++;
        return n;
    }
};

int main(){
    Classe<int> x(2);
    cout << x.get() << endl;

    Classe<float> y(2.5);
    y++;
    cout << y.get() << endl;
    return 0;
}