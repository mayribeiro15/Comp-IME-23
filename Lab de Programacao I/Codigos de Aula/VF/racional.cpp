#include <iostream>
using namespace std;

int mdc(int n1, int n2){
    if(n2!=0)
        return mdc(n2, n1%n2);
    else
        return n1;
}

class Racional{
    int num, den;
public:
    Racional(int num, int den): num(num), den(den){
        if(den==0) 
            throw "Denominador0";
        int m = mdc(num, den);
        this->num = num/m;
        this->den = den/m;
        if(this->den < 0){
            this->num *= -1;
            this->den *= -1;
        }
    }
    void imprimir(){
        cout << num << "/" << den << endl;
    }
    Racional operator+(Racional c){
        return Racional((num*c.den+den*c.num),(den*c.den));
    }
    Racional operator/(Racional c){
        return Racional((num*c.den),(den*c.num));
    }
    Racional operator++(){
        num+=den;
        return (*this);
    }
    Racional operator++(int){
        Racional temp(*this);
        num+=den;
        return temp;
    }
    float converter(){
        return float(num)/float(den);
    }
};

int main(){
    Racional q(5,15), p(1,2);
    q.imprimir();
    p.imprimir();
    Racional u=p+q;
    u.imprimir();
    cout << u.converter() << endl;
    try{
        Racional q(1,0);
    } 
    catch (const char *erro){
        cout << erro;
    }
    return 0;
}