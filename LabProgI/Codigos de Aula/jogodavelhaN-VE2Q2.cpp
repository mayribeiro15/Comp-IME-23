#include <cstdlib>
#include <iostream>
using namespace std;

enum statusMovimento {UltimaJogadaValida=0, UltimaJogadaInvalida, VitoriaJogadorX, VitoriaJogadorO, Empate};

//fc para testar melhor com print do enum e do tabulheiro
void printStatus(int n){
    string s;
    switch (n){
        case 0: { s = "Jogada Valida"; } break;
        case 1: { s = "Jogada Invalida"; } break;
        case 2: { s = "Vitoria do Jogador X"; } break;
        case 3: { s = "Vitoria dp Jogador O"; } break;
        case 4: { s = "Empate"; } break;
    }
    cout << s << endl;
}

class JogodaVelha{
private:
    int **tabuleiro;
    int tamanho, jogadorVez;
public:
    JogodaVelha(int tamanho):tamanho(tamanho){
        jogadorVez=1;
        tabuleiro = new int*[tamanho];
        for(int i=0; i<tamanho; i++){
            tabuleiro[i] = new int[tamanho];
        }
        for(int i=0; i<tamanho; i++){
           for(int j=0; j<tamanho; j++) tabuleiro[i][j]=0;
        }
    }
    void imprimir(){
        for(int i=0; i<tamanho; i++){
            if(tabuleiro[i][0]==0) cout << " ";
            if(tabuleiro[i][0]==1) cout << "X";
            if(tabuleiro[i][0]==2) cout << "O";
            for(int j=1; j<tamanho; j++){
                if(tabuleiro[i][j]==0) cout << "| ";
                if(tabuleiro[i][j]==1) cout << "|X";
                if(tabuleiro[i][j]==2) cout << "|O";
            }
            if(i!=tamanho-1) cout << "\n------" << endl;
        }
        cout << "\n" << endl;
    }
    statusMovimento jogar(int i, int j){
        if(tabuleiro[i][j]!=0) return UltimaJogadaInvalida;
        tabuleiro[i][j]=jogadorVez;
        if(jogadorVez==1) jogadorVez=2;
        else jogadorVez=1;
        if(vitoria()==1) return VitoriaJogadorX;
        if(vitoria()==2) return VitoriaJogadorO;
        if(empate()) return Empate;
        return UltimaJogadaValida;
    }
    int vitoria(){
        //Verificando Diagonal
        int x=tabuleiro[0][0];
        for(int i=1; i<tamanho; i++){
            if(tabuleiro[i][i]!=x) break;
            if(i==tamanho-1) return x;
        }
        //Verificando Linha
        for(int i=0; i<tamanho; i++){
            x = tabuleiro[i][0];
            for(int j=1; j<tamanho; j++){
                if(tabuleiro[i][j]!=x) break;
                if(j==tamanho-1) return x;
            }
        }
        //Verificando Coluna
        for(int i=0; i<tamanho; i++){
            x = tabuleiro[0][i];
            for(int j=1; j<tamanho; j++){
                if(tabuleiro[j][i]!=x) break;
                if(j==tamanho-1) return x;
            }
        }
        return 0; 
    }
    int empate(){
        for(int i=0; i<tamanho; i++){
           for(int j=0; j<tamanho; j++) if(tabuleiro[i][j]==0) return 0;
        }
        return 1;
    }
};

int main(){
    JogodaVelha Jogo1(3); //testando Empate
    cout << "------JOGO 1------" << endl;
    printStatus(Jogo1.jogar(0,0));
    Jogo1.imprimir();
    printStatus(Jogo1.jogar(0,1));
    Jogo1.imprimir();
    printStatus(Jogo1.jogar(1,0));
    Jogo1.imprimir();
    printStatus(Jogo1.jogar(1,1));
    Jogo1.imprimir();
    printStatus(Jogo1.jogar(0,2));
    Jogo1.imprimir();
    printStatus(Jogo1.jogar(1,2));
    Jogo1.imprimir();
    printStatus(Jogo1.jogar(2,1));
    Jogo1.imprimir();
    printStatus(Jogo1.jogar(2,0));
    Jogo1.imprimir();
    printStatus(Jogo1.jogar(2,2));
    Jogo1.imprimir();

    JogodaVelha Jogo2(4); //testando Vitoria e Invalido
    cout << "------JOGO 2------" << endl;
    printStatus(Jogo2.jogar(0,0));
    Jogo2.imprimir();
    printStatus(Jogo2.jogar(0,1));
    Jogo2.imprimir();
    printStatus(Jogo2.jogar(1,0));
    Jogo2.imprimir();
    printStatus(Jogo2.jogar(1,0));
    Jogo2.imprimir();
    printStatus(Jogo2.jogar(1,1));
    Jogo2.imprimir();
    printStatus(Jogo2.jogar(2,0));
    Jogo2.imprimir();
    printStatus(Jogo2.jogar(3,1));
    Jogo2.imprimir();
    printStatus(Jogo2.jogar(3,0));
    Jogo2.imprimir();
    return 0;
}