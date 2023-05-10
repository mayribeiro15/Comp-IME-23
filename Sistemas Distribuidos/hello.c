#include <mpi.h>
#include <stdio.h>

main(int argc, char *argv[]) {
    int npes, myrank, namelen;
    char nome[MPI_MAX_PROCESSOR_NAME];
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &npes);
    MPI_Comm_rank(MPI_COMM_WORLD, &myrank);
    MPI_Get_processor_name(nome, &namelen);
    printf("From process %d (%s) out of %d, Hello World!\n", myrank, nome, npes);
    MPI_Finalize();
}