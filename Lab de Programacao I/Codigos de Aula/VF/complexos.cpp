#include <iostream>=
#include <cmath>=
using namespace std;
//#include <bits/stdc++.h>=

class Complexo{
//private:
    float r, i;
public:
    Complexo(float zr=0, float zi=0) //constructor que aceita 0, 1 ou 2 parametro, pode ser real.
        :r(zr), i(zi){ //linha de inicialização, a ser estudada no futuro
    }
        //sintaxe acima especifica no construtor, tambem pode ser assim: (dentro do bloco)
        //r = zr;
        //i = zi;

    ~Complexo(){
    }
    float modulo(){
        return sqrt(r*r + i*i);
    }
    Complexo conjugado(){
        Complexo conj;
        conj.r = r;
        conj.i = -i;
        return conj;
    }
    void imprimir(){
        cout << r << " + " << i << "i" << endl;
    }
    Complexo soma(Complexo z){
        Complexo ans;
        ans.r = r+z.r;
        ans.i = i+z.i;
        return ans;
    }
    Complexo subtracao(Complexo z){
        Complexo ans;
        ans.r = r-z.r;
        ans.i = i-z.i;
        return ans;
    }
    Complexo multiplicacao(Complexo z){
        Complexo ans;
        ans.r = r*z.r - i*z.i;
        ans.i = r*z.i + i*z.r;
        return ans;
    }
    Complexo divisao(Complexo z){
        Complexo ans = multiplicacao(z.conjugado());
        ans.r = ans.r/(z.modulo()*z.modulo());
        ans.i = ans.i/(z.modulo()*z.modulo());
        return ans;
    }
    
    Complexo operator++(){
        r++;
        return *this;
    }
    Complexo operator++(int){
        i++;
        return *this;
    }
    Complexo operator+(Complexo c){
        return Complexo(r+c.r, i+c.i);
    }
    Complexo operator=(Complexo c){
        r=c.r;
        i=c.i;
        return *this;
    }
    bool operator==(Complexo c){
        return r==c.r && i==c.i;
    }

    friend ostream &operator<<(ostream& os, const Complexo &c);
    friend Complexo operator+(int x, Complexo c);
};

ostream &operator<<(ostream& os, const Complexo &c){
    os << c.r << ((c.i>=0)?"+":"") << c.i << "i";
}

Complexo operator+(int x, Complexo c){
    return Complexo(x+c.r,c.i);
}

int main(){
    Complexo c1(1,2), c2(2,4);
    cout << c1.modulo() << endl;
    c1.imprimir();
    c2.imprimir();
    c1.conjugado().imprimir();
    Complexo c3 = c1.divisao(c2);
    c3.imprimir();

    //Novos 
    cout <<"\nNew\n" << c1 << endl;
    cout << ++c1 << endl;
    cout << c1++ << endl;
    cout << c2 << endl;
    cout << c1+c2 << endl;

    return 0;
}
