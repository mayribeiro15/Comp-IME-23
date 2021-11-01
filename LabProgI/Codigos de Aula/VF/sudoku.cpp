#include <iostream>
#include <vector>
using namespace std;

class Sudoku{
    vector<vector<int>> grid;
public:
    Sudoku(vector<vector<int>> &grid): grid(grid){
    }
    ~Sudoku(){
    }
    bool check(int n, int x, int y){
        if(n==0) return true;
        if(n>9 || n<0) return false;

        auto cel = (*(grid.begin()+x)).begin()+y;
        if(*cel!=0) return true; //checar vazio

        for(int i=0;i<9;i++){
            auto it = (*(grid.begin()+x)).begin()+i; //perc linha
            if(*it==n) return false;
            auto jt = (*(grid.begin()+i)).begin()+y; //perc col
            if(*jt==n) return false;
        }

        //perc regiao
        x = (x/3)*3;
        y = (y/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                auto kt = (*(grid.begin()+x+i)).begin()+y+j;
                if(*kt==n) return false;
            }
        }
        return true;
    }
    friend ostream &operator<<(ostream& os, const Sudoku &s){
        //vector<vector<int>>::const_iterator 
        //vector<int>::const_iterator
        for(auto it=s.grid.begin();it!=s.grid.end();it++){
            for(auto jt=(*it).begin();jt!=(*it).end();jt++){
                cout << *jt << " ";
            }
            cout << endl;
        }
    }
    bool solve(int x=0, int y=0){
        if(y==9){
            if(x==8) return true;
            else return solve(x+1,0);
        }
        auto cel = (*(grid.begin()+x)).begin()+y;
        if(*cel!=0) 
            return solve(x,y+1);
        for(int i=1; i<=9; i++){
            if(check(i,x,y)){
                *cel = i;
                if(solve(x,y+1)) return true;
                *cel = 0;
            }
        }
        return false;
    }
};

int main(){
    vector<vector<int>> inicial = {{5,3,0,0,7,0,0,0,0},
                                   {6,0,0,1,9,5,0,0,0},
                                   {0,9,8,0,0,0,0,6,0},
                                   {8,0,0,0,6,0,0,0,3},
                                   {4,0,0,8,0,3,0,0,1},
                                   {0,0,0,0,2,0,0,0,6},
                                   {0,6,0,0,0,0,2,8,0},
                                   {0,0,0,4,1,9,0,0,5},
                                   {0,0,0,0,8,0,0,7,9}};

    Sudoku S(inicial);
    cout << S;
    cout << S.check(4,0,2) << endl;
    cout << S.check(5,0,2) << endl;
    cout << S.check(2,3,3) << endl;
    S.solve();
    cout << S;
    return 0;
}
