#include <stdio.h>
#include <stdlib.h>

int main(){
    char palavra[50],c;
    int i,j=0;
    FILE *arquivo;

    arquivo = fopen("slide69.txt","w");
    if(!arquivo)
    	printf("Erro na abertura do arquivo!");

    gets(palavra);
    for(i=0;palavra[i];i++)
        putc(palavra[i],arquivo);
    fclose(arquivo);

    arquivo = fopen("slide69.txt","r");
    i=0;
    while (!feof(arquivo)){
		c=getc(arquivo);
        printf("%c",c);
        if(c=!palavra[i])
            j++;
        i++;
	}
    if(j>1)
        printf("\nPalavra gravada incorretamente!");
    else
        printf("\nPalavra gravada corretamente!");
    fclose(arquivo);
}