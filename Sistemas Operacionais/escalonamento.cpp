#include <bits/stdc++.h>
using namespace std;

int durES = 20;
int qntQ0 = 10;
int qntQ1 = 15;
int tim = 0;
int curExec = -1;
vector<int> gant1, gant2;

typedef struct proc{
    int i;
    int dur;
    int toExec;
    int wasExec=0;
    int oprES;
    int timES;
}proc;

queue<proc> Q0, Q1, Q2, ES;

int execProc(proc *p){
    if((*p).i!=curExec){
        gant1.push_back(tim);
        gant2.push_back((*p).i);
        curExec = (*p).i;
    }
    (*p).toExec--;
    (*p).wasExec++;
}

void execFilas(){
    proc *p;
    if(!Q0.empty()){
        p = &(Q0.front());
        execProc(p);
        if((*p).wasExec==qntQ0 || (*p).toExec==0){
            (*p).wasExec=0;
            Q0.pop();
            if((*p).toExec>0){
                Q1.push(*p);
            } else if((*p).oprES>0){
                ES.push(*p);
            }
        }
    } else if (!Q1.empty()){
        p = &(Q1.front());
        execProc(p);
        if((*p).wasExec==qntQ1 || (*p).toExec==0){
            (*p).wasExec=0;
            Q1.pop();
            if((*p).toExec>0){
                Q2.push(*p);
            } else if((*p).oprES>0){
                ES.push(*p);
            }
        }
    } else if (!Q2.empty()){
        p = &(Q2.front());
        execProc(p);
        if((*p).toExec==0){
            (*p).wasExec=0;
            Q2.pop();
            if((*p).oprES>0){
                ES.push(*p);
            }
        }
    } 
}

void execES(){
    if(!ES.empty()){
        proc *p=&(ES.front());
        if((*p).wasExec>=20){
            (*p).wasExec=0;
            (*p).toExec=(*p).dur;
            (*p).oprES--;
            ES.pop();
            Q0.push(*p);
            p=&(ES.front());
        }
        (*p).wasExec++;
        if(Q0.empty() && Q1.empty() && Q2.empty()){
            proc aux;
            aux.i=-1;
            execProc(&aux);
        }
    }
}

void generateGantt(){
    cout << "\nGrafico de Gantt Resultante:" << endl;
    for(int i=0;i<gant1.size();i++){
        cout << gant1[i] << setw(8);
    }
    cout << "        " << endl;
    for(int i=0;i<gant2.size();i++){
        if(gant2[i]==-1){
            cout << "---//---";
        } else {
            cout << "---P" << gant2[i] << "---";
        }
    }
    cout << "---";
};

int main(){
    int n;
    cout << "Numero de processos = ";
    cin >> n;

    for(int i=0;i<n;i++){
        proc aux;
        aux.i=i;
        cout << "- Burst de P" << i << " = ";
        cin >> aux.dur;
        cout << "- Operacoes de ES de P" << i << " = ";
        cin >> aux.oprES;
        aux.toExec=aux.dur;
        Q0.push(aux);
    }

    while(!Q0.empty() || !Q1.empty() || !Q2.empty() || !ES.empty()){
        execES();
        execFilas();
        tim++;
    }
    gant1.push_back(tim);

    generateGantt();

    return 0;
}