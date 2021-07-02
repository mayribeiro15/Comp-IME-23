#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define TOTAL_VALORES 5
#define TOTAL_MEDIAS 4
#define JANELA 2

float gen_al(){
    return (rand()%81)+20;
}

template<typename T>
void imprimir(vector<T> v){
    //vector<T>::const_iterator it;
    for(auto it=v.begin(); it!=v.end(); it++){
        cout << (*it) << " ";
    }
    cout << endl;
}

class gen_mms{
    vector<float> valores;
    int janela;
public:
    gen_mms(vector<float> valores, int janela): valores(valores), janela(janela){
    }
    ~gen_mms(){
    }
    float operator() (){
        static int i=0;
        float soma=0;

        vector<float>::const_iterator it;
        for(it=valores.begin()+i; it!=valores.begin()+i+janela; it++){
            if(it==valores.end()) throw "Erro: valores invalidos";
            soma += (*it);
        }

        i++;
        float media = soma/janela;
        return media;
    }
};

int main(){
    vector<float> valores(TOTAL_VALORES);
    vector<float> mms(TOTAL_MEDIAS);

    generate(valores.begin(), valores.end(), gen_al);
    imprimir(valores);

    generate_n(mms.begin(), TOTAL_MEDIAS, gen_mms(valores,JANELA));
    imprimir(mms);

    return 0;
}