from lexical.analyzer import LexicalAnalyzer
from syntatical.analyzer import SyntaticalAnalyzer

file = open('codigo-teste.ssl', 'r', encoding = 'utf-8')

lexical = LexicalAnalyzer(file)
lexical.run()

lexical = LexicalAnalyzer(file)
syntatical = SyntaticalAnalyzer(lexical)
syntatical.run()

file.close()