#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

#define ARRAY_SIZE 1000000

unsigned long int array_sum(const unsigned long int *values, int n_values) {
    unsigned long int total = 0;
    for (int index = 0; index < n_values; index++) {
        total += values[index];
    }

    return total;
}

int main(int argc, char *argv[]) {
    int n_ps, rank, name_length;
    struct timeval start_time, finish_time;
    char name[MPI_MAX_PROCESSOR_NAME];

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &n_ps);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Get_processor_name(name, &name_length);

    unsigned long int *values, *total, *subtotal;
    unsigned long int n_values = ARRAY_SIZE / n_ps;
    unsigned long int *values_to_sum = malloc(sizeof(unsigned long int) * n_values);

    if (rank == 0) {
        values = malloc(sizeof(unsigned long int) * ARRAY_SIZE);

        unsigned long int index = 0;
        while (index < ARRAY_SIZE) {
            values[index] = index + 1;
            index++;
        }
    }

    gettimeofday(&start_time, NULL);

    if (n_ps > 0) {
        MPI_Scatter(&values, n_values, MPI_UNSIGNED_LONG, &values_to_sum, n_values, MPI_UNSIGNED_LONG, 0, MPI_COMM_WORLD)

        subtotal[0] = array_sum(values_to_sum, n_values);

        printf("Subtotal in process %d (%s) is: %lu\n", rank, name, subtotal[0]);

        MPI_Reduce(&subtotal, &total, 1, MPI_UNSIGNED_LONG, MPI_SUM, 0, MPI_COMM_WORLD);
    } else {
        total[0] = array_sum(values_to_sum, n_values);
    }

    if (rank == 0) {
        printf("Total sum: %lu", total[0]);
    }

    gettimeofday(&finish_time, NULL);
    printf("time elapsed: %ld seconds and %d micro seconds.",
           finish_time.tv_sec - start_time.tv_sec,
           finish_time.tv_usec - start_time.tv_usec);

    MPI_Finalize();
}