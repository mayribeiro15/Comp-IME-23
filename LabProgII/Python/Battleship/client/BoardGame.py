import tkinter as tk
from tkinter import *
from tkinter import font
from functools import partial
from client import *
from messages import *
import random

root = Tk()
root.wm_title("🚢 BATALHA NAVAL 🚢")
root.configure(background='black')
font1 = font.Font(family='Helvetica 18', size=12, weight='bold')
font_big = font.Font(family='Helvetica 18', size=20, weight='bold')
font_normal = font.Font(family='Helvetica 18', size=10, weight='bold')

ships = {"NavioTamanhoQuatro": 4, "NavioTamanhoTres": 3, "NavioTamanhoDois": 2, "NavioTamanhoUm": 1}

class Player:
    def __init__(self, side, id):
        self.side = side
        self.id = id
        self.board = board()
        self.buttons = board_buttons(self)
        self.score = 0
        self.ships = 0

# Monta o tabuleiro 10x10 com todos os quadrados cinza
def board():
    return [[" "]*10 for _ in range(10)]

# Define os textos (título, laterais, mensagem e pontuação)
def set_labels(msg, score1, score2):
    Label(root, text="BATALHA NAVAL", fg="white", bg="black", font=font_big ,  borderwidth = 0, relief="sunken").grid(row=1, column=10, columnspan=9)
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

    endButton = Button(root, text='SAIR', font=font_normal, command=partial(quit_msg), bg='blue', fg='white', width=15, height=2, relief='flat')
    endButton.place(x=810, y=450)

# Desconecta do servidor e fecha as telas
def quit_msg():
    send(DISCONNECT_MESSAGE,"string")
    root.destroy()

# Define se acertou o navio ou a agua e seta o layout do quadrado de acordo com isso
def hit_position(a, b, board, all_buttons):
    print(a,b)

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

# Posiciona os grids para os dois jogadores
def board_buttons(player):
    side = player.side
    if side == "player":
        allbuttons = []
        ships = 0
        for i in range(10):
            buttons = []
            for j in range(10):
                button = Button(root, width=2, height=1, font=font1, bg="gray19", activebackground="gray19",
                command=partial(ship_position, i, j, player, allbuttons), state='normal')
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
                command=partial(hit_position, a, b, player.board, allbuttons), state='disabled')
                buttons.append(button)
                b += 1
            allbuttons.append(list(buttons))
            a += 1
        for row in range(10):
            for column in range(10):
                allbuttons[row][column].grid(row=4 + row, column=15 + column)

    for _ in range(10):
        Label(root, text="   ", bg="black").grid(row=4 + _, column=14)

    return allbuttons

def update_game(gameState, player, opponent):
    set_labels(gameState["msg"],gameState["playerScore"],gameState["opponentScore"])
    
    player.board = gameState["playerBoard"]
    player.score = gameState["playerScore"]
    update_board(player.board, player.buttons)
    
    opponent.board = gameState["opponentBoard"]
    opponent.score = gameState["opponentScore"]
    update_board(opponent.board, opponent.buttons)

def update_board(board, all_buttons):
    for a in range(10):
        for b in range(10):
            if board[a][b] == "1":
                all_buttons[a][b].configure(text="X", fg="black", bg="gray19", activebackground="gray19")
            if board[a][b] == "X":
                all_buttons[a][b].configure(text="X", fg="black", bg="yellow", activebackground="yellow")
            if board[a][b] == "~":
                all_buttons[a][b].configure(text="", fg="black", bg="blue", activebackground="blue")

def place_ships(player):
    print(player.board)
    shipsPosition = ShipsPosition(1,player.board)
    send(CONNECT_MESSAGE,"string")
    gameState = send(shipsPosition,"shipsPosition")
    start_game(gameState, player)

def start_game(gameState, player):
    opponent = Player("opponent", 2)
    while(True):
        gameState = send(UPDATE_MESSAGE,"string")
        update_game(gameState, player, opponent)
        if gameState["gameOver"] == 1:
            break 

# Main que monta o tabuleiro, grid e as frases
def main_board_game(self):
    self.pack_forget()
    player = Player("player", 1)
    opponent = Player("opponent", 2)
    
    gameState = GameState("Posicione sua frota.",False,0,0,0,0)
    gameState = vars(gameState)
    set_labels(gameState["msg"],gameState["playerScore"],gameState["opponentScore"])