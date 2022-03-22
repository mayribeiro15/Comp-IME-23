#include <stdio.h>

int x,y,*z;
unsigned int k1,k2;
char c1;
unsigned char c2;
int w[4];

int main(){ 
    asm("mov ecx,200\n"
    "mov eax, DWORD PTR _z\n"
    "mov edi,eax\n"
    "mov eax,0\n"
    "rep stosd\n"
    "mov eax, 0"
    :"=r" (z)
    :"r" (z)
    :"%ebx");

    printf("%d",z);

    return 0;
}