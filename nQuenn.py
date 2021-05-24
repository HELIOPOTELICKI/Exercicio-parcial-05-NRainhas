'''
EXERCÍCIO PARCIAL 05 - PROBLEMA N-RAINHAS
Dupla: Hélio Potelicki e Pedro Henrique Roweder

Módulo usado: pip install more-itertools
'''
from itertools import permutations

#=========== Define a quantidade de Rainhas ===========#
N = 8
#=========== Define um máximo de interações ===========#
maxIterations = 1000
#======================================================#

last = True
solution = 0
cols = range(N)


def shift(tuple):
    newArr = []

    for element in tuple:
        newArr.append(element + 1)

    newArr = str(newArr)

    return newArr


for combo in permutations(cols):
    if N == len(set(combo[i] + i
                    for i in cols)) == len(set(combo[i] - i for i in cols)):
        solution += 1

        if (solution == maxIterations):
            print(f'Número máximo de -> {maxIterations} <- iterações atingido')
            last = False
            break

        board = "\n".join(' 0 ' * i + ' 1 ' + ' 0 ' * (N - i - 1)
                          for i in combo)

        if (solution == 1):
            print(f'\nInicial --> {shift(combo)} \n{board} \n\n')

        lastCombo = combo

if last:
    print(f'Final --> {shift(lastCombo)} \n{board}')