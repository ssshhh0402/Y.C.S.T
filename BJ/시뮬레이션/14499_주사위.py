import sys


def find(e):        #e: 방향
    global dice, base, x, y, dice_x, dice_y
    if 0 <= x+dx[e-1] < N and 0 <= y+dy[e-1] < M:
        x, y = x+dx[e-1], y + dy[e-1]
        dice_x, dice_y = abs(dice_x+d_dx[e-1]), abs(dice_y+d_dy[e-1])
        if base[x][y] == 0:
            base[x][y] = dice[dice_x][dice_y]
        else:
            dice[dice_x][dice_y] = base[x][y]
            base[x][y] = 0
        if e == 1:
            print(dice[dice_x][abs(dice_y -2)])
        elif e == 2:
            print(dice[dice_x][dice_y +2])
        else:
            print(dice[dice_x-2][dice_y])


N, M, x, y, K = list(map(int, sys.stdin.readline().split()))
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
d_dx = [-2, -2, -1, -3]
d_dy = [1, -1, 0, 0]
dice = [[0 for _ in range(3)] for _ in range(4)]
dice_x, dice_y = 2, 2
base = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
Bang = list(map(int, sys.stdin.readline().split()))
for idx in Bang:
    find(idx)
