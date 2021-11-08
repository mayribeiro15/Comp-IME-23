from jogador import *
from messages import *

def printarCampos(campo, campoAdv):
    print("Campo:                   Campo adversario:")
    print("  0 1 2 3 4 5 6 7 8 9      0 1 2 3 4 5 6 7 8 9")
    for i in range(10): 
        print("%d %c %c %c %c %c %c %c %c %c %c    %d %c %c %c %c %c %c %c %c %c %c" % 
        (i, campo[i][0], campo[i][1], campo[i][2], campo[i][3], campo[i][4], 
        campo[i][5], campo[i][6], campo[i][7], campo[i][8], campo[i][9], 
        i, campoAdv[i][0], campoAdv[i][1], campoAdv[i][2], campoAdv[i][3], campoAdv[i][4], 
        campoAdv[i][5],	campoAdv[i][6], campoAdv[i][7], campoAdv[i][8], campoAdv[i][9]))

def attack_position(x,y,game,addr):
    if game.jogador1id == addr:
        jogador = game.jogadores[1]
        adversario = game.jogadores[2]
        game.vez = 2
        print(f"[JOGADOR 1]: Ataque a posição {x},{y} efetuado.")
    else:
        jogador = game.jogadores[2]
        adversario = game.jogadores[1]
        game.vez = 1
        print(f"[JOGADOR 2]: Ataque a posição {x},{y} efetuado.")

    acerto = adversario.atingirJogador(x,y)
    jogador.atingirAdversario(x, y, acerto)

def set_ships_position(board,game,addr):
    if game.jogador1id == addr:
        jogador = game.jogadores[1]
        jogador.campoJogador = board
        print("[JOGADOR 1]: Frota posicionada.")
        response = update_game(game,addr)
        return response
    else:
        jogador = game.jogadores[2]
        jogador.campoJogador = board
        print("[JOGADOR 2]: Frota posicionada.")
        response = update_game(game,addr)
        return response

def update_game(game,addr):
    if game.jogador1id == addr:
        jogador = game.jogadores[1]
        if game.jogador2id == 0:
            adversario = Jogador(0)
        else:
            adversario = game.jogadores[2]
    else:
        jogador = game.jogadores[2]
        adversario = game.jogadores[1]

    if game.jogador2id == 0:
        vez = False
        msg = "Aguarde o outro jogador." 
    elif adversario.campoJogador == gerar_matriz(10,10):
        vez = False
        msg = "Aguarde o adversário posicionar a frota"
    elif jogador.totalRestante == 0:
        vez = False
        msg = "GAME OVER!!! Você perdeu!"
    elif adversario.totalRestante == 0:
        vez = False
        msg = "GAME OVER!!! Parabéns, você venceu!"
    elif game.vez==1:
        vez = True
        msg = "Sua vez! Ataque o seu oponente!"
    else:
        vez = False
        msg = "Aguarde sua vez."
   

    gameState = GameState(msg, vez, adversario.totalAbatidos, jogador.campoJogador, jogador.totalAbatidos, jogador.campoAdversario)
    return gameState
