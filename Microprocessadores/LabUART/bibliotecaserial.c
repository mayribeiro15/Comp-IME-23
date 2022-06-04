#include <windows.h>
#include <stdio.h>
#include <conio.h>
#include <string.h>



void cria_terminal(void) {
  STARTUPINFO st;
  PROCESS_INFORMATION pi;
  st.cb=sizeof(STARTUPINFO);st.lpReserved=NULL;st.lpReserved2=NULL;
  st.cbReserved2=0;st.lpDesktop=NULL;st.dwFlags=0;
  CreateProcess(NULL,"comando.bat",NULL,NULL,FALSE,0,NULL,NULL,&st,&pi);
}

void le_linha_arq(FILE *arq);
char linha[5000];
char portas[10][2][100];
int tamanholinha;
char caracter,*caption;
int procura,indice,numporta,cont;

void gera_lista_serial(void) {
  FILE *arq;
  arq = fopen("terminal.txt","rb");
  le_linha_arq(arq);
  for(procura=0;procura<tamanholinha-7;procura++) {
    caption=&(linha[procura]);
    if (strncmp(caption,"Caption",7)==0) {
      indice=procura;
      procura=tamanholinha;
    }
  }
  for(numporta=0;numporta<10;numporta++) {
    strcpy(portas[numporta][0],"");
    strcpy(portas[numporta][1],"");
    le_linha_arq(arq);
    if (tamanholinha>indice+30) {
      procura=indice; cont=0;
      do {
        caracter=linha[procura++];
        if (caracter != '(') { portas[numporta][1][cont++]=caracter; portas[numporta][1][cont]=0; }
      } while (caracter != '(');
      cont=0;
      do {
        caracter=linha[procura++];
        if (caracter != ')') { portas[numporta][0][cont++]=caracter; portas[numporta][0][cont]=0; }
      } while (caracter != ')');
      printf("%s %s \n",portas[numporta][0],portas[numporta][1]);
    }
  }
}

void le_linha_arq(FILE *arq) {
  int flagEOF,flagCR,flagLF;
  flagEOF = feof(arq); flagCR = 0; flagLF = 0; tamanholinha = 0;
  while( (!flagEOF) && ( (!flagCR) || (!flagLF) ) ) {
    fread(&caracter,1,1,arq);
    if (caracter==0x0A) flagCR=1;
      else if (caracter==0x0D) flagLF=1;
        else if ((caracter>0)||(caracter<-2)) linha[tamanholinha++]=caracter;
    flagEOF = feof(arq);
  }
  linha[tamanholinha++]=0;
}

void seriais(void) {
  cria_terminal();
  printf("\nArquivo terminal.txt gerado. Tecle algo para continuar.\n");
  getch();
  gera_lista_serial();
  getch();
  /* retorna matriz em "char portas[10][2][100]" */
}

HANDLE handle_serial=NULL;
/* Rotina para inicializar a porta serial. Retorna TRUE,
   se for executada com sucesso, ou FALSE, se falhar */
BOOL inicializa_uart(char *porta 	/* porta de comunicacao */,int BaudRate /* 9600, 115200, etc. */)
{
  COMMTIMEOUTS timeoutespera;
  DCB DCBrs232win;	/* declaracao da estrurura DCB para inicializacao da porta serial */
  BYTE ByteSize=8;	/* tamanho do caracter: 5 a 8 */
  BYTE StopBits=ONESTOPBIT;	/* numero de Stop Bits: ONESTOPBIT, ONE5STOPBITS ou TWOSTOPBITS */
  BYTE Parity=NOPARITY;	/* paridade: NOPARITY, MARKPARITY, EVENPARITY ou ODDPARITY */
  int timeout=100;		/* timeout, em milissegundos */
  CloseHandle(handle_serial);
  handle_serial=INVALID_HANDLE_VALUE;
  handle_serial= CreateFile(porta,GENERIC_READ|GENERIC_WRITE,0,NULL,OPEN_EXISTING,0,NULL);
  if (handle_serial==INVALID_HANDLE_VALUE) return(FALSE);
  timeoutespera.ReadIntervalTimeout=timeout;
  timeoutespera.ReadTotalTimeoutMultiplier=timeout;
  timeoutespera.ReadTotalTimeoutConstant=0;
  timeoutespera.WriteTotalTimeoutMultiplier=timeout;
  timeoutespera.WriteTotalTimeoutConstant=0;
  SetCommMask(handle_serial,EV_RXCHAR|EV_TXEMPTY|EV_ERR);
  SetCommTimeouts(handle_serial,&timeoutespera);
  GetCommState(handle_serial,&DCBrs232win);
  DCBrs232win.BaudRate=BaudRate;	/* 2400, 9600, 144400, etc. */
  DCBrs232win.ByteSize=ByteSize;	/* 5, 6, 7 ou 8 */
  DCBrs232win.Parity=Parity;			/* NOPARITY, MARKPARITY, EVENPARITY ou ODDPARITY */
  DCBrs232win.StopBits=StopBits;	/* ONESTOPBIT, ONE5STOPBITS ou TWOSTOPBITS */
  if (SetCommState(handle_serial,&DCBrs232win)) return(TRUE);
  else return(FALSE);
}

/* Rotina para liberar o uso da porta serial */
void libera_uart(void)
{
  CloseHandle(handle_serial);
}

/* Rotina para transmitir um caracter pela porta serial */
BOOL envia_caracter_uart(char *caracter)
{
  int checatransmissao;
  BOOL status;
  status=WriteFile(handle_serial,caracter,1,(LPDWORD)(&checatransmissao),NULL);
  if ((status==TRUE) && (checatransmissao==1)) return(TRUE);
  return(FALSE);
}

/* Rotina para receber um caracter pela porta serial */
BOOL recebe_caracter_uart(char *caracter)
{
  int checatransmissao;
  BOOL status;
  status=ReadFile(handle_serial,caracter,1,(LPDWORD)(&checatransmissao),NULL);
  if ((status==TRUE) && (checatransmissao==1)) return(TRUE);
  return(FALSE);
}

void main (void){
  int i;
  char bytechar=0,byterecebido;
  seriais();
  for (i=0;i<10;i++) 
    if (strncmp(portas[i][1],"Silicon Labs CP210x USB to UART Bridge",38)==0)
      inicializa_uart(portas[i][0],9600);
  while (bytechar != 0x1B) {   /* transmite e recebe até ESC */
    if (kbhit()) {
      bytechar = getch();
      if (bytechar != 0x1B) {
        envia_caracter_uart(&bytechar);
        if (bytechar==0x0D) printf("\n");
        else printf("%c",bytechar);
      }
    }
    if (recebe_caracter_uart(&byterecebido)) printf("%c",byterecebido);
  }

  libera_uart();
}