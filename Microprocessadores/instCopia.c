#include <stdio.h>

int x,y,*z;
unsigned int k1,k2;
char c1;
unsigned char c2;
int w[4];

int main(){ 
    x=30;
    y=x;
    w[1]=y;

    z=&y;
    *z=x;
    z[4]=10;

    return 0;
}