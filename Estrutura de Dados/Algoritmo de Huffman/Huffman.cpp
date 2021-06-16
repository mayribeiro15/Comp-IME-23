#include <bits/stdc++.h>
using namespace std;

typedef struct no{
    char rotulo;
    int freq;
    struct no *esq;
    struct no *dir;
}no;

typedef struct item{
    no *n;
    struct item *prox;
}item;

typedef struct lista{
    item *elemento;
    int total;
}lista;

map<char,string> tabelaHuff;

map<char, int> getFrequencias(const char *inputName){
    map<char, int> frequencias;
    char c;
    ifstream inputFile(inputName);
    if (inputFile.is_open()){
        while(inputFile.get(c)){
            frequencias[c]++;
        }
        inputFile.close();
    }
    return frequencias;
}

no *newNo(char rotulo, int freq, no *esq, no *dir){
    no *aux;
    aux = new no[sizeof(*aux)];
    aux->rotulo=rotulo;
    aux->freq=freq;
    aux->esq=esq;
    aux->dir=dir;
    return aux;
}

item *newItem(no *no){
    item *aux;
    aux = new item[sizeof(*aux)];
    aux->n=no;
    aux->prox=NULL;
    return aux;
}

void inserirItem(lista *Lista, item *Item){
        if(!Lista->elemento) Lista->elemento=Item;
        else if(Item->n->freq <= Lista->elemento->n->freq){
            Item->prox = Lista->elemento;
            Lista->elemento = Item;
        } else {
            item *aux = Lista->elemento->prox;
            item *ant = Lista->elemento;
            while(aux && Item->n->freq > aux->n->freq){
                ant=aux;
                aux=aux->prox;
            }
            ant->prox=Item;
            Item->prox=aux;
        }
        Lista->total++;
}

lista *newLista(map<char, int> frequencias){
    lista *aux;
    aux = new lista[sizeof(item)];
    aux->elemento=NULL;
    aux->total=0;
    for(auto it=frequencias.begin(); it!=frequencias.end(); it++){
        char rotulo = it->first;
        int freq = it->second;
        no *No= newNo(rotulo,freq,NULL,NULL);
        item *Item= newItem(No);
        inserirItem(aux,Item);
    }
    return aux;
}

no *popLista(lista *Lista){
    item *aux = Lista->elemento;
    no *aux2 = aux->n;
    Lista->elemento=aux->prox;
    Lista->total--;
    return aux2;
}

no *newArvoreHuff(lista *Lista){
    while(Lista->total>1){
        no *noDir = popLista(Lista);
        no *noEsq = popLista(Lista);
        int freq = noDir->freq + noEsq->freq;
        no *aux = newNo(NULL,freq,noDir,noEsq);
        item *aux2 = newItem(aux);
        inserirItem(Lista,aux2);
    }
    return popLista(Lista);
}

void printPre(ofstream &arvFile, no *raiz){
    if (raiz){
        if(!raiz->rotulo) arvFile << "(#," << raiz->freq << "), ";
        else arvFile << "(" << raiz->rotulo << "," << raiz->freq << "), ";
        printPre(arvFile, raiz->esq);
        printPre(arvFile, raiz->dir);
    }
}

void printSim(ofstream &arvFile, no *raiz){
    if (raiz){
        printSim(arvFile, raiz->esq);
        if(!raiz->rotulo) arvFile << "(#," << raiz->freq << "), ";
        else arvFile << "(" << raiz->rotulo << "," << raiz->freq << "), ";
        printSim(arvFile, raiz->dir);
    }
};

void writeArv(const char *arvName, no *raiz){
    ofstream arvFile(arvName);
    printPre(arvFile, raiz);
    arvFile << "\n";
    printSim(arvFile, raiz);
    arvFile.close();
}

void writeCod(const char *inputName, const char *codName){
    char c;
    ofstream out(codName);
    ifstream inputFile(inputName);
    if (inputFile.is_open()){
        while(inputFile.get(c)){
            out << tabelaHuff[c];
        }
        inputFile.close();
    }
    out.close();
}

void writeCtx(const char *inputName, const char *ctxName){
    char c;
    ofstream out(ctxName);
    ifstream inputFile(inputName);
    if (inputFile.is_open()){
        while(inputFile.get(c)){
            out << tabelaHuff[c];
            for(int i=tabelaHuff[c].size();i<8;i++) out << 0;
        }
        inputFile.close();
    }
    out.close();
}

void percArv(no *raiz, string cod){
    if(!raiz->rotulo){
        percArv(raiz->esq, cod+"0");
        percArv(raiz->dir, cod+"1");
    } else{
        tabelaHuff[raiz->rotulo]=cod;
    } 
}

void tabelaCod(map<char, int> frequencias, no *raiz){
    string cod;
    percArv(raiz, cod);
}

map<char, int> readFreqArvoreHuff(const char *arvName){
    ifstream arvFile(arvName);
    char c, read[3];
    map<char, int> frequencias;
    arvFile.seekg(1, ios::cur);
    while(!arvFile.eof()){
        arvFile.read(read,3);
        if (read[0] != '#'){
            frequencias[read[0]] = read[2]-'0';
        }
        arvFile.get(c);
        while(isdigit(c)){
            if (read[0] != '#'){
                frequencias[read[0]] = frequencias[read[0]]*10 + c-'0';
            }
            arvFile.get(c);
        }
        arvFile.read(read,3);
        if(read[2]=='\n') break;
    }
    arvFile.close();
    return frequencias;
}

void writeText(const char *codName, const char *outputName, no *raiz){;
    ofstream outFile(outputName);
    ifstream codFile(codName);
    no *aux=raiz;
    char c;
    if (codFile.is_open()){
        while(codFile.get(c)){
           if(c=='1'){
                aux=aux->dir;
            }
            else if(c=='0') {
                aux=aux->esq;
            }
            if(aux->rotulo!= NULL){
                outFile << aux->rotulo;
                aux=raiz;
            }
        }
        codFile.close();
    }
    outFile.close();
    codFile.close();
}

void codifica(const char *inputName, const char *arvName, const char *codName, const char *ctxName){
    map<char, int> frequencias = getFrequencias(inputName);
    lista *Lista = newLista(frequencias);
    no *raiz = newArvoreHuff(Lista);

    tabelaCod(frequencias, raiz);
    writeCod(inputName, codName);
    writeCtx(inputName, ctxName);
    writeArv(arvName, raiz);

    cout << "Codificado com sucesso!" << endl;
    cout << " - Entrada: " << inputName << endl;
    cout << " - Saida: " << codName << endl;
}

void decodifica(const char *outputName, const char *arvName, const char *codName){
    char c;
    map<char, int> frequencias = readFreqArvoreHuff(arvName);
    lista *Lista = newLista(frequencias);
    no *raiz = newArvoreHuff(Lista);
    tabelaCod(frequencias, raiz);
    
    writeText(codName, outputName, raiz);

    cout << "Decodificado com sucesso!" << endl;
    cout << " - Entrada: " << codName << endl;
    cout << " - Saida: " << outputName << endl;
}

int main(){
    codifica("input.txt","arvhuf.txt","texto.hfm","texto.ctx");
    decodifica("saida.txt","arvhuf.txt","texto.hfm");
    return 0;
}