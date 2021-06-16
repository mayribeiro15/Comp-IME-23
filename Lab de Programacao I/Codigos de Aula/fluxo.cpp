#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main(){
    char c;
    ifstream arq("teste.txt");
    if (arq.is_open()){
        while(arq.get(c)){
            cout << c;
        }
        arq.close();
    }
    return 0;
}