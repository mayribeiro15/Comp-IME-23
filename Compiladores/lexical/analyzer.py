from lexical.tokens import *
from lexical.methods import *

# Key Words
key_words = ["array", "boolean", "break", "char", "continue", "do", "else", "false", "function", "if", "integer", "of", "string", "struct", "true", "type", "var", "while"]

class LexicalAnalyzer:
    lexicalError = False
    arq = None

    def __init__(self, file):
        file.seek(0)
        self.arq = file

    # Keywords
    def searchKeyWord(self, name): 
        key = binarysearch(name,key_words)
        if(key == -1):
            return ID
        return key
    
    # Identifiers
    identifiers = {}
    count = 0

    def searchName(self, name): 
        if name not in self.identifiers:
            self.identifiers[name] = self.count
            self.count += 1
        return self.identifiers[name]

    # Literals
    vConst = []

    def addConst(self, c):
        self.vConst.append(c)
        return len(self.vConst)-1

    def getConst(self, c):
        return self.vConst[c]

    # Finite Automaton
    nextChar = " "
    secondary_Token = None

    def nextToken(self):
        sep = ""
        while isspace(self.nextChar):
            self.nextChar = self.arq.read(1)
        
        if self.nextChar == "":
            token = EOF
        
        elif isalnum(self.nextChar):
            aux = []
            while isalnum(self.nextChar) or self.nextChar == '_':
                aux.append(self.nextChar)
                self.nextChar = self.arq.read(1)
            text = sep.join(aux)
            token = self.searchKeyWord(text)
            if token == ID:
                self.secondary_Token = self.searchName(text)
        
        elif isdigit(self.nextChar):
            aux = []
            while isdigit(self.nextChar):
                aux.append(self.nextChar)
                self.nextChar = self.arq.read(1)    
            num = sep.join(aux)
            token = NUMERAL
            self.secondary_Token = self.addConst(num)
        
        elif self.nextChar == "\"":
            aux = []
            aux.append(self.nextChar)
            self.nextChar = self.arq.read(1)
            
            if self.nextChar != "\"":
                while(self.nextChar!="\""):
                    aux.append(self.nextChar)
                    self.nextChar = self.arq.read(1)        
            aux.append(self.nextChar)
            self.nextChar = self.arq.read(1)
            
            string = sep.join(aux)
            token = STRING
            self.secondary_Token = self.addConst(string)
        
        else:
            if self.nextChar == "\'":
                self.nextChar = self.arq.read(1)
                token = CHARACTER
                self.secondary_Token = self.addConst(self.nextChar)
                self.nextChar = self.arq.read(2) 
                self.ch+=2
            elif self.nextChar == ":":
                self.nextChar = self.arq.read(1)
                token = COLON
            elif self.nextChar == "+":
                self.nextChar = self.arq.read(1)                
                if self.nextChar == "+":
                    token = PLUS_PLUS
                    self.nextChar = self.arq.read(1)                    
                else:
                    token = PLUS
            elif self.nextChar == "-":
                self.nextChar = self.arq.read(1)                
                if self.nextChar == "-":
                    token = MINUS_MINUS
                    self.nextChar = self.arq.read(1)                    
                else:
                    token = MINUS
            elif self.nextChar == ";":
                self.nextChar = self.arq.read(1)                
                token = SEMI_COLON
            elif self.nextChar == ",":
                self.nextChar = self.arq.read(1)                
                token = COMMA
            elif self.nextChar == "=":
                self.nextChar = self.arq.read(1)                
                if self.nextChar == "=":
                    token = EQUAL_EQUAL
                    self.nextChar = self.arq.read(1)                    
                else:
                    token = EQUALS
            elif self.nextChar == "[":
                self.nextChar = self.arq.read(1)                
                token = LEFT_SQUARE
            elif self.nextChar == "]":
                self.nextChar = self.arq.read(1)                
                token = RIGHT_SQUARE
            elif self.nextChar == "{":
                self.nextChar = self.arq.read(1)                
                token = LEFT_BRACES
            elif self.nextChar == "}":
                self.nextChar = self.arq.read(1)                
                token = RIGHT_BRACES
            elif self.nextChar == "(":
                self.nextChar = self.arq.read(1)                
                token = LEFT_PARENTHESIS
            elif self.nextChar == ")":
                self.nextChar = self.arq.read(1)                
                token = RIGHT_PARENTHESIS
            elif self.nextChar == "&":
                self.nextChar = self.arq.read(1)                
                if self.nextChar == "&":
                    self.nextChar=self.arq.read(1)                    
                    token = AND
                else:
                    token = UNKNOWN
            elif self.nextChar == "|":
                self.nextChar = self.arq.read(1)                
                if self.nextChar == "|":
                    self.nextChar = self.arq.read(1)                    
                    token = OR
                else:
                    token = UNKNOWN
            elif self.nextChar == "<":
                self.nextChar=self.arq.read(1)                
                if self.nextChar == "=":
                    token = LESS_OR_EQUAL
                    self.nextChar = self.arq.read(1)                    
                else:
                    token=LESS_THAN
            elif self.nextChar == ">":
                self.nextChar = self.arq.read(1)                
                if self.nextChar == "=":
                    token = GREATER_OR_EQUAL
                    self.nextChar = self.arq.read(1)                    
                else:
                    token = GREATER_THAN
            elif self.nextChar == "!":
                self.nextChar = self.arq.read(1)                
                if self.nextChar == "=":
                    token = NOT_EQUAL
                    self.nextChar = self.arq.read(1)                    
                else:
                    token = NOT 
            elif self.nextChar == "*":
                self.nextChar = self.arq.read(1)                
                token = TIMES
            elif self.nextChar == ".":
                self.nextChar = self.arq.read(1)                
                token = DOT        
            elif self.nextChar == "/":
                self.nextChar = self.arq.read(1)                
                token = DIVIDE
            else:
                self.nextChar = self.arq.read(1)                
                token = UNKNOWN
        return token

    def run(self):
        self.nextChar = self.arq.read(1)
        aux = self.nextToken()
        while aux != EOF:
            if aux == UNKNOWN:
                print("Lexical errors found.")
                self.lexicalError = True
            aux = self.nextToken()
        if not self.lexicalError:
            print ("No lexical errors.")
