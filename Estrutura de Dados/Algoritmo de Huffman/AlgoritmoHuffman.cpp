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

map<char, int> getFrequencias(FILE *inputFile){
    map<char, int> frequencias;
    char c;
    while (fread(&c, 1, 1, inputFile) >= 1){
        frequencias[c]++;
    }
    rewind(inputFile);
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

void printPre(FILE *arvFile, no *raiz){
    if (raiz){
        if(!raiz->rotulo) fprintf(arvFile, "(#,%d), ", raiz->freq);
        else fprintf(arvFile, "(%c,%d), ",raiz->rotulo,raiz->freq);
        printPre(arvFile, raiz->esq);
        printPre(arvFile, raiz->dir);
    }
}

void printSim(FILE *arvFile, no *raiz){
    if (raiz){
        printSim(arvFile, raiz->esq);
        if(!raiz->rotulo) fprintf(arvFile, "(#,%d), ", raiz->freq);
        else fprintf(arvFile, "(%c,%d), ",raiz->rotulo,raiz->freq);
        printSim(arvFile, raiz->dir);
    }
};

void writeArv(FILE *arvFile, no *raiz){
    printPre(arvFile, raiz);
    fprintf(arvFile, "\n");
    printSim(arvFile, raiz);
}

void writeCod(FILE *inputFile, const char *codName){
    char c;
    ofstream out(codName);
    while (fread(&c, 1, 1, inputFile) >= 1){
        out << tabelaHuff[c];
    }
    out.close();
    rewind(inputFile);
}

void writeCtx(FILE *inputFile, const char *ctxName){
    char c;
    ofstream out(ctxName);
    while (fread(&c, 1, 1, inputFile) >= 1){
        out << tabelaHuff[c];
        for(int i=tabelaHuff[c].size();i<8;i++) out << 0;
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

map<char, int> readFreqArvoreHuff(FILE *arvFile){
    rewind(arvFile);
    char check, read[3];
    map<char, int> frequencias;
    fseek(arvFile, 1, SEEK_CUR);
    while(!feof(arvFile)){
        fread(read, sizeof(read), 1, arvFile);
        if (read[0] != '#'){
            frequencias[read[0]] = read[2]-'0';
        }
        fread(&check, 1, 1, arvFile);
        while(isdigit(check)){
            if (read[0] != '#'){
                frequencias[read[0]] = frequencias[read[0]]*10 + check-'0';
            }
            fread(&check, 1, 1, arvFile);
        }
        fseek(arvFile, 2, SEEK_CUR);
        fread(&check, 1, 1, arvFile);
        if(check=='\n') break;
    }
    rewind(arvFile);
    return frequencias;
}

void writeText(FILE *codFile, const char *outputName, no *raiz){
    rewind(codFile);
    ofstream out(outputName);
    no *aux=raiz;
    char c;
    while(fread(&c, 1, 1, codFile) >= 1){
        if(c=='1'){
            aux=aux->dir;
        }
        else if(c=='0') {
            aux=aux->esq;
        }
        if(aux->rotulo!= NULL){
            out << aux->rotulo;
            aux=raiz;
        }
    }
    out.close();
}

void codifica(const char *inputName, const char *arvName, const char *codName, const char *ctxName){
    FILE *inputFile = fopen(inputName, "rb");
    if(!inputFile){
        printf("Arquivo de entrada nao encontrado\n");
        return;
    }
    map<char, int> frequencias = getFrequencias(inputFile);
    lista *Lista = newLista(frequencias);
    no *raiz = newArvoreHuff(Lista);

    tabelaCod(frequencias, raiz);
    writeCod(inputFile, codName);
    writeCtx(inputFile, ctxName);
    fclose(inputFile);

    FILE *arvFile = fopen(arvName, "wb");
    if(!arvFile){
        printf("Arquivo de arvore nao encontrado\n");
        return;
    }
    writeArv(arvFile, raiz);
    fclose(arvFile);
    cout << "Codificado com sucesso!" << endl;
    cout << " - Entrada: " << inputName << endl;
    cout << " - Saida: " << codName << endl;
}

void decodifica(const char *outputName, const char *arvName, const char *codName){
    FILE *arvFile = fopen(arvName, "rb");
    if(!arvFile){
        printf("Arquivo de arvore nao encontrado\n");
        return;
    }
    char c;
    map<char, int> frequencias = readFreqArvoreHuff(arvFile);
    lista *Lista = newLista(frequencias);
    no *raiz = newArvoreHuff(Lista);
    tabelaCod(frequencias, raiz);
    fclose(arvFile);

    FILE *codFile = fopen(codName, "rb");
    if(!codFile){
        printf("Arquivo de codificacao nao encontrado\n");
        return;
    }
    
    writeText(codFile, outputName, raiz);
    fclose(codFile);

    cout << "Decodificado com sucesso!" << endl;
    cout << " - Entrada: " << codName << endl;
    cout << " - Saida: " << outputName << endl;
}

int main(){
    codifica("input.txt","arvhuf.txt","texto.hfm","texto.ctx");
    decodifica("saida.txt","arvhuf.txt","texto.hfm");
    return 0;
}
