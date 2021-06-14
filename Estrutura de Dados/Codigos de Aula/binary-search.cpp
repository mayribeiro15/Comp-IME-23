#include <bits/stdc++.h>
using namespace std;

int binary_search (int x, int i, int f, vector<int> v){
    int m, targ;
    while (i<=f){
        targ=(f+i)/2;
        if(x==v[targ]) return targ;
        if(x<v[targ]) f=targ-1;
        if(v[targ]<x) i=targ+1;
    }
    return -1;
}

int main(){
    int n, x;
    vector<int> v;
    cin >> n;
    for(int i=0;i<n;i++){
        cin >> x;
        v.push_back(x);
    }
    cin >> x;
    sort(v.begin(), v.end());
    int pos = binary_search(x,0,n,v);
    cout << pos;
    return 0;
}