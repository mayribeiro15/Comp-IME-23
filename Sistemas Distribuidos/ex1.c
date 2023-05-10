/*
EXERCICIO 1:
[aluno@labdefcluster2021 mayara]$ mpirun -np 4 ex1
Colors received: gggg
Colors received: wrwr
*/

#include <mpi.h>
#include <stdio.h>

main(int argc, char *argv[]) {
    int npes, myrank;
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &npes);
    MPI_Comm_rank(MPI_COMM_WORLD, &myrank);

    char colors[3], color, rcv_colors[4];
    if(myrank==0){
        colors[0]='w';
        colors[1]='r';
        colors[2]='g';
    }

    MPI_Bcast(colors,3,MPI_CHAR,0,MPI_COMM_WORLD);

    color=colors[2];
    MPI_Send(&color,1,MPI_CHAR,0,1,MPI_COMM_WORLD);

    MPI_Barrier(MPI_COMM_WORLD);
    if(myrank==0){
        MPI_Recv(&rcv_colors[0],1,MPI_CHAR,0,1,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        MPI_Recv(&rcv_colors[1],1,MPI_CHAR,1,1,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        MPI_Recv(&rcv_colors[2],1,MPI_CHAR,2,1,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        MPI_Recv(&rcv_colors[3],1,MPI_CHAR,3,1,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        printf("Colors received: %s\n",rcv_colors);
    }

    color=colors[myrank%2];
    MPI_Send(&color,1,MPI_CHAR,0,1,MPI_COMM_WORLD);

    MPI_Barrier(MPI_COMM_WORLD);
    if(myrank==0){
        MPI_Recv(&rcv_colors[0],1,MPI_CHAR,0,1,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        MPI_Recv(&rcv_colors[1],1,MPI_CHAR,1,1,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        MPI_Recv(&rcv_colors[2],1,MPI_CHAR,2,1,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        MPI_Recv(&rcv_colors[3],1,MPI_CHAR,3,1,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        printf("Colors received: %s\n",rcv_colors);
    }

    MPI_Finalize();
}