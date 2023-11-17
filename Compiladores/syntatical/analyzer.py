from syntatical.states import *
from lexical.tokens import *
from semantical.analyzer import SemanticalAnalyzer
import csv

TAB_ACTION = list(csv.reader(open("action-table.csv","r"), delimiter = "\t"))
TAB_ACTION_TOKEN=[0, INTEGER, CHAR, BOOLEAN, STRING, TYPE, EQUALS, ARRAY, LEFT_SQUARE, RIGHT_SQUARE, 
                  OF, STRUCT,LEFT_BRACES,RIGHT_BRACES,SEMI_COLON,COLON,FUNCTION,LEFT_PARENTHESIS,
                  RIGHT_PARENTHESIS,COMMA,VAR,IF,ELSE,WHILE,DO,BREAK,CONTINUE,AND,OR,LESS_THAN,
                  GREATER_THAN,LESS_OR_EQUAL,GREATER_OR_EQUAL,EQUAL_EQUAL,NOT_EQUAL,PLUS,MINUS,
                  TIMES,DIVIDE,PLUS_PLUS,MINUS_MINUS,NOT,DOT,ID,TRUE,FALSE,CHARACTER,STRINGVAL,
                  NUMERAL,EOF,PLINHA,P,LDE,DE,T,DT,DC,DF,LP,B,LDV,LS,DV,LI,S,U,M,E,L,R,Y,F,LE,LV,
                  IDD,IDU,ID,TRUE,FALSE,CHR,STR,NUM,NB,MF,MC,NF,MT,ME,MW]


class SyntaticalAnalyzer:
    lexical = None
    syntaticalError = False

    def __init__(self, lexical):
        self.lexical = lexical

    def run(self):
        code_generate = open("codigo-gerado.txt", "w")
        code_generate.close()
        
        if self.lexical.lexicalError:
            return

        STACK = []
        state = 0
        STACK.append(state)
        readToken = self.lexical.nextToken()
        action = TAB_ACTION[state+1][TAB_ACTION_TOKEN.index(readToken)]
        
        cont=0
        while action != "acc":
            if readToken == UNKNOWN:
                self.lexical.lexicalError = True
                break

            if int(action)>0: #IS_SHIFT
                state = int(action) #RULE
                STACK.append(state)
                readToken = self.lexical.nextToken()
                
                #print("aqui",TAB_ACTION_TOKEN[43])
                #print(readToken,TAB_ACTION_TOKEN.index(readToken))
                
                action = TAB_ACTION[state+1][TAB_ACTION_TOKEN.index(readToken)]
                cont+=1
            
            elif int(action)<0: #IS_REDUCTION
                rule = -int(action) #RULE
                for x in range(RIGHT[rule-1]):
                    STACK.pop()
                try:
                    state = int(TAB_ACTION[STACK[-1]+1][TAB_ACTION_TOKEN.index(LEFT[rule-1])])
                except:
                    print("Syntatical errors found.")
                    self.syntaticalError = True
                    break
                STACK.append(state)
                action = TAB_ACTION[state+1][TAB_ACTION_TOKEN.index(readToken)]
                cont+=1
                SemanticalAnalyzer(self.lexical, rule)
                
            else:
                self.syntaticalError = True
                print("Syntatical errors found.")
                break