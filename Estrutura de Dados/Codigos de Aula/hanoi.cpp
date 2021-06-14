#include <bits/stdc++.h>
using namespace std;

const int MAX=1e9+7;

int hanoi(int n){
	int m;
	if(n==1) return m=1;
	else m=(1+2*hanoi(n-1))%MAX;
	return m;
}

int main(){
	int n;
	cin >> n;
	cout << hanoi(n);

	return 0;
}

