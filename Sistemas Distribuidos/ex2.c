/*
EXERCICIO 2:
[aluno@labdefcluster2021 mayara]$ mpirun -np 4 ex2
Node = 0 / Array = 0 0 0 0
Node = 1 / Array = 1 1 1 1
Node = 2 / Array = 2 2 2 2
Node = 3 / Array = 3 3 3 3
*/

#include <mpi.h>
#include <stdio.h>

main(int argc, char *argv[]) {
    int npes, myrank, i, j;
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &npes);
    MPI_Comm_rank(MPI_COMM_WORLD, &myrank);

    int arr[4], mat[4][4]={{0,0,0,0},{1,1,1,1},{2,2,2,2},{3,3,3,3}};

    MPI_Scatter(&mat,4,MPI_INT,&arr,4,MPI_INT,0,MPI_COMM_WORLD);

    MPI_Barrier(MPI_COMM_WORLD);
    printf("Node = %d / Array = %d %d %d %d\n", myrank,arr[0],arr[1],arr[2],arr[3]);

    MPI_Finalize();
}