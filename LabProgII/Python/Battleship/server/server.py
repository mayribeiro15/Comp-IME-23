import socket, json
import threading
from messages import *
from jogador import *
from gameActions import *

HEADER = 128
PORT = 5050
SERVER = socket.gethostbyname(socket.gethostname()) #"192.168.56.1"
ADDR = (SERVER, PORT)
FORMAT = "utf-8"
CONNECT_MESSAGE = "CONNECT"
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
    if int(threading.activeCount()-1)==1:
        game.jogador1id = addr
        game.jogadores = {1: Jogador(addr)}
        print(f"[JOGADOR 1] {addr} connected.")
    elif int(threading.activeCount()-1)==2:
        game.jogador2id = addr
        game.jogadores = {2: Jogador(addr)}
        print(f"[JOGADOR 2] {addr} connected.")
    else:
        print("[CONNECTION REFUSED] Limt of 2 players excedeed.")
        return

    
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
                response = handle_request(msg_type,msg,game,addr)
                print(response)
                if response:
                    conn.send(response.encode(FORMAT))
    conn.close()

def handle_request(msg_type,msg,game,addr):
    if msg_type==MSG_TYPE[0]: #string
        if msg==CONNECT_MESSAGE:
            response = update_game(game,addr)
            rsp_dict = vars(response)
            rsp_string = json.dumps(rsp_dict)
            return rsp_string
        elif msg==UPDATE_MESSAGE:
            response = update_game(game,addr)
            rsp_dict = vars(response)
            rsp_string = json.dumps(rsp_dict)
            return rsp_string
    if msg_type==MSG_TYPE[1]: #shipsposition
        print("aqui")
        board = msg["positions"]
        response = set_ships_position(board,game,addr)
        rsp_dict = vars(response)
        rsp_string = json.dumps(rsp_dict)
        return rsp_string
    if msg_type==MSG_TYPE[2]: #attackposition
        x = msg.x
        y = msg.y
        response = attack_position(x,y,game,addr)
        rsp_dict = vars(response)
        rsp_string = json.dumps(rsp_dict)
        return rsp_string
    else: 
        response = GameState("ERRO",0,0,0,0,0)
        rsp_dict = vars(response)
        rsp_string = json.dumps(rsp_dict)
        return rsp_string

def start(game):
    server.listen()
    print("[LISTENNING] Server is listening on {SERVER}")
    while True:
        conn, addr = server.accept()
        thread = threading.Thread(target=handle_client, args=(conn,addr,game))
        thread.start()
        print(f"[ACTIVE CONNECTIONS] {threading.activeCount()-1}")
