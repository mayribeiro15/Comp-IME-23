def gerar_matriz (n_linhas, n_colunas):
    return [[" "]*n_colunas for _ in range(n_linhas)]

class Jogador:
    def __init__(self, id):
        self.id = id
        self.campoJogador = gerar_matriz(10,10)
        self.campoAdversario = gerar_matriz(10,10)
        self.totalAbatidos = 0
        self.totalRestante = 3

    def posicionarNavio(self,x,y):
        if(self.campoJogador[x][y]=='1'):
            print("--> Posição ocupada, tente novamente!\n")
            return False
        self.campoJogador[x][y]='1'
        print("--> Barco adicionado em (%d,%d)\n" % (x,y))
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

def printarCampos(campo, campoAdv):
    print("Campo:                   Campo adversario:")
    print("  0 1 2 3 4 5 6 7 8 9      0 1 2 3 4 5 6 7 8 9")
    for i in range(10): 
        print("%d %c %c %c %c %c %c %c %c %c %c    %d %c %c %c %c %c %c %c %c %c %c" % 
        (i, campo[i][0], campo[i][1], campo[i][2], campo[i][3], campo[i][4], 
        campo[i][5], campo[i][6], campo[i][7], campo[i][8], campo[i][9], 
        i, campoAdv[i][0], campoAdv[i][1], campoAdv[i][2], campoAdv[i][3], campoAdv[i][4], 
        campoAdv[i][5],	campoAdv[i][6], campoAdv[i][7], campoAdv[i][8], campoAdv[i][9]))

def main():
    jogador1 = Jogador(1)
    jogador2 = Jogador(2)

    print("BATALHA NAVAL\n")
    print("\n--> Para montar o tabuleiro escolha 3 posições \n    para os barcos da frota no formato \"x y\".")
    
    print("\nJogador 1: Monte seu tabuleiro!\n")
    for i in range(3):
        while True:
            x = int(input())
            y = int(input())
            if(jogador1.posicionarNavio(x,y)):
                break
    
    print("\nJogador 2: Monte seu tabuleiro!\n")
    for i in range(3):
        while True:
            x = int(input())
            y = int(input())
            if(jogador2.posicionarNavio(x,y)):
                break

    print("\nVamos comecar!\n")
    rodada=1
    
    while(jogador1.totalRestante>0 and jogador2.totalRestante>0):
        print("\n\nRODADA %d  (Digite s para sair)\n" % (rodada))
        
        print("Jogador 1: Qual area do campo 2 atacar? ")
        x = int(input())
        y = int(input())
        acerto = jogador2.atingirJogador(x,y)
        jogador1.atingirAdversario(x, y, acerto)
        
        print("Jogador 2: Qual area do campo 1 atacar? ")
        x = int(input())
        y = int(input())
        acerto = jogador1.atingirJogador(x,y)
        jogador2.atingirAdversario(x, y, acerto)
		
        print("\nRESULTADO DA RODADA %d:\n" % (rodada))
        printarCampos(jogador1.campoJogador, jogador1.campoAdversario)
        rodada+=1
		
    if(jogador1.totalRestante>jogador2.totalRestante):
        print("\n\nVITÓRIA!!\nO Jogador 1 venceu!")
    else:
        print("\n\nVITÓRIA!!\nO Jogador 2 venceu!")

main( )