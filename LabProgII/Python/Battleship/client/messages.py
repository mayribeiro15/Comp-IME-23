class ShipsPosition:
    def __init__(self, id, pos):
        self.id = id
        self.positions = pos

class AttackPosition:
    def __init__(self, id, x, y):
        self.attackedId = id
        self.x = x
        self.y = y

class GameState:
    def __init__(self, msg, vez, pScore, pBoard, oScore, oBoard):
        self.gameOver=0
        self.msg = msg
        self.player = vez
        self.playerScore = pScore
        self.playerBoard = pBoard
        self.opponentScore = oScore
        self.opponentBoard = oBoard