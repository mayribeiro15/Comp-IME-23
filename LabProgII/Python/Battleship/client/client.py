import socket, json
from tkinter import Message
from messages import GameState

HEADER = 128
PORT = 5050
SERVER = "192.168.56.1"
ADDR = (SERVER, PORT)
FORMAT = 'utf-8'
CONNECT_MESSAGE = "CONNECT"
DISCONNECT_MESSAGE = "!DISCONNECT"
UPDATE_MESSAGE = "REQUEST_GAME_STATE"

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(ADDR)

msgType = {
    'string', #disconnect_message ou update_message
    'shipPosition', #envia a posição do navio
    'attackPosition', #envia a posição atacada
    'gameState' #recebe estado do jogo
}

def send(msg, type):
    if type=='string':
        message = msg.encode(FORMAT)
    else:
        msg_dict = vars(msg)
        msg_string = json.dumps(msg_dict)
        message = msg_string.encode(FORMAT)
    
    msg_lenght = len(message)
    send_length = str(msg_lenght).encode(FORMAT)
    send_length += b' ' * int(HEADER/2 - len(send_length))
    send_type = str(type).encode(FORMAT)
    send_type += b' ' * int(HEADER/2 - len(send_type))
    header = send_length+send_type
    
    client.send(header)
    client.send(message)
    msg = client.recv(2048).decode(FORMAT)
    msg = json.loads(msg)
    return msg