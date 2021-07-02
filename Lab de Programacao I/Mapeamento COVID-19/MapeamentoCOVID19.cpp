#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;

class CovidData{
protected:
    string Nome;
    vector<string> Data;
    map<string,ll> Casos;
    map<string,ll> Obitos;
public:
    CovidData(){
    }
    CovidData(string nome): Nome(nome){
    }
    void create_data(string data, string casos, string obitos){
        char* end;
        Data.push_back(data);
        Casos[data]=strtoll(casos.c_str(),&end,10);
        Obitos[data]=strtoll(obitos.c_str(),&end,10);
    }
    ll get_casos(){
        string data;
        cout << "Insira a data no formato (aaaa-mm-dd): ";
        cin >> data;
        if(Casos.find(data)==Casos.end()){
            cout << "Data Invalida" << endl;
            return 0;
        }
        cout << "Total de casos na data: " << Casos[data] << endl;
        return Casos[data];
    }
    ll get_obitos(){
        string data;
        cout << "Insira a data no formato (aaaa-mm-dd): ";
        cin >> data;
        if(Casos.find(data)==Casos.end()){
            cout << "Data Invalida" << endl;
            return 0;
        }
        cout << "Total de obitos na data: " << Obitos[data] << endl;
        return Obitos[data];
    }
    ll get_casos_janela(){
        string data1, data2;
        cout << "Insira a data inicial no formato (aaaa-mm-dd): ";
        cin >> data1;
        if(Casos.find(data1)==Casos.end()){
            cout << "Data Invalida" << endl;
            return 0;
        }
        cout << "Insira a data final no formato (aaaa-mm-dd): ";
        cin >> data2;
        if(Casos.find(data1)==Casos.end()){
            cout << "Data Invalida" << endl;
            return 0;
        }
        cout << "Total de casos na janela: " << (Casos[data2] - Casos[data1]) << endl;
        return (Casos[data2] - Casos[data1]);
    }
    ll get_obitos_janela(){
        string data1, data2;
        cout << "Insira a data inicial no formato (aaaa-mm-dd): ";
        cin >> data1;
        if(Casos.find(data1)==Casos.end()){
            cout << "Data Invalida" << endl;
            return 0;
        }
        cout << "Insira a data final no formato (aaaa-mm-dd): ";
        cin >> data2;
        if(Casos.find(data2)==Casos.end()){
            cout << "Data Invalida" << endl;
            return 0;
        }
        cout << "Total de casos na janela: " << (Obitos[data2] - Obitos[data1]) << endl;
        return (Obitos[data2] - Obitos[data1]);
    }
    float media_casos_janela(){
        string data; 
        float dias;
        float media=0;
        cout << "Insira a data no formato (aaaa-mm-dd): ";
        cin >> data;
        if(Casos.find(data)==Casos.end()){
            cout << "Data Invalida" << endl;
            return 0;
        }
        cout << "Insira o numero de dias: ";
        cin >> dias;
        auto it = find(Data.begin(), Data.end(), data);
        media = (Casos[*it] - Casos[*(it-dias+1)])/dias ;
        cout << "A media movel e: " << media << endl;
        return media;
    }
    float media_obitos_janela(){
        string data; 
        float dias;
        float media=0;
        cout << "Insira a data no formato (aaaa-mm-dd): ";
        cin >> data;
        if(Casos.find(data)==Casos.end()){
            cout << "Data Invalida" << endl;
            return 0;
        }
        cout << "Insira o numero de dias: ";
        cin >> dias;
        auto it = find(Data.begin(), Data.end(), data);
        media = (Obitos[*it] - Obitos[*(it-dias+1)])/dias ;
        cout << "A media movel e: " << media << endl;
        return media;
    }
    float crescimento_casos_janela(){
        float media1=0, media2=0, crescimento=0;
        cout << "- Primeira data de comparacao" << endl;
        media1 = media_casos_janela();
        cout << "- Segunda data de comparacao" << endl;
        media2 = media_casos_janela();
        if(media1==0){
            cout << "A tendencia de crescimento e infinita" << endl;
        } else {
            crescimento = ((media2-media1)/media1)*100;
            cout << "A tendencia de crescimento e: " << crescimento << "%" << endl;
        }
        return 0;
    }
    float crescimento_obitos_janela(){
        float media1=0, media2=0, crescimento=0;
        cout << "- Primeira data de comparacao" << endl;
        media1 = media_obitos_janela();
        cout << "- Segunda data de comparacao" << endl;
        media2 = media_obitos_janela();
        if(media1==0){
            cout << "A tendencia de crescimento e infinita" << endl;
        } else {
            crescimento = ((media2-media1)/media1)*100;
            cout << "A tendencia de crescimento e: " << crescimento << "%" << endl;
        }
        return 0;
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
    bool check_municipio(string estado){
        if (Municipios.find(estado)==Municipios.end()){
            return false;
        }
        return true;
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
    bool check_estado(string estado){
        if (Estados.find(estado)==Estados.end()){
            return false;
        }
        return true;
    }
};

string regiao, estado, municipio;

void readCsv(string file, map<string,Regiao> *covidData){
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

char enterRequestGeral(){   
    char menuRequest;
    cout << "Escolha uma opcao para acessar" << endl;            
    cout << "a - Total de casos ate determinada data" << endl;
    cout << "b - Total de obitos ate determinada data" << endl;
    cout << "c - Total de casos em determinada janela" << endl;
    cout << "d - Total de obitos em determinada janela" << endl;
    cout << "e - Calculo da media movel de casos em determinada janela" << endl;
    cout << "f - Calculo da media movel de obitos em determinada janela" << endl;
    cout << "g - Calculo da tendencia de crescimento de casos entre duas medias moveis" << endl;
    cout << "h - Calculo da tendencia de crescimento de obitos entre duas medias moveis" << endl;
    cout << "i - Para voltar" << endl;
    fflush(stdin);
    cin >> menuRequest;
    if(menuRequest<97 || menuRequest>105)
        throw "Funcao invalida";
    else
        return menuRequest;
}

bool continuar(){
    char ch;
    cout<<"Pressione 'a' caso queira seguir analisando a mesma localidade ou pressione outra tecla caso queira voltar ao menu inicial"<<endl;
    fflush(stdin);
    cin>>ch;
    if(ch == 'a')
        return true; 
    return false; 
}

bool inRegiao(map<string,Regiao> covidData){   
    cout<<"Informe a regiao que sera analisada: "<<endl;
    try{
        fflush(stdin);
        cin>>regiao;
        if(covidData.find(regiao)==covidData.end()) // teste da regiao
            throw "Regiao invalida";
        return true;
    } catch(...) {   
        char ch;
        cout<<"Localidade invalida. Pressione 'a' para tentar novamente ou outra tecla para voltar."<<endl;
        fflush(stdin);
        cin>>ch;
        if(ch=='a'){
            if(inRegiao(covidData))
                return true;
            else return false;            
        }
        else return false;
    }
}

bool inEstado(map<string,Regiao> covidData){   
    cout<<"Informe a regiao a que o estado pertence:"<<endl;
    try{
        fflush(stdin);
        cin>>regiao;
        if(covidData.find(regiao)==covidData.end()) // testar o valor de entrada da regiao
            throw "Regiao invalida"; 
        cout<<"Informe o estado que deseja analisar:"<<endl;
        fflush(stdin);
        cin>>estado;
        if(!covidData[regiao].check_estado(estado)) // testar o valor de entrada do estado
            throw "Estado invalido";
        return true;
    }
    catch(...)
    {   
        char ch;
        cout<<"Localidade invalida. Pressione 'a' para tentar novamente ou outra tecla para voltar."<<endl;
        fflush(stdin);
        cin>>ch;
        if(ch=='a')
        {
            if(inEstado(covidData))
                return true;
            else return false;            
        }
        else return false;
    }
}

bool inMunicipio(map<string,Regiao> covidData){   
    cout<<"Informe a que regiao o municipio pertence:"<<endl;
    try{
        fflush(stdin);
        cin>>regiao;
        if(covidData.find(regiao)==covidData.end()) //teste regiao
            throw "Regiao invalida";
        cout<<"Informe a que estado o municipio pertence:"<<endl;
        fflush(stdin);
        cin>>estado;
        if(!covidData[regiao].check_estado(estado)) //teste estado
            throw "Estado invalido";
        cout<<"Informe o municipio que sera analisado:"<<endl;
        fflush(stdin);
        cin>>municipio;
        if(!covidData[regiao].get_estado(estado).check_municipio(municipio)) //teste municipio
            throw "Municipio invalido";
        return true;
    }
    catch(...)
    {   
        char ch;
        cout<<"Localidade invalida. Pressione 'a' para tentar novamente ou outra tecla para voltar."<<endl;
        fflush(stdin);
        cin>>ch;
        if(ch=='a')
        {
            if(inMunicipio(covidData))
                return true;
            else return false;            
        }
        else return false;
    }
}

void MenuRegiao(map<string,Regiao> covidData){
    char request;
    do{   
        try{
            request = enterRequestGeral();
            switch(request){
                case 'a':
                    covidData[regiao].get_casos();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'b':
                    covidData[regiao].get_obitos();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'c':
                    covidData[regiao].get_casos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'd':
                    covidData[regiao].get_obitos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'e':
                    covidData[regiao].media_casos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'f':
                    covidData[regiao].media_obitos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'g':
                    covidData[regiao].crescimento_casos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'h':
                    covidData[regiao].crescimento_obitos_janela();
                    if(!continuar())
                        request = 'i';
                    break;
            }
        } catch(...) {
            cout<<"Funcao invalida. Tente novamente."<<endl;
        }        
    } while(request!='i');
}

void MenuEstado(map<string,Regiao> covidData){
    char request;
    do {   
        try{
            request = enterRequestGeral();
            switch(request)
            {
                case 'a':
                    covidData[regiao].get_estado(estado).get_casos();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'b':
                    covidData[regiao].get_estado(estado).get_obitos();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'c':
                    covidData[regiao].get_estado(estado).get_casos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'd':
                    covidData[regiao].get_estado(estado).get_obitos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'e':
                    covidData[regiao].get_estado(estado).media_casos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'f':
                    covidData[regiao].get_estado(estado).media_obitos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'g':
                    covidData[regiao].get_estado(estado).crescimento_casos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'h':
                    covidData[regiao].get_estado(estado).crescimento_obitos_janela();
                    if(!continuar())
                        request = 'i';
                    break;
            }
        } catch(...) {
            cout<<"Funcao invalida. Tente novamente."<<endl;
        }        
    } while(request!='i');
}

void MenuMunicipio(map<string,Regiao> covidData){
    char request;
    do {   
        try{
            request = enterRequestGeral();
            switch(request)
            {
                case 'a':
                    covidData[regiao].get_estado(estado).get_municipio(municipio).get_casos();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'b':
                    covidData[regiao].get_estado(estado).get_municipio(municipio).get_obitos();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'c':
                    covidData[regiao].get_estado(estado).get_municipio(municipio).get_casos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'd':
                    covidData[regiao].get_estado(estado).get_municipio(municipio).get_obitos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'e':
                    covidData[regiao].get_estado(estado).get_municipio(municipio).media_casos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'f':
                    covidData[regiao].get_estado(estado).get_municipio(municipio).media_obitos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'g':
                    covidData[regiao].get_estado(estado).get_municipio(municipio).crescimento_casos_janela();
                    if(!continuar())
                        request = 'i';
                    break;

                case 'h':
                    covidData[regiao].get_estado(estado).get_municipio(municipio).crescimento_obitos_janela();
                    if(!continuar())
                        request = 'i';
                    break;
            }
        } catch(...) {
            cout<<"Funcao invalida. Tente novamente."<<endl;
        }        
    } while(request!='i');
}

char enterRequest(){   
    char req;
    cout<<"Informe o tipo de localidade que deseja acessar:"<<endl;
    cout<<"a - Regiao" <<endl;
    cout<<"b - Estado" <<endl;
    cout<<"c - Municipio" <<endl;
    cout<<"d - Para sair do programa"<<endl;
    fflush(stdin);
    cin>>req;
    if(req<97 || req>100)
        throw "Localidade invalida";
    else return req;
}

void Menu(map<string,Regiao> covidData){
    char request;
    do {   
        try{
                request = enterRequest();
                switch(request)
                {
                    case 'a':
                        cout<<"Acesso a uma regiao"<<endl;
                        if(inRegiao(covidData))
                            MenuRegiao(covidData);                     
                        break;

                    case 'b':
                        cout<<"Acesso a um estado"<<endl;
                        if(inEstado(covidData))
                            MenuEstado(covidData);
                        break;

                    case 'c':
                        cout<<"Acesso a um municipio"<<endl;
                        if(inMunicipio(covidData))
                            MenuMunicipio(covidData);
                        break;
                }
            }
            catch(...){
                cout<<"Localidade invalida. Tente novamente."<<endl;
            }
    }while(request!='d');
}

int main(){
    string file = "teste.csv";
    map<string,Regiao> covidData;

    cout << "CENTRAL DE MAPEAMENTO DO COVID-19" << "\n- Ultima Atualizacao: "; 
    for(int i=27; i<36; i++){
        cout << file[i];
    }
    cout << endl;
    readCsv(file, &covidData);

    Menu(covidData);
}
