/*
EXERCICIO 3:
[aluno@labdefcluster2021 mayara]$ mpirun -np 4 ex3
Matrix =
0 0 0 0
1 1 1 1
2 2 2 2
3 3 3 3
*/

#include <mpi.h>
#include <stdio.h>

main(int argc, char *argv[]) {
    int npes, myrank, i, j;
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &npes);
    MPI_Comm_rank(MPI_COMM_WORLD, &myrank);

    int arr[4]={myrank,myrank,myrank,myrank}, mat[4][4];

    MPI_Gather(&arr,4,MPI_INT,&mat,4,MPI_INT,0,MPI_COMM_WORLD);

    MPI_Barrier(MPI_COMM_WORLD);
    if(myrank==0){
        printf("Matrix =\n");
        for(i=0; i<4; i++ ){
            for(j=0; j<4; j++ )
                printf ("%d ", mat[i][j]);
            printf("\n");
        }
    }

    MPI_Finalize();
}