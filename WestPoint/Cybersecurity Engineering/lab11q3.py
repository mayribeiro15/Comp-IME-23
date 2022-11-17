from pyattck import Attck

attack = Attck()

def jaccard(set1,set2):
    inter = (set1&set2)
    inter_card=float(len(inter))
    union = (set1|set2)
    union_card=float(len(union))
    js=inter_card/union_card
    return js

techs1 = set()
techs2 = set()

for actor in attack.enterprise.actors:
    if actor.id == 'G0024':
        print("Actor 1:",actor.id, actor.name)
        for technique in actor.techniques:
            techs1.add(technique.id)
    elif actor.id == 'G0129':
        print("Actor 2:",actor.id, actor.name)
        for technique in actor.techniques:
            techs2.add(technique.id)

print("Similarity Score:", jaccard(techs1,techs2))


