#include <iostream>
#include <string>
#include <map>
#include <iterator>
using namespace std;

int main() {
    map<string, int> freq;
    string word;

    while (cin >> word) {
        freq[word]++;
    }

    map<string, int>::const_iterator iter;
    for (iter=freq.begin(); iter != freq.end(); ++iter) {
        cout << iter->second << " " << iter->first << endl;
    }

    return 0;
}