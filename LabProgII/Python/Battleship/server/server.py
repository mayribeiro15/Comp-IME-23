import socket, json
import threading
from messages import *
from jogador import *
from battleship import *

HEADER = 128
PORT = 5050
SERVER = socket.gethostbyname(socket.gethostname()) #"192.168.56.1"
ADDR = (SERVER, PORT)
FORMAT = "utf-8"
START_MESSAGE = "START_GAME"
DISCONNECT_MESSAGE = "!DISCONNECT"
UPDATE_MESSAGE = "REQUEST_GAME_STATE"
MSG_TYPE = {
    0: 'string', #disconnect_message ou update_message
    1: 'shipsPosition', #recebe a posição do navio
    2: 'attackPosition', #recebe a posição atacada
    3: 'gameState' #envia estado do jogo
}

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(ADDR)

def handle_client(conn,addr,game): 
    connected = True
    while connected:
        msg_header = conn.recv(HEADER).decode(FORMAT)
        if msg_header:
            msg_lenght = int(msg_header[:63])
            msg = conn.recv(msg_lenght).decode(FORMAT)
            msg_type = msg_header[64:].strip()
            if msg_type!='string':
                msg = json.loads(msg)
            print(f"[{addr}] {msg_type}: {msg}")
            if msg == DISCONNECT_MESSAGE:
                connected = False
            else:
                lock.acquire()
                handle_request(msg_type,msg,game,addr)
                lock.release()
    conn.close()

def wait_request(conn,addr):
    msg_header = conn.recv(HEADER).decode(FORMAT)
    if msg_header:
        msg_lenght = int(msg_header[:63])
        msg = conn.recv(msg_lenght).decode(FORMAT)
        msg_type = msg_header[64:].strip()
        if msg_type!='string':
            msg = json.loads(msg)
        print(f"[{addr}] {msg_type}: {msg}")
        if msg == DISCONNECT_MESSAGE:
            conn.close()
        else:
            handle_request(msg_type,msg,game,addr)

def handle_request(msg_type,msg,game,addr):
    if msg_type==MSG_TYPE[0]: #string
        if msg==START_MESSAGE:
            return
        elif msg==UPDATE_MESSAGE:
            update_game(game)
    elif msg_type==MSG_TYPE[1]: #shipsposition
        id = game.addrId[addr]
        board = msg["positions"]
        set_ships_position(board,id,game)
        update_game(game)
    elif msg_type==MSG_TYPE[2]: #attackposition
        id = game.addrId[addr]
        x = msg["x"]
        y = msg["y"]
        attack_position(x,y,id,game)
        update_game(game)

def json_string(response):
    rsp_dict = vars(response)
    rsp_string = json.dumps(rsp_dict)
    return rsp_string

def attack_position(x,y,id,game):
    if id==1:
        jogador = game.jogador[1]
        adversario = game.jogador[2]
        game.vez = 2
        print(f"[JOGADOR 1]: Ataque a posição {x},{y} efetuado.")
    else:
        jogador = game.jogador[2]
        adversario = game.jogador[1]
        game.vez = 1
        print(f"[JOGADOR 2]: Ataque a posição {x},{y} efetuado.")
    acerto = adversario.atingirJogador(x,y)
    jogador.atingirAdversario(x, y, acerto)
    update_game(game)

def set_ships_position(board,id,game):
    if id==1:
        jogador = game.jogador[1]
        jogador.campoJogador = board
        print("[JOGADOR 1]: Frota posicionada.")
    else:
        jogador = game.jogador[2]
        jogador.campoJogador = board
        print("[JOGADOR 2]: Frota posicionada.")

def set_msg(jogador, adversario):
    if adversario.campoJogador == gerar_matriz(10,10):
        msg = "Aguarde o adversário posicionar a frota"
    elif jogador.totalRestante == 0:
        msg = "GAME OVER!!! Você perdeu :("
    elif adversario.totalRestante == 0:
        msg = "GAME OVER!!! Parabéns, você venceu!"
    elif game.vez==jogador.id:
        msg = "Sua vez! Ataque o seu oponente!"
    else:
        msg = "Aguarde sua vez."
    return msg

def update_game(game):
    if game.jogadores < 2:
        jogador = game.jogador[1]
        vez = False
        msg = "Aguarde o outro jogador." 
        adversario = Jogador(0,0,0)
        gameState = GameState(msg, vez, adversario.totalAbatidos, jogador.campoJogador, jogador.totalAbatidos, jogador.campoAdversario)
        response = json_string(gameState)
        (jogador.conn).send(response.encode(FORMAT))
    else:
        jogador1=game.jogador[1]
        jogador2=game.jogador[2]
      
        if(game.gameOver == -1):
            game.vez=1
            game.gameOver=0

        msg = set_msg(jogador1,jogador2)
        vez = (game.vez==jogador1.id)
        gameState = GameState(msg, vez, jogador2.totalAbatidos, jogador1.campoJogador, jogador1.totalAbatidos, jogador1.campoAdversario)
        response = json_string(gameState)
        (jogador1.conn).send(response.encode(FORMAT))

        msg = set_msg(jogador2,jogador1)
        vez = (game.vez==jogador2.id)
        gameState = GameState(msg, vez, jogador1.totalAbatidos, jogador2.campoJogador, jogador2.totalAbatidos, jogador2.campoAdversario)
        response = json_string(gameState)
        (jogador2.conn).send(response.encode(FORMAT))

game = Battleship()
(game.jogador).append(Jogador(0, 0, 0))
game.addrId = {0: 0}
print("[STARTING] server is starting...")
server.listen()
print("[LISTENNING] Server is listening on {SERVER}")

players = 0
threads = []
lock = threading.Lock()

while players<2:
    conn, addr = server.accept()
    lock.acquire()
    if players==0:
        game.jogadores+=1
        game.addrId[addr] = 1
        (game.jogador).append(Jogador(1, addr, conn))
        print(f"[JOGADOR 1] {addr} connected.")
    else:
        game.jogadores+=1
        game.addrId[addr] = 2
        (game.jogador).append(Jogador(2, addr, conn))
        print(f"[JOGADOR 2] {addr} connected.")
    lock.release()
    print(game.jogador)
    thread = threading.Thread(target=handle_client, args=(conn,addr,game))
    threads.append(thread)
    thread.start()
    players +=1
    print(f"[ACTIVE CONNECTIONS] {players}")

for thread in threads:
    thread.join()