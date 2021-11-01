#include <iostream>
#include <iomanip>
#include <fstream>
#include <sstream>
#include <vector>
#include <map>
using namespace std;

struct Row{
    vector<float> numbers;
    string word;
};

void operator>>(Row &row, string line){
    string data;
    stringstream ss(line);

    for(int i=0;i<5;i++){
        getline(ss, data, ',');
        if(i<4)
            (row.numbers).push_back(stof(data));
        else row.word = data;
    }
}

class DataSet{
    vector<Row> Data;
public:
    DataSet(string fileName){
        ifstream arqData(fileName);
        if (!arqData.is_open()){
            return;
        }

        string line;
        Row row;
        while (arqData.good()){
            arqData >> line;
            if(line=="\0") break;
            row >> line;
            Data.push_back(row);
        }

        arqData.close();
    }
    void media(){
        vector<float> medias={0,0,0,0};
        int total=0;

        vector<Row>::const_iterator it;
        for(it=Data.begin(); it!=Data.end(); it++){
            for(int i=0;i<4;i++){
                medias[i]+=(*it).numbers[i];
            }
            total++;
        }


        cout << "Medias:" << endl;
        vector<float>::const_iterator jt;
        for(jt=medias.begin(); jt!=medias.end(); jt++){
            float media = (*jt)/total;
            cout << setprecision(2) << media << " ";
        }
        cout << endl;

    }
    void contagem(){
        map<string,int> count;
        
        vector<Row>::const_iterator it;
        for(it=Data.begin(); it!=Data.end(); it++){
            count[(*it).word]++;
        }

        cout << "Contagem:" << endl;
        map<string,int>::const_iterator jt;
        for(jt=count.begin(); jt!=count.end(); jt++){
            cout << (*jt).first << ": " << (*jt).second << endl;
        }
    }
};

int main(){
    DataSet IrisData("iris.data");
    IrisData.contagem();
    IrisData.media();
}
