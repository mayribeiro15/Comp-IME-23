from tkinter import *
from tkinter import font
from BoardGame import *
import functools

root = Tk()
root.wm_title("🚢 BATALHA NAVAL 🚢")
root.configure(background='black')
fontButton = font.Font(family='Helvetica 18', size=12, weight='bold')
fontTitle = font.Font(family='Helvetica 18', size=50, weight='bold')

def CreateStartWindow():
    frameWindow = LabelFrame()
    frameWindow.configure(background='black')
    img = PhotoImage(file=r'C:\Users\Lenovo\Desktop\IME\GitHub\Comp-IME-23\LabProgII\Python\Battleship\images\StartWindow.png')
    img_lbl = Label(frameWindow, image=img, background='black')
    img_lbl.image = img
    img_lbl.pack()

    title_lbl = Label(frameWindow, text="BATALHA NAVAL", font=fontTitle, relief='ridge', background='black', foreground='white')
    title_lbl.place(x=130, y=100)

    startBackground = Label(frameWindow, background='blue3', width=37, height=3)
    startBackground.place(x=int(850/2), y=297)
    startButton = Button(frameWindow, text='JOGAR', font=fontButton, command=functools.partial(main_board_game, frameWindow), bg='black', fg='white', width=25, height=2, relief='flat')
    startButton.place(x=int(850/2), y=300)

    endBackground = Label(frameWindow, background='blue3', width=37, height=3)
    endBackground.place(x=int(250/2), y=297)
    endButton = Button(frameWindow, text='SAIR', font=fontButton, command=quit, bg='black', fg='white', width=25, height=2, relief='flat')
    endButton.place(x=int(250/2), y=300)

    frameWindow.pack(padx=15, pady=15)

CreateStartWindow()
root.mainloop()
