#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;

class CovidData{
protected:
    string Nome;
    map<string,ll> Casos;
    map<string,ll> Obitos;
public:
    CovidData(){
    }
    CovidData(string nome): Nome(nome){
    }
    void create_data(string data, string casos, string obitos){
        char* end;
        Casos[data]=strtoll(casos.c_str(),&end,10);
        Obitos[data]=strtoll(obitos.c_str(),&end,10);
    }
    ll get_casos(string data){
        return Casos[data];
    }
    ll get_obitos(string data){
        return Obitos[data];
    }
};

class Municipio: public CovidData{
public:
    Municipio(): CovidData(){
    }
    Municipio(string nome): CovidData(nome){
    }
};

class Estado: public CovidData{
    map<string,Municipio> Municipios;
public:
	Estado(): CovidData(){
	}
    Estado(string nome): CovidData(nome){
    }
    Municipio& get_municipio(string municipio){
        if (Municipios.find(municipio)==Municipios.end()) {
            Municipio aux(municipio);
            Municipios[municipio] = aux;
        }
        return Municipios[municipio];
    }
};

class Regiao: public CovidData{
    map<string,Estado> Estados;
public:
    Regiao(): CovidData(){
    }
    Regiao(string nome): CovidData(nome){
    }
    Estado& get_estado(string estado){
        if (Estados.find(estado)==Estados.end()){
            Estado aux(estado);
            Estados.insert({estado,aux});
        }
        return (Estados[estado]);
    }
};

void read_csv(string file, map<string,Regiao> *covidData){
    ifstream covidFile(file);
    string line, data;
    ll x=0;

    getline(covidFile, line);

    while(covidFile.good()) {
        if(x%100000==0) cout << "Loading File... - (Line " << x << ")" << endl;
        x++;

        getline(covidFile, line);
        if(line[0]=='\0') break;

        stringstream ss(line);

        vector<string> result;
        while(getline(ss, data, ';')){
            result.push_back(data);
        }

        if((*covidData).find(result[0])==(*covidData).end()){
            Regiao aux(result[0]); //construtor passando o nome
            (*covidData)[result[0]]=aux;
        }

        if(result[1]==""){
            (*covidData)[result[0]].create_data(result[7],result[10],result[12]); //data, casos acu, obitos acu
        } 
        else {
            if(result[2]==""){
                (*covidData)[result[0]].get_estado(result[1]).create_data(result[7],result[10],result[12]);
            }
            else {
                (*covidData)[result[0]].get_estado(result[1]).get_municipio(result[2]).create_data(result[7],result[10],result[12]);
            }
        }
    }
    cout << "Completed!" << endl;
    covidFile.close();
}

int main(){
    string file = "HIST_PAINEL_COVIDBR_Parte3_24jun2021.csv";
    map<string,Regiao> covidData;

    cout << "CENTRAL DE MAPEAMENTO DO COVID-19" << "\n- Ultima Atualizacao: "; 
    for(int i=27; i<36; i++){
        cout << file[i];
    }
    cout << endl;
    read_csv(file, &covidData);

    cout << covidData["Brasil"].get_casos("2021-01-01") << endl;
    cout << covidData["Norte"].get_estado("RO").get_casos("2021-01-10") << endl;
    cout << covidData["Sul"].get_estado("RS").get_municipio("Candiota").get_casos("2021-04-02") << endl;
}
