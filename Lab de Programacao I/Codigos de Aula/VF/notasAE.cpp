#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Aluno{
    string nome;
    float nota;
};

class Turma{
    vector<Aluno> alunos;
public:
    Turma(vector<Aluno> alunos): alunos(alunos){
    }
    int tamanho(){
        return alunos.size();
    }
    void adicionarAluno(string nome, float nota){
        Aluno novo;
        novo.nome = nome;
        novo.nota = nota;
        alunos.push_back(novo);
    }
    char operator() (){
        char mencao;
        static int i=0;
        float nota = alunos[i].nota;
        if(alunos[i].nota < 2) mencao='E';
        else if(alunos[i].nota < 5) mencao='D';
        else if(alunos[i].nota < 7) mencao='C';
        else if(alunos[i].nota < 9) mencao='B';
        else mencao='A';
        i = (i+1)%tamanho();
        return mencao;
    }
};

int main(){
    Aluno Al1, Al2, Al3;
    Al1.nome="Mayara"; Al1.nota=9.5;
    Al2.nome="Amanda"; Al2.nota=7.5;
    Al3.nome="Abranches"; Al3.nota=5;
    Turma turma({Al1, Al2, Al3});
    vector<char> mencoes(turma.tamanho());
    generate(mencoes.begin(), mencoes.end(), turma);
    cout << mencoes[0] << endl;
    cout << mencoes[1] << endl;
    cout << mencoes[2] << endl;
}