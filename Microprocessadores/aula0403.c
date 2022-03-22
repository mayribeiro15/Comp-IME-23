#include <stdio.h>

int x,y,*z;
unsigned int k1,k2;
char c1;
unsigned char c2;
int w[4];

int main(){ 
    x=x+y;
    x=x-y;
    x+=y;
    x-=y;
    y=x^30;
    y=x&30;
    y=x|30;
    y=~x;
    y=-x;
    x++;
    x+=1;
    x--;
    y=x++;
    x-=1;
    y=x++;
    y=++x;
    x=x*y;
    x=x/y;
    k1=k1*k2;
    k1=k1/k2;

    z[x]=y;

    c1=(x>y);
    c2=(k1>=k2);
    c1=(x<=y);
    c2=(k1<k2);
    c1=(x!=y);

    x=y<<3;
    x=y>>3;
    x=y<<x;
    x=y>>x;

    return 0;
}