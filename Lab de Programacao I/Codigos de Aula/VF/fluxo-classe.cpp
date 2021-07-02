#include <iostream>
#include <set>
using namespace std;

class T{
    int x;
    set<int> X;
public:
    ostream *pos;
    T(int x): x(x), pos(NULL){
        X.insert(x);
    }
    ~T(){
    }
    T& operator<<(T t){
        X.insert(t.x);
        return *this;
    }
    T& operator>>(T t){
        X.insert(t.x);
        return *this;
    }
    T& operator>>(ostream& out){
        pos = &out;
        return *this;
    }
    T& operator<<(const char &c){
        for(auto it=X.begin(); it != X.end(); it++){
            *pos << *it << " ";
        }
        *pos << c;
    }

};

int main(){
    int a,b,c,d;
    cin >> a >> b >> c >> d;
    T(a) << T(b) >> cout >> T(c) << T(d) << '\n';
    return 0;
}