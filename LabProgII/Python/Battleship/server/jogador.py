class Battleship:
    def __init__(self):
        self.jogadores = []
        self.jogador1id = 0
        self.jogador2id = 0
        self.vez = 1

class Jogador:
    def __init__(self, id):
        self.id = id
        self.campoJogador = gerar_matriz(10,10)
        self.campoAdversario = gerar_matriz(10,10)
        self.totalAbatidos = 0
        self.totalRestante = 10

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