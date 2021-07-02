#include <iostream>
#include <iomanip>
#include <fstream>
#include <sstream>
#include <vector>
using namespace std;

struct Candidato{
    int numero;
    string nome;
    string partido;
    int votos;
};


int main(){
    ifstream arqCandidatos;
    arqCandidatos.open("candidatos.txt");
    if (!arqCandidatos.is_open()){
        cout << "Arquivo Inválido de Candidatos" << endl;
        return 1;
    }

    int n;
    vector<Candidato> candidatos(20);
    while(!arqCandidatos.eof()){
        string candidato, partido;
        arqCandidatos >> n >> candidato >> partido;
        if (arqCandidatos.good()){
            candidatos[n-1].numero = n;
            candidatos[n-1].nome = candidato;
            candidatos[n-1].partido = partido;
            candidatos[n-1].votos = 0;
        }
    }
    arqCandidatos.close();

    vector<int> votos={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};    
    stringstream urna;
    for (int j=1;j<5;j++)
        urna << "urna" << j << ".txt ";

    float total=0;
    for (int j=1;j<5;j++){
        string nomeArq;
        urna >> nomeArq;

        ifstream arqVotos;
        arqVotos.open(nomeArq.c_str());
        if (!arqVotos.is_open()){
            cout << "Arquivo Inválido de Votos " << j << endl;
            return j+1;
        }
        while(!arqVotos.eof()){
            int n;
            arqVotos >> n;
            if (arqVotos.good()){
                candidatos[n-1].votos++;
                total++;
            }
        }
        arqVotos.close();
    }

    vector<int> ordem(20);
    for (int i=0;i<20;i++)
        ordem[i] = i;
    for (int i=0;i<20;i++){
        for (int j=i+1;j<n;j++){
            if (candidatos[ordem[i]].votos < candidatos[ordem[j]].votos)
                swap(ordem[i], ordem[j]);
        }
    }
    
    for (int i=0;i<20;i++)
        cout << (float(candidatos[ordem[i]].votos)/total)*100 << "% " << candidatos[ordem[i]].nome << endl;

    return 0;
}