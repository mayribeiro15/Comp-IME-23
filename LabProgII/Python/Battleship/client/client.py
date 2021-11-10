import socket, json
import threading
import tkinter as tk
from tkinter import *
from tkinter import font
from functools import partial
from messages import *

HEADER = 128
PORT = 5050
SERVER = "192.168.56.1"
ADDR = (SERVER, PORT)
FORMAT = 'utf-8'
START_MESSAGE = "START_GAME"
DISCONNECT_MESSAGE = "!DISCONNECT"
UPDATE_MESSAGE = "REQUEST_GAME_STATE"
MSG_TYPE = {
    0: 'string', #disconnect_message ou update_message
    1: 'shipsPosition', #recebe a posição do navio
    2: 'attackPosition', #recebe a posição atacada
    3: 'gameState' #envia estado do jogo
}

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(ADDR)

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

def receive():
    while True:
        try:
            gameState = client.recv(2048).decode(FORMAT)
            gameState = json.loads(gameState)
            print(gameState)
            update_game(gameState)
        except:
            print("An error occured!")
            break

class Player:
    def __init__(self, side, id):
        self.side = side
        self.id = id
        self.board = board()
        self.buttons = None
        self.score = 0
        self.ships = 0

    def setBoardButtons(self):
        side = self.side
        if side == "player":
            allbuttons = []
            ships = 0
            for i in range(10):
                buttons = []
                for j in range(10):
                    button = Button(root, width=2, height=1, font=font1, bg="gray19", activebackground="gray19",
                    command=partial(ship_position, i, j, self, allbuttons), state='normal')
                    buttons.append(button)
                allbuttons.append(list(buttons))
            for row in range(10):
                for column in range(10):
                    allbuttons[row][column].grid(row=4 + row, column=4 + column)
        else:
            allbuttons = []
            a = 0
            for i in range(10):
                b = 0
                buttons = []
                for j in range(10):
                    button = Button(root, width=2, height=1, font=font1, bg="gray19", activebackground="gray19",
                    command=partial(hit_position, a, b), state='disabled')
                    buttons.append(button)
                    b += 1
                allbuttons.append(list(buttons))
                a += 1
            for row in range(10):
                for column in range(10):
                    allbuttons[row][column].grid(row=4 + row, column=15 + column)

        for _ in range(10):
            Label(root, text="   ", bg="black").grid(row=4 + _, column=14)

        self.buttons = allbuttons

# Monta o tabuleiro 10x10 com todos os quadrados cinza
def board():
    return [[" "]*10 for _ in range(10)]

# Define os textos (título, laterais, mensagem e pontuação)
def set_labels(msg, score1, score2):
    Label(root, text="BATALHA NAVAL", fg="white", bg="black", font=font_big ,  borderwidth = 0, relief="sunken").grid(row=1, column=10, columnspan=9)
    Label(root, text=" "*100, fg="white", bg="black", font=font1 ,  borderwidth = 0, relief="sunken").grid(row=2, column=7, columnspan=15)
    Label(root, text=msg, fg="white", bg="black", font=font1 ,  borderwidth = 0, relief="sunken").grid(row=2, column=7, columnspan=15)

    for _ in range(10):
        Label(root, text="   ", bg="black").grid(row=_, column=0)
    Label(root, text="OBJETIVO:", font=font_normal, fg="white", bg="black").grid(row=5, column=1)
    Label(root, text="Atingir os navios da frota", font=font_normal, fg="white", bg="black").grid(row=6, column=1)
    Label(root, text="inimiga antes que a sua", font=font_normal, fg="white", bg="black").grid(row=7, column=1)
    Label(root, text="frota seja eliminada.", font=font_normal, fg="white", bg="black").grid(row=8, column=1)
    Label(root, text="TOTAL DA FROTA:", font=font_normal, fg="white", bg="black").grid(row=9, column=1)
    Label(root, text="10 Navios", font=font_normal, fg="white", bg="black").grid(row=10, column=1)

    label2 = Label(root, text="Campo Jogador", font=font1, fg="white", bg="black")
    label2.grid(row=18, column=4, columnspan=10)
    label2 = Label(root, text="SCORE: "+str(score1), font=font1, fg="white", bg="black")
    label2.grid(row=19, column=4, columnspan=10)
    label2 = Label(root, text="Campo Inimigo", font=font1, fg="white", bg="black")
    label2.grid(row=18, column=15, columnspan=10)
    label2 = Label(root, text="SCORE: "+str(score2), font=font1, fg="white", bg="black")
    label2.grid(row=19, column=15, columnspan=10)
    Label(root, text="   ", bg="black").grid(row=20, column=2)

    for _ in range(10):
        Label(root, text="   ", bg="black").grid(row=_+4, column=2)
    for _ in range(10):
        Label(root, width=20, text="   ", bg="black").grid(row=_+4, column=25)

    endButton = Button(root, text='SAIR', font=font_normal, command=partial(quitGame), bg='blue', fg='white', width=15, height=2, relief='flat')
    endButton.place(x=810, y=450)

# Define se acertou o navio ou a agua e seta o layout do quadrado de acordo com isso
def hit_position(a, b):
    attackPosition = AttackPosition(a,b)
    send(attackPosition,"attackPosition")

#Define a posição do navio
def ship_position(a, b, player, all_buttons):
    player.board[a][b] = '1'
    all_buttons[a][b].configure(text="X", fg="black", bg="gray19", activebackground="gray19")
    player.ships+=1
    print(a,b,player.ships)
    if player.ships==10:
        for i in range(10):
            for j in range(10):
                all_buttons[i][j]['state']=tk.DISABLED
        place_ships(player)

def update_game(gameState):    
    player.board = gameState["playerBoard"]
    player.score = gameState["playerScore"]
    update_board(player.board, player.buttons)
    opponent.board = gameState["opponentBoard"]
    opponent.score = gameState["opponentScore"]
    update_board(opponent.board, opponent.buttons)
    set_labels(gameState["msg"],gameState["playerScore"],gameState["opponentScore"])
    all_buttons = opponent.buttons
    if gameState["vez"]==True:
        for i in range(10):
            for j in range(10):
                all_buttons[i][j]['state']=tk.NORMAL
    else:
        for i in range(10):
            for j in range(10):
                all_buttons[i][j]['state']=tk.DISABLED

def update_board(board, all_buttons):
    for a in range(10):
        for b in range(10):
            if board[a][b] == "1":
                all_buttons[a][b].configure(text="X", fg="black", bg="gray19", activebackground="gray19")
            elif board[a][b] == "X":
                all_buttons[a][b].configure(text="X", fg="black", bg="yellow", activebackground="yellow")
            elif board[a][b] == "~":
                all_buttons[a][b].configure(text="", fg="black", bg="blue", activebackground="blue")

def place_ships(player):
    print(player.board)
    shipsPosition = ShipsPosition(1,player.board)
    send(START_MESSAGE,"string")
    send(shipsPosition,"shipsPosition")

def startWindow():
    frameWindow = LabelFrame()
    frameWindow.configure(background='black')
    img = PhotoImage(file='StartWindow.png')
    img_lbl = Label(frameWindow, image=img, background='black')
    img_lbl.image = img
    img_lbl.pack()

    title_lbl = Label(frameWindow, text="BATALHA NAVAL", font=fontTitle, relief='ridge', background='black', foreground='white')
    title_lbl.place(x=130, y=100)

    startBackground = Label(frameWindow, background='blue3', width=37, height=3)
    startBackground.place(x=int(850/2), y=297)
    startButton = Button(frameWindow, text='JOGAR', font=fontButton, command=partial(boardGame, frameWindow), bg='black', fg='white', width=25, height=2, relief='flat')
    startButton.place(x=int(850/2), y=300)

    endBackground = Label(frameWindow, background='blue3', width=37, height=3)
    endBackground.place(x=int(250/2), y=297)
    endButton = Button(frameWindow, text='SAIR', font=fontButton, command=partial(quitGame), bg='black', fg='white', width=25, height=2, relief='flat')
    endButton.place(x=int(250/2), y=300)

    frameWindow.pack(padx=15, pady=15)

def boardGame(self):
    self.pack_forget()
    player.setBoardButtons()
    opponent.setBoardButtons()
    
    gameState = GameState("Posicione sua frota.",False,0,0,0,0)
    gameState = vars(gameState)
    set_labels(gameState["msg"],gameState["playerScore"],gameState["opponentScore"])
 
    rcv= threading.Thread(target = receive)
    rcv.start()

# Desconecta do servidor e fecha as telas
def quitGame():
    send(DISCONNECT_MESSAGE,"string")
    root.destroy()

root = Tk()
root.wm_title("🚢 BATALHA NAVAL 🚢")
root.configure(background='black')
font1 = font.Font(family='Helvetica 18', size=12, weight='bold')
font_big = font.Font(family='Helvetica 18', size=20, weight='bold')
font_normal = font.Font(family='Helvetica 18', size=10, weight='bold')
fontButton = font.Font(family='Helvetica 18', size=12, weight='bold')
fontTitle = font.Font(family='Helvetica 18', size=50, weight='bold')

player = Player("player", 1)
opponent = Player("opponent", 2)
startWindow()
root.mainloop()