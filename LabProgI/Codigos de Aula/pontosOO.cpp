#include <cstdlib>
#include <iostream>
#include <cmath>
using namespace std;

class Ponto{
private:
    float x,y,z; 
public:
    //constructor na linha de inicalização, 1 operaçao
    //se fosse dentro da fc seriam 2 operações, incializa e iguala ao valor
    Ponto(float px=0, float py=0, float pz=0): x(px), y(py), z(pz){ //podia ser x, y, z
    }
    void oposto();
    void visualizar();
    float distancia(Ponto p=Ponto()){
        return sqrt((x-p.x)*(x-p.x) +
                    (y-p.y)*(y-p.y) +
                    (z-p.z)*(z-p.z));
    }
};

void Ponto::oposto(){ //operador de resolução escopo para declara o metodo fora da classe
    x=-x;
    y=-y;
    z=-z;
}

void Ponto::visualizar(){ 
    cout << "(" << x << ", " << y << ", " << z << ")" << endl;
}

int main(){
    Ponto P;
    Ponto Q(1,2,3);
    Q.oposto();
    Ponto Z = Q;
    cout << Q.distancia() << endl;
    Z.visualizar();
    return 0;
}