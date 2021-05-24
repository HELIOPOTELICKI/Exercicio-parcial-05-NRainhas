'''
EXERCÍCIO PARCIAL 05 - PROBLEMA N-RAINHAS
Dupla: Hélio Potelicki e Pedro Henrique Roweder

'''
from itertools import permutations

N = 8
sol = 0
cols = range(N)

for combo in permutations(cols):
    if N == len(set(combo[i] + i
                    for i in cols)) == len(set(combo[i] - i for i in cols)):
        sol += 1

        resp = "\n".join(' 0 ' * i + ' 1 ' + ' 0 ' * (N - i - 1)
                         for i in combo)

        if (sol == 1):
            print(f'\nInicial --> {combo} \n{resp} \n\n')

        lastCombo = combo

print(f'Final --> {lastCombo} \n{resp}')