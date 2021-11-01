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
    def __init__(self, vez, pId, pScore, pBoard, oId, oScore, oBoard):
        self.player = vez
        self.playerId = pId
        self.playerScore = pScore
        self.playerBoard = pBoard
        self.opponentId = oId
        self.opponentScore = oScore
        self.opponentBoard = oBoard