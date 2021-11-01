#include <iostream>
#include <cmath>
using namespace std;
//#include <bits/stdc++.h>=

class Ponto{
private:
    float x,y,z;
public:
    Ponto(const Ponto &p){
        x = p.x;
        y = p.y;
        z = p.z;
        cout << "Objeto construido por copia" << endl;
    }
    Ponto(float px=0, float py=0, float pz=0){ //aceita 0, 1, 2 ou 3 paramentos
        x = y = z = 0;
        setX(px);
        setY(py);
        setZ(pz);
        cout << "Objeto construido" << endl;
    }
    ~Ponto(){ //colocando coisas no destructor
       cout << "Objeto destruido" << endl;
    }
    float getX(){
        return x;
    }
    bool setX(float px){
        if(px>=0){
            x=px;
            return true;
        }
        return false;
    }
    float getY(){
        return y;
    }
    bool setY(float py){
        if(py>=0){
            y=py;
            return true;
        }
        return false;
    }
    float getZ(){
        return z;
    }
    bool setZ(float pz){
        if(pz>=0){
            z=pz;
            return true;
        }
        return false;
    }
    float calcDist(Ponto p){
        return sqrt((x-p.x)*(x-p.x) +
                    (y-p.y)*(y-p.y) +
                    (z-p.z)*(z-p.z));
    }
};

int main(){
    Ponto p1(3,4,0), p2;
    cout << p1.calcDist(p2) << endl;
    return 0;
}
