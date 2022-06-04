#include <bits/stdc++.h>
using namespace std;

int ES = 20;
int qntQ0 = 10;
int qntQ1 = 15;
int tim = 0;
vector<int32_t> gant1, gant2;

typedef struct proc{
    int i;
    int dur;
    int oprES;
}proc;

queue<proc> Q0, Q1, Q2;

int execProc(int dur, proc p){
    if(p.dur<dur){
        dur = p.dur;
    }
    tim+=dur;
    gant1.push_back(tim);
    gant2.push_back(p.i);
    return dur;
}

void execRoundRobin(queue<proc> *q, int qnt, queue<proc> *prox){
    while(!(*q).empty()){
        proc p;
        p = (*q).front();
        (*q).pop();
        p.dur -= execProc(qnt, p);
        if(p.dur>0){
            (*prox).push(p);
        }
    }
}

void execFCFS(queue<proc> *q){
    while(!(*q).empty()){
        proc p;
        p = (*q).front();
        (*q).pop();
        p.dur -= execProc(p.dur, p);
    }
}

void generateGantt(){
    cout << "\nGrafico de Gantt Resultante:" << endl;
    cout << "0  ";
    for(int i=0;i<gant1.size();i++){
        cout << setw(6) << gant1[i] << "  ";
    }
    cout << endl;
    for(int i=0;i<gant2.size();i++){
        cout << "---P" << gant2[i] << "---";
    }
    cout << "---";
};

int main(){
    int n;
    cout << "Numero de processos = ";
    cin >> n;

    for(int i=1;i<=n;i++){
        proc aux;
        aux.i=i;
        cout << "- Burst de P" << i << " = ";
        cin >> aux.dur;
        //cout << "- Operacoes de ES de P" << i << " = ";
        //cin >> aux.oprES;
        Q0.push(aux);
    }

    execRoundRobin(&Q0,qntQ0,&Q1);
    execRoundRobin(&Q1,qntQ1,&Q2);
    execFCFS(&Q2);

    generateGantt();

    return 0;
}