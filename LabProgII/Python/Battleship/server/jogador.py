class Jogador:
    def __init__(self, id):
        self.id = id
        self.campoJogador = gerar_matriz(10,10)
        self.campoAdversario = gerar_matriz(10,10)
        self.totalAbatidos = 0
        self.totalRestante = 0

    def posicionarNavio(self,x,y):
        if(self.campoJogador[x][y]=='1'):
            print("--> Posição ocupada, tente novamente!\n")
            return False
        self.campoJogador[x][y]='1'
        print("J %d --> Barco adicionado em (%d,%d)\n" % (self.id,x,y))
        self.totalRestante+=1
        return True

    def atingirJogador(self, x,y):
        if(self.campoJogador[x][y]=='1'):
            self.totalAbatidos+=1
            self.totalRestante-=1
            self.campoJogador[x][y]='X'
            return True
        self.campoJogador[x][y]='~'
        return False
    
    def atingirAdversario(self,x,y,ans):
        if(ans):
            self.campoAdversario[x][y]='X'
            return
        self.campoAdversario[x][y]='~'

def gerar_matriz (n_linhas, n_colunas):
    return [[" "]*n_colunas for _ in range(n_linhas)]