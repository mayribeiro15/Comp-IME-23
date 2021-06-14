#include <stdio.h>
#include <stdlib.h>

int main(){
    float *vetor,n,ans=0;
    int i;
    scanf("%f",&n);
    vetor = malloc(n*sizeof(int));
    for(i=0;i<n;i++){
        scanf("%f",&vetor[i]);
        ans+=vetor[i];
    }
    ans=ans/n;
    printf("%.2f",ans);
    return 0;    
}