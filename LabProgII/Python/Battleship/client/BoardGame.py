from tkinter import *
from tkinter import font
from functools import partial
#from client import *
import random

root = Tk()
root.wm_title("🚢 BATALHA NAVAL 🚢")
root.configure(background='black')
font1 = font.Font(family='Helvetica 18', size=12, weight='bold')
font_big = font.Font(family='Helvetica 18', size=20, weight='bold')
font_normal = font.Font(family='Helvetica 18', size=10, weight='bold')

ships = {"NavioTamanhoQuatro": 4, "NavioTamanhoTres": 3, "NavioTamanhoDois": 2, "NavioTamanhoUm": 1}

# Monta o tabuleiro 10x10 com todos os quadrados cinza
def board():
    board = []
    t = []
    t += (10 + 2) * ['# ']
    board.append(t)

    rad = ['# ']
    for r in range(0, 10):
        rad.append("~ ")
    rad.append('# ')
    for k in range(0, 10):
        board.append(list(rad))

    board.append(t)
    return board

# Escolhe aleatoriamente posições para os navios
def place_ship(ship, board):
    while True:
        checkcoords = []
        x = random.randint(1, 10)
        y = random.randint(1, 10)
        o = random.randint(0, 1)
        if o == 0:
            ori = "v"
        else:
            ori = "h"
        if ori == "v" and y + ships[ship] > 10:
            pass
        elif ori == "h" and x + ships[ship] > 10:
            pass
        else:
            if ori == "v":
                for i in range(-1, (ships[ship] + 1)):
                    for j in range(-1, 2):
                        checkcoords.append(board[y + i][x + j])
                if ': ' not in checkcoords:
                    for i in range(ships[ship]):
                        board[y + i][x] = ': '
                    break

            elif ori == "h":
                for i in range(-1, (ships[ship] + 1)):
                    for j in range(-1, 2):
                        checkcoords.append(board[y + j][x + i])
                if ': ' not in checkcoords:
                    for i in range(ships[ship]):
                        board[y][x + i] = ': '
                    break

# Posiciona todos os navios
def place_all_ships(board):
    for ship in ships:
        for antal in range(0, (5 - ships[ship])):
            place_ship(ship, board)

# Define os textos (título, laterais, mensagem e pontuação)
def set_labels(msg, score1, score2):
    Label(root, text="BATALHA NAVAL", fg="white", bg="black", font=font_big ,  borderwidth = 0, relief="sunken").grid(row=1, column=10, columnspan=9)
    Label(root, text=msg, fg="white", bg="black", font=font1 ,  borderwidth = 0, relief="sunken").grid(row=2, column=7, columnspan=15)

    for _ in range(10):
        Label(root, text="   ", bg="black").grid(row=_, column=0)
    Label(root, text="FROTAS:", font=font_normal, fg="white", bg="black").grid(row=5, column=1)
    Label(root, text="1 Porta-Aviões (tamanho 4)", font=font_normal, fg="white", bg="black").grid(row=6, column=1)
    Label(root, text="2 Encouraçados (tamanho 3)", font=font_normal, fg="white", bg="black").grid(row=7, column=1)
    Label(root, text="3 Cruzadores (tamanho 2)", font=font_normal, fg="white", bg="black").grid(row=8, column=1)
    Label(root, text="4 Submarinos (tamanho 1)", font=font_normal, fg="white", bg="black").grid(row=9, column=1)

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

# Define se acertou o navio ou a agua e seta o layout do quadrado de acordo com isso
def hit_or_miss(a, b, board, all_buttons):
    if board[a + 1][b + 1] == ': ':
        board[a + 1][b + 1] = 'X '
        all_buttons[a][b].configure(text="X", fg="black", bg="yellow", activebackground="yellow")
    else:
        board[a + 1][b + 1] = 'O '
        all_buttons[a][b].configure(text="O", fg="White", activeforeground="white")

# Posiciona os grids para os dois jogadores
def board_buttons(board, player):
    allbuttons = []
    a = 0
    for i in range(10):
        b = 0
        buttons = []
        for j in range(10):
            button = Button(root, width=2, height=1, font=font1, bg="gray19", activebackground="gray19",
                            command=partial(hit_or_miss, a, b, board, allbuttons))
            buttons.append(button)
            b += 1
        allbuttons.append(list(buttons))
        a += 1

    if player == "player 1":
        for row in range(10):
            for column in range(10):
                allbuttons[row][column].grid(row=4 + row, column=4 + column)
    else:
        for row in range(10):
            for column in range(10):
                allbuttons[row][column].grid(row=4 + row, column=15 + column)

# Define o meio do board azul entre os dois grids
def middle_board_space():
    for _ in range(10):
        Label(root, text="   ", bg="black").grid(row=4 + _, column=14)

def update_game(gameState, player_board, player_buttons, opponent_board):
    set_labels=(gameState.vez,gameState.playerScore,gameState.opponentScore)
    
    player_board = gameState.playerBoard
    update_board(player_board)
    
    opponent_board = gameState.opponentBoard
    update_board(opponent_board)

def update_board(board):
    board=0

# Main que monta o tabuleiro, grid e as frases
def main_board_game(self):
    self.pack_forget()
    player_board = board()
    opponent_board = board()
    
    set_labels("Escolha as posições dos navios de sua frota",0,0)
    #place_all_ships(player_board)
    #place_all_ships(opponent_board)

    board_buttons(player_board, "player 1")
    middle_board_space()
    board_buttons(opponent_board, "player 2")
