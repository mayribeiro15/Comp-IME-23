#include <cstdlib>
#include <iostream>
using namespace std;

class Superpoder{
private:
    string nome;
    int categoria;
public:
    Superpoder(string nome, int categoria): nome(nome), categoria(categoria){
    }
    string getNome(){
        return nome;
    }
    int getCategoria(){
        return categoria;
    }
};

class Personagem{
private:
    string nome, nomeVidaReal;
    Superpoder **poderes; //vetor dinamicamente com elementos que são ponteiros
    int nPoderes;
public:
    Personagem(string nome, string nomeVidaReal):
        nome(nome), nomeVidaReal(nomeVidaReal){
            poderes = new Superpoder*[4];
            nPoderes = 0;
    }
    ~Personagem(){ //destrutor
        delete[] poderes; 
    }
    Personagem(const Personagem &p){ //construtor por cópia em outra area de memoria
        nome = p.nome;
        nomeVidaReal = p.nomeVidaReal;
        poderes = new Superpoder*[4];
        for(int i=0;i<4;i++)
            poderes[i] = p.poderes[i];
    }
    string getNome(){
        return nome;
    }
    bool adicionaSuperpoder(Superpoder &sp){
        if(nPoderes<4){
            poderes[nPoderes] = &sp;
            nPoderes++;
            return true;
        }
        return false;
    }
    virtual double getPoderTotal(){
        double total=0;
        for(int i=0; i<nPoderes; i++)
            total=total+poderes[i]->getCategoria();
        return total;
    }
};

class SuperHeroi:public Personagem{
public:
    SuperHeroi(string nome, string nomeVidaReal):
        Personagem(nome,nomeVidaReal){
    }
    double getPoderTotal(){
        return 1.1*Personagem::getPoderTotal(); //operador de escopo
    }
};

class Vilao:public Personagem{
private:
    int tempoDePrisao;
public:
    Vilao(string nome, string nomeVidaReal, int tempoDePrisao):
        Personagem(nome,nomeVidaReal), tempoDePrisao(tempoDePrisao){
    }
    double getPoderTotal(){
        return (1+0.01*tempoDePrisao)*Personagem::getPoderTotal(); //operador de escopo
    }
};

class Confronto{
public:
    string enfrentar(Personagem &p1, Personagem &p2){
        if(p1.getPoderTotal()>p2.getPoderTotal()) return p1.getNome();
        if(p2.getPoderTotal()>p1.getPoderTotal()) return p2.getNome();
        if(p1.getPoderTotal()==p2.getPoderTotal()) return "empate";
    }
};

int main(){
    Superpoder poder("cosquinha",3);
    cout << poder.getCategoria() << " " << poder.getNome() << endl;
    SuperHeroi sh("FelDido", "Felipe");
    sh.adicionaSuperpoder(poder);
    cout << sh.getNome() << " " << sh.getPoderTotal() << endl;
    Vilao a("MyBraba", "Mayara", 21);
    a.adicionaSuperpoder(poder);
    cout << a.getNome() << " " << a.getPoderTotal() << endl;
    Confronto bora;
    cout << "\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n" << bora.enfrentar(sh,a);
    return 0;
}