from pyattck import Attck

attack = Attck()

for actor in attack.enterprise.actors:
    if actor.id == 'G0024':
        print(actor.id, actor.name)
        print("- Techniques:")
        for technique in actor.techniques:
            print('  ', technique.id, technique.name)
            print("  - Tatics:")
            for tactic in technique.tactics:
                print("     ",tactic.id, tactic.name)
