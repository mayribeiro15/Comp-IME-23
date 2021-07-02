#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#include <vector>
using namespace std;

class Image{
    string arqName;
    vector<vector<int>> matriz;
public:
    Image(string arqName): arqName(arqName){
    }
    void ler(){
        ifstream arq(arqName);   
            if (arq.good()){
            string s;  
            getline(arq,s);
            int n = stoi(s);

            char c;
            for(int i=0;i<n;i++){
                vector<int> v;
                for(int j=0;j<n;j++){
                    arq.get(c);
                    v.push_back(c);
                }
                matriz.push_back(v);
            }
            arq.close();
        }
    }
    void imprimir(){
        int n = matriz.size();
        int asciivalue = 219;
        char c, p=asciivalue;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                c = matriz[i][j];
                if(c=='1') cout << p;
                else cout << " ";
                if((i*n+j)%n==n-1) cout << endl;
            }
        }
    }
};

int main(){
    Image Img("img.txt");
    Img.ler();
    Img.imprimir();
    return 0;
}