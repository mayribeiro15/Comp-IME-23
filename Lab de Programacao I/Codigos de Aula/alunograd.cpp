#include <bits/stdc++.h>
using namespace std;

class MilitarAtiva{
    int preccp;
    string nome, patente;
public:
    MilitarAtiva(string nome, int preccp, string patente): nome(nome), preccp(preccp), patente(patente){
    }
    void printInfoMil(){
        cout << "----- INFO MILITAR -----" << endl;
        cout << "Nome = " << nome << endl;
        cout << "Prec-cp = " << preccp << endl;
        cout << "Patente = " << patente << endl;
    }
};

class Aluno{
    string nome, engenharia;
    int cod;
protected:
    vector<double> notas;
public:
    Aluno(string nome, string engenharia, int cod):
        nome(nome), engenharia(engenharia), cod(cod){
    }
    void adicionarNota(double x){
        notas.push_back(x);
    }
    virtual void printInfoAluno(){
        cout << "----- INFO ALUNO -----" << endl;
        cout << "Nome = " << nome << endl;
        cout << "Codigo = " << cod << endl;
        cout << "Engenharia = " << engenharia << endl;
        cout << "Notas = " ;
        for(int i=0; i<notas.size(); i++){
            if(i>0) cout << ", ";
            cout << notas[i];
        }
        cout << endl;
    }
    virtual double calculaMedia()=0;
};

class CFGAtiva:public Aluno, public MilitarAtiva{
    double notaMil;
public:
    CFGAtiva(string nome, string engenharia, int cod): Aluno(nome, engenharia, cod), MilitarAtiva(nome, 0, "Aluno"){
        notaMil=0;
    }
    void adicionarNotaMil(double x){
        notaMil=x;
    }
    double calculaMedia(){
        double media=0;
        for(int i=0; i<notas.size(); i++){
            media+=notas[i];
        }
        media=notaMil*0.5+(media*0.5)/notas.size();
        return media;
    }
    void printInfoAluno(){
        Aluno::printInfoAluno();
        cout << "Nota Militar = " << notaMil << endl;
        cout << "Media = " << calculaMedia() << endl;
    }
};

class CFGReserva:public Aluno{
public:
    CFGReserva(string nome, string engenharia, int cod): Aluno(nome, engenharia, cod){
    }
    void printInfoAluno(){
        Aluno::printInfoAluno();
        cout << "Media = " << calculaMedia() << endl;
    }
    double calculaMedia(){
        double media=0;
        for(int i=0; i<notas.size(); i++){
            media+=notas[i];
        }
        media=media/notas.size();
        return media;
    }
};


int main(){
    CFGAtiva aluno19050("Mayara", "Computacao", 19050);
    aluno19050.printInfoMil();
    CFGReserva aluno19450("MayDaDeep", "Mecanica", 19450);
    aluno19050.adicionarNota(9.5);
    aluno19050.adicionarNota(10);
    aluno19050.adicionarNotaMil(10);
    aluno19450.adicionarNota(9.5);
    aluno19450.adicionarNota(10);
    aluno19050.printInfoAluno();
    aluno19450.printInfoAluno();
    return 0;
}