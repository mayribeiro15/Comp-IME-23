#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int codDisciplina;
    char nomeDisciplina[50];
    char profDisciplina[50];
    int creditos;
}disciplina;
typedef struct {
    int codAluno;
    char nomeAluno[50];
    long long int cpf;
    int numDisciplinas;
    int* listaCodDisciplinas;
}aluno;
typedef struct {
    int codPeriodo;
    int numAlunos;
    int numDisciplinas;
    aluno* listaAlunosCadastrados;
    disciplina* listaDisciplinasCadastradas;
}periodo;

periodo *listaPeriodos = NULL;
int numPeriodos = 0;

int ProcuraElemento (int codigo, int indice_periodo, char elemento){
    int i;

    if (elemento == 'A'){
        for(i = 0; i < listaPeriodos[indice_periodo].numAlunos; i++){
            if(listaPeriodos[indice_periodo].listaAlunosCadastrados[i].codAluno == codigo){
                return i;
            }
        }
        return -1;
    }

    else if (elemento == 'D'){
        for(i = 0; i < listaPeriodos[indice_periodo].numDisciplinas; i++){
            if(listaPeriodos[indice_periodo].listaDisciplinasCadastradas[i].codDisciplina == codigo){
                return i;
            }
        }
        return -1;
    }
}

int ProcuraPeriodo(int periodo){
    int i;
    for(i=0;i<numPeriodos;i++){
        if(listaPeriodos[i].codPeriodo == periodo){
            return i;
        }
    }
    return -1;
}

void CadastrarAluno(){
    int codPeriodo;
    int i;
    long long int cpf;
    int codAluno;
    char nomeAluno[50];
    int numDisciplinas;
    int codDisciplina;
    int* listaCodDisciplinas;
    int status;
    int indice_periodo;

    printf("\n------ Cadastro de Aluno ------ \n");

    printf("Digite as informacoes abaixo:\n");
    printf("Qual o periodo (Ex: 20211)? ");
    scanf("%d", &codPeriodo);
    printf("Qual o nome do aluno? ");
    scanf(" %[^\n]s", nomeAluno);
    printf("Qual o CPF do aluno? ");
    scanf("%lld", &cpf);
    printf("Qual o codigo do aluno? ");
    scanf("%d", &codAluno);
    printf("Em quantas disciplinas o aluno sera matriculado? ");
    scanf(" %d", &numDisciplinas);

    indice_periodo = ProcuraPeriodo(codPeriodo);
    if(indice_periodo == -1){
        printf("Periodo nao encontrado!\n");
        return;
    }

    printf("Digite os codigos das disciplinas em que o aluno deve ser matriculado: \n");
    listaCodDisciplinas = (int*)malloc(numDisciplinas*sizeof(int));
    for(i = 0; i < numDisciplinas; i++){
        scanf("%d", &codDisciplina);
        if (ProcuraElemento(codDisciplina, indice_periodo, 'D') == -1){
            free(listaCodDisciplinas);
            printf("Disciplina nao cadastrada");
            return;
        }
        listaCodDisciplinas[i] = codDisciplina;
    }

    status = CadastrarAlunoArquivo(codPeriodo, cpf, codAluno, nomeAluno, numDisciplinas, listaCodDisciplinas);

    if(status == 1){
        printf("Aluno ja esta matriculado!\n");
        return;
    }
    else{
        printf("Aluno matriculado com sucesso!\n");
    }

    free(listaCodDisciplinas);
}

int CadastrarAlunoArquivo(int codPeriodo, long long int cpf, int codAluno, char nomeAluno[], int numDisciplinas, int* listaCodDisciplinas){
    int i;
    int indice_periodo;
    int indice_aluno;
    int var;


    indice_periodo = ProcuraPeriodo(codPeriodo);

    if(indice_periodo == -1){
        return -1;
    }
    var = ProcuraElemento(codAluno, indice_periodo, 'A');

    if(var != -1) {
        return 1;
    }

    listaPeriodos[indice_periodo].listaAlunosCadastrados = (aluno*)realloc(listaPeriodos[indice_periodo].listaAlunosCadastrados, (listaPeriodos[indice_periodo].numAlunos+1)*sizeof(aluno));

    indice_aluno = listaPeriodos[indice_periodo].numAlunos++;
    listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].cpf = cpf;
    listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].codAluno = codAluno;
    listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas = numDisciplinas;
    strcpy(listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].nomeAluno, nomeAluno);
    listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas = (int*)malloc(numDisciplinas*sizeof(int));

    for (i = 0; i < numDisciplinas; i++){
        listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas[i] = listaCodDisciplinas[i];
    }

    return 0;
}

int CadastrarDisciplinaArquivo(int codPeriodo, int creditos, int codDisciplina, char nomeDisciplina[], char profDisciplina[]){
    int indice_periodo;
    int indice_disciplina;
    int var;

    indice_periodo = ProcuraPeriodo(codPeriodo);

    if(indice_periodo == -1){
        return -1;
    }

    var = ProcuraElemento(codDisciplina, indice_periodo, 'D');

    if(var != -1){
        return 1;
    }


    listaPeriodos[indice_periodo].listaDisciplinasCadastradas = (disciplina*)realloc(listaPeriodos[indice_periodo].listaDisciplinasCadastradas, (listaPeriodos[indice_periodo].numDisciplinas+1)*sizeof(disciplina));

    indice_disciplina = listaPeriodos[indice_periodo].numDisciplinas++;
    listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].creditos = creditos;
    listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].codDisciplina = codDisciplina;
    strcpy(listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].nomeDisciplina, nomeDisciplina);
    strcpy(listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].profDisciplina, profDisciplina);

    return 0;
}

int CadastrarPeriodoArquivo(int codPeriodo){
    if (ProcuraPeriodo(codPeriodo) == -1){

        listaPeriodos = (periodo*)realloc(listaPeriodos, (numPeriodos+1)*sizeof(periodo));

        listaPeriodos[numPeriodos].codPeriodo = codPeriodo;
        listaPeriodos[numPeriodos].numAlunos = 0;
        listaPeriodos[numPeriodos].listaAlunosCadastrados = NULL;
        listaPeriodos[numPeriodos].numDisciplinas = 0;
        listaPeriodos[numPeriodos].listaDisciplinasCadastradas = NULL;
        numPeriodos++;
        return 0;
    }

    else
        return -1;
}

void CadastrarDisciplina(){
    int i;
    int indice_periodo;
    int indice_disciplina;
    int creditos;
    char nomeDisciplina[50];
    char profDisciplina[50];
    int codDisciplina, codPeriodo;
    int status;
    int var;

    printf("\n------ Cadastro de Disciplina ------ \n");

    printf("Digite as informacoes abaixo\n");
    printf("Qual o periodo (Ex: 20211)? ");
    scanf("%d", &codPeriodo);
    printf("Qual o codigo da disciplina? ");
    scanf("%d", &codDisciplina);
    printf("Qual o numero de creditos? ");
    scanf("%d", &creditos);
    printf("Qual o nome da disciplina? ");
    scanf(" %[^\n]s", nomeDisciplina);
    printf("Qual o nome do professor? ");
    scanf(" %[^\n]s", profDisciplina);

    indice_periodo = ProcuraPeriodo(codPeriodo);
    if(indice_periodo == -1){
        printf("Periodo nao cadastrado!\n");
        return;
    }
    var = ProcuraElemento(codDisciplina, indice_periodo, 'D');
    if(var != -1){
        printf("Disciplina ja cadastrada!\n");
        return;
    }

    listaPeriodos[indice_periodo].listaDisciplinasCadastradas = (disciplina*)realloc(listaPeriodos[indice_periodo].listaDisciplinasCadastradas, (listaPeriodos[indice_periodo].numDisciplinas+1)*sizeof(disciplina));
    indice_disciplina = listaPeriodos[indice_periodo].numDisciplinas++;
    listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].creditos = creditos;
    listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].codDisciplina = codDisciplina;
    strcpy(listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].nomeDisciplina, nomeDisciplina);
    strcpy(listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].profDisciplina, profDisciplina);
    printf("A disciplina foi cadastrada!\n");
}

void CadastrarPeriodo(){
    int status;
    int codPeriodo;

    printf("Digite as informacoes abaixo:\n");
    printf("Qual o periodo (Ex: 20211)? ");
    scanf("%d", &codPeriodo);
    status = CadastrarPeriodoArquivo(codPeriodo);
    if(status == -1){
        printf("Esse periodo ja se encontra cadastrado!\n");
        return;
    }
    printf("Novo periodo cadastrado.");
}

void CadastrarDisciplinaAluno(){
    int i;
    int codPeriodo;
    int codAluno, codDisciplina;
    int indiceUltimo, indiceAluno, indiceDisciplina, indicePeriodo;

    printf("\n------ Cadastro de Aluno em Disciplina ------");

    printf("\nDigite as informacoes abaixo:");
    printf("\nDe qual periodo (ex.: 20211)? ");
    scanf("%d",&codPeriodo);
    printf("\nQual o codigo do aluno? ");
    scanf("%d",&codAluno);
    printf("\nQual o codigo da disciplina? ");
    scanf("%d",&codDisciplina);

    indicePeriodo=ProcuraPeriodo(codPeriodo);
    if(indicePeriodo==-1){
        printf("\nPeriodo nao cadastrado!");
        return;
    }

    indiceAluno = ProcuraElemento(codAluno, indicePeriodo, 'A');

    if(indiceAluno==-1){
        printf("\nAluno nao cadastrado no periodo inserido!");
        return;
    }

    indiceDisciplina = ProcuraElemento(codDisciplina, indicePeriodo, 'D');

    if(indiceDisciplina==-1){
        printf("\nDisciplina nao cadastrada no periodo inserido!");
        return;
    }

    listaPeriodos[indicePeriodo].listaAlunosCadastrados[indiceAluno].listaCodDisciplinas = (int*)realloc(listaPeriodos[indicePeriodo].listaAlunosCadastrados[indiceAluno].listaCodDisciplinas, (listaPeriodos[indicePeriodo].listaAlunosCadastrados[indiceAluno].numDisciplinas+1)*sizeof(int));
    indiceUltimo = listaPeriodos[indicePeriodo].listaAlunosCadastrados[indiceAluno].numDisciplinas++;
    listaPeriodos[indicePeriodo].listaAlunosCadastrados[indiceAluno].listaCodDisciplinas[indiceUltimo]=codDisciplina;

    printf("Aluno cadastrado na disclipina com sucesso!");
}

void RemoverAluno(){
    int codAluno;
    int codPeriodo;
    int i;
    int indice_periodo;
    int indice_aluno;
    int ultimo_indice;

    printf("\n------ Remocao de Aluno ------ \n");

    printf("Digite as informacoes abaixo:\n");
    printf("Qual o periodo (Ex: 20211)? ");
    scanf("%d", &codPeriodo);
    printf("Qual o codigo do aluno? ");
    scanf("%d", &codAluno);

    indice_periodo = ProcuraPeriodo(codPeriodo);

    if(indice_periodo == -1){
        printf("Periodo nao cadastrado!\n");
        return;
    }

    indice_aluno = ProcuraElemento(codAluno, indice_periodo, 'A');

    if(indice_aluno == -1){
        printf("Aluno nao cadastrado no periodo inserido!\n");
        return;
    }

    ultimo_indice = listaPeriodos[indice_periodo].numDisciplinas-1;
    free(listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas);

    if(ultimo_indice != indice_aluno){
        listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].cpf = listaPeriodos[indice_periodo].listaAlunosCadastrados[ultimo_indice].cpf;
        listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].codAluno = listaPeriodos[indice_periodo].listaAlunosCadastrados[ultimo_indice].codAluno;
        listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas = listaPeriodos[indice_periodo].listaAlunosCadastrados[ultimo_indice].numDisciplinas;
        strcpy(listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].nomeAluno, listaPeriodos[indice_periodo].listaAlunosCadastrados[ultimo_indice].nomeAluno);
        listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas = listaPeriodos[indice_periodo].listaAlunosCadastrados[ultimo_indice].listaCodDisciplinas;
    }
    listaPeriodos[indice_periodo].listaAlunosCadastrados = (aluno*)realloc(listaPeriodos[indice_periodo].listaAlunosCadastrados, (listaPeriodos[indice_periodo].numAlunos-1)*sizeof(aluno));
    listaPeriodos[indice_periodo].numAlunos--;

    printf("Aluno removido com sucesso!\n");
}

void RemoverDisciplina(){
    int codDisciplina;
    int codPeriodo;
    int i;
    int indice_periodo;
    int indice_disciplina;
    int ultimo_indice;

    printf("\n------ Remocao de Disciplina ------ \n");

    printf("Digite abaixo os dados da disciplina que voce deseja remover do sistema:\n");
    printf("De qual periodo (ex.20211)? ");
    scanf("%d", &codPeriodo);
    printf("Qual o codigo da disciplina? ");
    scanf("%d", &codDisciplina);

    indice_periodo = ProcuraPeriodo(codPeriodo);

    if(indice_periodo == -1){
        printf("Periodo nao cadastrado!\n");
        return;
    }

    indice_disciplina = ProcuraElemento(codDisciplina, indice_periodo, 'D');

    if(indice_disciplina == -1){
        printf("Disciplina nao cadastrada no periodo inserido!\n");
        return;
    }

    for(i=0; i<listaPeriodos[indice_periodo].numAlunos;i++){
        DescadastrarDisciplinaAlunoArquivo(codPeriodo,codDisciplina,listaPeriodos[indice_periodo].listaAlunosCadastrados[i].codAluno);
    }

    ultimo_indice = listaPeriodos[indice_periodo].numDisciplinas - 1;
    if(ultimo_indice != indice_disciplina){
        listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].codDisciplina = listaPeriodos[indice_periodo].listaDisciplinasCadastradas[ultimo_indice].codDisciplina;
        strcpy(listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].nomeDisciplina, listaPeriodos[indice_periodo].listaDisciplinasCadastradas[ultimo_indice].nomeDisciplina);
        strcpy(listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].profDisciplina, listaPeriodos[indice_periodo].listaDisciplinasCadastradas[ultimo_indice].profDisciplina);
        listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].creditos = listaPeriodos[indice_periodo].listaDisciplinasCadastradas[ultimo_indice].creditos;
    }
    listaPeriodos[indice_periodo].listaDisciplinasCadastradas = (disciplina*)realloc(listaPeriodos[indice_periodo].listaDisciplinasCadastradas, (listaPeriodos[indice_periodo].numDisciplinas-1)*sizeof(disciplina));
    listaPeriodos[indice_periodo].numDisciplinas--;

    printf("Disciplina removida com sucesso!\n");

}

void DescadastrarDisciplinaAlunoArquivo(int codPeriodo, int codDisciplina, int codAluno){
    int i;
    int indice_periodo;
    int indice_disciplina;
    int indice_aluno;
    int ultimo_indice;

    indice_periodo = ProcuraPeriodo(codPeriodo);

    if(indice_periodo == -1){
        return;
    }

    indice_aluno = ProcuraElemento(codAluno, indice_periodo, 'A');

    if(indice_aluno == -1){
        return;
    }

    indice_disciplina = ProcuraElemento(codDisciplina, indice_periodo, 'D');

    if(indice_disciplina == -1){
        return;
    }

    ultimo_indice = listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas-1;
    if(ultimo_indice != indice_disciplina){
        listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas[indice_disciplina] = listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas[ultimo_indice];
    }

    listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas--;
    listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas = (int*)realloc(listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas, (listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas)*sizeof(int));
}

void DescadastrarDisciplinaAluno(){
    int codPeriodo;
    int i;
    int indice_periodo;
    int codDisciplina;
    int indice_disciplina;
    int codAluno;
    int indice_aluno;
    int ultimo_indice;

    printf("\n------ Remocao de Aluno em Disciplina ------ \n");

    printf("Digite os dados abaixo para cancelar o cadastro\n");
    printf("Qual o periodo (Ex: 20211)? ");
    scanf("%d", &codPeriodo);
    printf("Qual o codigo do aluno? ");
    scanf("%d", &codAluno);
    printf("Qual o codigo da disciplina? ");
    scanf("%d", &codDisciplina);

    indice_periodo = ProcuraPeriodo(codPeriodo);

    if(indice_periodo == -1){
        printf("Periodo nao cadastrado!\n");
        return;
    }

    indice_aluno = ProcuraElemento(codAluno, indice_periodo, 'A');

    if(indice_aluno == -1){
        printf("Aluno nao cadastrado no periodo inserido!");
        return;
    }

    indice_disciplina = ProcuraElemento(codDisciplina, indice_periodo, 'D');

    if(indice_disciplina == -1){
        printf("Aluno nao cadastrado na disciplina!");
        return;
    }

    ultimo_indice = listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas-1;
    if(ultimo_indice != indice_disciplina){
        listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas[indice_disciplina] = listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas[ultimo_indice];
    }

    listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas--;
    listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas = (int*)realloc(listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas, (listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas)*sizeof(int));

    printf("Aluno removido da disciplina!\n");
}

void ConsultarAluno(){
    int codAluno;
    int codPeriodo;
    int i;
    int indice_periodo;
    int indice_aluno;

    printf("\n------ Consulta de Aluno ------ \n");

    printf("Digite as informacoes abaixo\n");
    printf("Qual o periodo (Ex: 20211)? ");
    scanf("%d", &codPeriodo);
    printf("Qual o codigo do aluno? ");
    scanf("%d", &codAluno);

    indice_periodo = ProcuraPeriodo(codPeriodo);

    if(indice_periodo == -1){
        printf("Esse periodo nao esta cadastrado\n");
        return;
    }

    indice_aluno = ProcuraElemento(codAluno, indice_periodo, 'A');

    if(indice_aluno == -1){
        printf("Esse aluno nao esta cadastrado no periodo que foi inserido\n");
        return;
    }

    //exibir informacoes
    printf("Dados do aluno\n");
    printf("CPF: %011lld\n", listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].cpf);
    printf("Codigo do aluno: %d\n", listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].codAluno);
    printf("Nome: %s\n", listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].nomeAluno);
    printf("Quantidade de diciplinas matriculadas: %d\n", listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas);
    printf("Codigo das disciplinas: ");
    for (i = 0; i < listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].numDisciplinas; i++){
        printf("%d ", listaPeriodos[indice_periodo].listaAlunosCadastrados[indice_aluno].listaCodDisciplinas[i]);
    }
    printf("\n");
}

void ConsultarDisciplina(){
    int codDisciplina;
    int indice_periodo;
    int indice_disciplina = -1;
    int codPeriodo;
    int i,j;

    printf("\n------ Consulta de Disciplina ------ \n");

    printf("Digite as informacoes abaixo\n");
    printf("Qual o periodo (Ex: 20211)? ");
    scanf("%d", &codPeriodo);
    printf("Qual o codigo da disciplina? ");
    scanf("%d", &codDisciplina);

    indice_periodo = ProcuraPeriodo(codPeriodo);

    if(indice_periodo == -1){
        printf("Periodo nao cadastrado!\n");
        return;
    }

    indice_disciplina = ProcuraElemento(codDisciplina, indice_periodo, 'D');
    if(indice_disciplina == -1){
        printf("Disciplina nao cadastrada no periodo inserido!\n");
        return;
    }

    printf("Dados da disciplina\n");
    printf("Numero de creditos: %d\n", listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].creditos);
    printf("Nome do curso: %s\n", listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].nomeDisciplina);
    printf("Codigo do curso: %d\n", listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].codDisciplina);
    printf("Nome do professor: %s\n", listaPeriodos[indice_periodo].listaDisciplinasCadastradas[indice_disciplina].profDisciplina);
    printf("Alunos registrados: ");
    for(i = 0; i < listaPeriodos[indice_periodo].numAlunos; i++){
        for(j = 0; j < listaPeriodos[indice_periodo].listaAlunosCadastrados[i].numDisciplinas; i++){
            if(listaPeriodos[indice_periodo].listaAlunosCadastrados[i].listaCodDisciplinas[j] == codDisciplina){
                printf("%d ", listaPeriodos[indice_periodo].listaAlunosCadastrados[i].codAluno);
                break;
            }
        }
    }
    printf("\n");
}

void Iniciar(){
    int i;
    char c;
    int tempCodPeriodo;
    int tempCodAluno, tempNumDisciplinas, tempCodDisciplina, tempCreditos;
    long long int tempCpf;
    int tempListaCodDisciplinas[25];
    char tempNomeAluno[50];
    char tempNomeDisciplina[50];
    char tempProfDisciplina[50];

    FILE *arquivo = fopen("ControleMatricula.txt", "r");
    if(!arquivo) printf("Oh no!");
    else{
        do{
            fscanf(arquivo, "%c", &c);
            switch (c){
                case 'P': //periodo
                fscanf(arquivo, "%d", &tempCodPeriodo);
                CadastrarPeriodoArquivo(tempCodPeriodo);
                break;

                case 'D': //disciplina
                fscanf(arquivo, "%d %d %d ", &tempCodPeriodo, &tempCodDisciplina, &tempCreditos);
                fscanf(arquivo, "%[^.]s", tempNomeDisciplina);
                fscanf(arquivo, ". ");
                fscanf(arquivo, "%[^\n]s", tempProfDisciplina);
                CadastrarPeriodoArquivo(tempCodPeriodo);
                CadastrarDisciplinaArquivo(tempCodPeriodo, tempCreditos, tempCodDisciplina, tempNomeDisciplina, tempProfDisciplina);
                break;

                case 'A': //aluno
                fscanf(arquivo, "%d %d %lld %d ", &tempCodPeriodo, &tempCodAluno, &tempCpf, &tempNumDisciplinas);
                fscanf(arquivo, "%[^.]s", tempNomeAluno);
                fscanf(arquivo, ". ");
                for(i=0;i<tempNumDisciplinas;i++)
                    fscanf(arquivo, "%d", &tempListaCodDisciplinas[i]);
                CadastrarPeriodoArquivo(tempCodPeriodo);
                CadastrarAlunoArquivo(tempCodPeriodo, tempCpf, tempCodAluno, tempNomeAluno, tempNumDisciplinas, tempListaCodDisciplinas);
                break;
            }
        }while(!feof(arquivo));
    }
    fclose(arquivo);
    printf("-------------------------------------------------------------\n");
    printf("Bem vindo ao Sistema de Controle de Matriculas Rodayvisnky!\n");
    printf("-------------------------------------------------------------\n");
}

void SalvarArquivo(){
    int i, j, k;
    FILE *arquivo = fopen("ControleMatricula.txt", "w");
    if(!arquivo) printf("Oh no!");
    else{
        for(i=0;i<numPeriodos;i++){
            fprintf(arquivo, "P %d\n", listaPeriodos[i].codPeriodo);

            for(j=0;j<listaPeriodos[i].numDisciplinas;j++)
                fprintf(arquivo, "D %d %d %d %s. %s\n", listaPeriodos[i].codPeriodo, listaPeriodos[i].listaDisciplinasCadastradas[j].codDisciplina, listaPeriodos[i].listaDisciplinasCadastradas[j].creditos, listaPeriodos[i].listaDisciplinasCadastradas[j].nomeDisciplina, listaPeriodos[i].listaDisciplinasCadastradas[j].profDisciplina);

            for(j=0;j<listaPeriodos[i].numAlunos;j++){
                fprintf(arquivo, "A %d %d %011lld %d %s.", listaPeriodos[i].codPeriodo, listaPeriodos[i].listaAlunosCadastrados[j].codAluno, listaPeriodos[i].listaAlunosCadastrados[j].cpf, listaPeriodos[i].listaAlunosCadastrados[j].numDisciplinas, listaPeriodos[i].listaAlunosCadastrados[j].nomeAluno);
                for(k=0;k<listaPeriodos[i].listaAlunosCadastrados[j].numDisciplinas;k++)
                    fprintf(arquivo, " %d", listaPeriodos[i].listaAlunosCadastrados[j].listaCodDisciplinas[k]);
                fprintf(arquivo,"\n");
            }
        }
        fclose(arquivo);
    }
}

void LiberarMemoria(){
    int i,j;
    for(i=0;i<numPeriodos;i++){
        free(listaPeriodos[i].listaDisciplinasCadastradas);
        for(j=0;j<listaPeriodos[i].numAlunos;j++)
            free(listaPeriodos[i].listaAlunosCadastrados[j].listaCodDisciplinas);
        free(listaPeriodos[i].listaAlunosCadastrados);
    }
}

int Menu(){
    char opcaoMenu;
    printf("\n------ MENU PRINCIPAL: -------");
    printf("\nA - Inserir Elemento");
    printf("\nB - Remover Elemento");
    printf("\nC - Consultar Elemento");
    printf("\n0 - Encerrar Programa\nOpcao Escolhida: ");
    fflush(stdin);
    scanf("%c",&opcaoMenu);

    switch (opcaoMenu){
        case 'A':
        printf("\nMENU INSERCAO:");
        printf("\nA - Inserir Novo Periodo");
        printf("\nB - Inserir Nova Disciplina");
        printf("\nC - Inserir Novo Aluno");
        printf("\nD - Inserir Disciplina em Aluno Cadastrados\nOpcao Escolhida: ");
        fflush(stdin);
        scanf("%c",&opcaoMenu);
        switch (opcaoMenu){
            case 'A':
            CadastrarPeriodo();
            break;

            case 'B':
            CadastrarDisciplina();
            break;

            case 'C':
            CadastrarAluno();
            break;

            case 'D':
            CadastrarDisciplinaAluno();
            break;

            default:
            printf("\nOpcao Invalida!");
            break;
        }
        break;

        case 'B':
        printf("\nMENU REMOCAO:");
        printf("\nA - Remover Disciplina");
        printf("\nB - Remover Aluno");
        printf("\nC - Remover Disciplina de Aluno Cadastrados\nOpcao Escolhida: ");
        fflush(stdin);
        scanf("%c",&opcaoMenu);
        switch (opcaoMenu){
            case 'A':
            RemoverDisciplina();
            break;

            case 'B':
            RemoverAluno();
            break;

            case 'C':
            DescadastrarDisciplinaAluno();
            break;

            default:
            printf("\nOpcao Invalida!");
            break;
        }
        break;

        case 'C':
        printf("\nMENU CONSULTA:");
        printf("\nA - Consultar Disciplina");
        printf("\nB - Consultar Aluno\nOpcao Escolhida: ");
        fflush(stdin);
        scanf("%c",&opcaoMenu);
        switch (opcaoMenu){
            case 'A':
            ConsultarDisciplina();
            break;

            case 'B':
            ConsultarAluno();
            break;

            default:
            printf("\nOpcao Invalida!");
            break;
        }
        break;

        case '0':
        printf("\nPrograma Encerrado!");
        return 0;
        break;

        default:
        printf("\nOpcao Invalida!");
        break;
    }

    printf("\n\nPressione 0 para Encerrar Programa ou pressione qualquer \noutra tecla para voltar ao Menu Principal.");
    fflush(stdin);
    scanf("%c",&opcaoMenu);
    if(opcaoMenu=='0'){
        printf("\nPrograma Encerrado!");
        return 0;
    }
    return 1;
}

int main(){
    int status;

    Iniciar();

    do{
        status = Menu();
    } while (status==1);
    
    SalvarArquivo();

    LiberarMemoria();
   
    return 0;
}
