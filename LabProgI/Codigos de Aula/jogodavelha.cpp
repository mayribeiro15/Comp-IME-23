#include <cstdlib>
#include <iostream>
using namespace std;

class JogodaVelha{
private:
    int tabuleiro[3][3];
    int jogadorInicial, jogadorVez, fim;
    enum statusMovimento {Inicio, MovimentoValido, MovimentoInvalido, Vitoria, Empate, Fim};
public:
    JogodaVelha(int jogadorIncial=1): jogadorInicial(jogadorInicial), jogadorVez(jogadorIncial){
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) tabuleiro[i][j] = 0;
        fim = 0;
    }
    void imprimir(){
        cout << " " << tabuleiro[0][0] << " " << tabuleiro[0][1] << " " << tabuleiro[0][2] << endl;
        cout << " " << tabuleiro[1][0] << " " << tabuleiro[1][1] << " " << tabuleiro[1][2] << endl;
        cout << " " << tabuleiro[2][0] << " " << tabuleiro[2][1] << " " << tabuleiro[2][2] << "\n" << endl;
    }
    statusMovimento jogar(int jogador, int i, int j){
        if(fim==1) return Fim;
        if(tabuleiro[i][j]==0 && jogador==jogadorVez){
            tabuleiro[i][j]=jogador;
            if(vitoria()==jogador) {fim=1; return Vitoria;}
            if(empate()) {fim=1; return Empate;}
            if(jogador==1) jogadorVez=2;
            if(jogador==2) jogadorVez=1;
            return MovimentoValido;
            
        } else {
            return MovimentoInvalido;
        }
    }
    int vitoria(){
        if((tabuleiro[0][0]==tabuleiro[1][1]) && (tabuleiro[0][0]=tabuleiro[2][2])) return tabuleiro[0][0];
        for(int i=0;i<3;i++){
            if(tabuleiro[i][0]==tabuleiro[i][1] && tabuleiro[i][1]==tabuleiro[i][2]) return tabuleiro[i][0];
        }
        for(int i=0;i<3;i++){
            if(tabuleiro[0][i]==tabuleiro[0][i] && tabuleiro[0][i]==tabuleiro[2][i]) return tabuleiro[0][i];
        }
        return 0; 
    }
    int empate(){
        return 0;
    }
};

int main(){
    JogodaVelha Jogo1(1);
    Jogo1.imprimir();
    Jogo1.jogar(1,0,0);
    Jogo1.jogar(1,0,0);
    Jogo1.jogar(2,0,1);
    Jogo1.jogar(1,1,0);
    Jogo1.jogar(2,0,2);
    Jogo1.jogar(1,2,0);
    Jogo1.imprimir();
    return 0;
}