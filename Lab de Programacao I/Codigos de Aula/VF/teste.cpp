#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

float gen_mms(vector<float> valores, int x){
    static float i = 0;
    valores[i]=x;
    return ++i;
}

int main(){
    vector<float> valores={1,2,3,4,5};
    vector<float> mms(4);
    int x=0;
    generate_n(mms.begin(), 4, gen_mms(valores,x));
  
    vector<float>::iterator it;
    for (it = mms.begin(); it != mms.end(); ++it) {
        cout << *it << " ";
    }
    return 0;
}