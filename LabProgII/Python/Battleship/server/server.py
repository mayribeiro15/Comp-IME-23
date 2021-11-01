import socket, json
import threading
from messages import *

HEADER = 128
PORT = 5050
SERVER = socket.gethostbyname(socket.gethostname()) #"192.168.56.1"
ADDR = (SERVER, PORT)
FORMAT = 'utf-8'
DISCONNECT_MESSAGE = "!DISCONNECT"
UPDATE_MESSAGE = "REQUEST_GAME_STATE"

msgType = {
    'string', #disconnect_message ou update_message
    'shipPosition', #recebe a posição do navio
    'attackPosition', #recebe a posição atacada
    'gameState' #envia estado do jogo
}

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(ADDR)

def handle_client(conn,addr): 
    print(f"[NEW CONNECTION] {addr} connected.")
    connected = True
    while connected:
        msg_header = conn.recv(HEADER).decode(FORMAT)
        if msg_header:
            msg_lenght = int(msg_header[:63])
            msg = conn.recv(msg_lenght).decode(FORMAT)
            msg_type = msg_header[64:].strip()
            if msg_type!='string':
                msg = json.loads(msg)
            
            conn.send("Msg Received!".encode(FORMAT))
            print(f"[{addr}] {msg}")

            if msg == DISCONNECT_MESSAGE:
                connected = False
            else:
                response = handle_request(msg_type,msg)
                if response:
                    conn.send(response.encode(FORMAT))
    conn.close()

def handle_request(msg_type,msg):
    if msg == UPDATE_MESSAGE:
        board = [
            ["0","0","0","0","0","0","0","0","0","0"],
            ["0","0","0","0","0","0","0","0","0","0"],
            ["0","0","0","0","0","0","0","0","0","0"],
            ["0","0","0","0","0","0","0","0","0","0"],
            ["0","0","0","0","0","0","0","0","0","0"],
            ["0","0","0","0","0","0","0","0","0","0"],
            ["0","0","0","0","0","0","0","0","0","0"],
            ["0","0","0","0","0","0","0","0","0","0"],
            ["0","0","0","0","0","0","0","0","0","0"],
            ["0","0","0","0","0","0","0","0","0","0"],
        ]
        gameState = GameState(1,1,0,board,2,5,board)
        msg_dict = vars(gameState)
        msg_string = json.dumps(msg_dict)
        return msg_string
    return ""

def start():
    server.listen()
    print("[LISTENNING] Server is listening on {SERVER}")
    while True:
        conn, addr = server.accept()
        thread = threading.Thread(target=handle_client, args=(conn,addr))
        thread.start()
        print(f"[ACTIVE CONNECTIONS] {threading.activeCount()-1}")

print("[STARTING] server is starting...")
start()