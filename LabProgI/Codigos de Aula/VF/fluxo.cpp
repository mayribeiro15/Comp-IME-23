#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
using namespace std;

int main(){
    int x;
    cin >> x;
    cout << hex << x << endl;
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