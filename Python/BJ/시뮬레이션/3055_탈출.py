import sys
from collections import deque


def k_move():
    N = len(K)
    for _ in range(N):
        k_x, k_y = K.popleft()
        if (k_x, k_y) == B:
            return True
        for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
            x, y = k_x+dx, k_y+dy
            if 0 <= x < R and 0 <= y < C:
                if not visited[x][y] and base[x][y] != '*':
                    if base[x][y] != 'X':
                        visited[x][y] = 1
                        K.append((x, y))
    return False


def w_move():
    N = len(water)
    for _ in range(N):
        w_x, w_y = water.popleft()
        for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
            x, y = w_x+dx, w_y + dy
            if 0 <= x < R and 0 <= y < C:
                if base[x][y] == '.' or base[x][y] == 'S':
                    base[x][y] = '*'
                    water.append((x, y))


R, C = list(map(int, sys.stdin.readline().split()))
base = []
K = deque([])
B = 0
time = 0
water = deque([])
pos = False
visited = [[0 for _ in range(C)] for _ in range(R)]
for x in range(R):
    a = list(sys.stdin.readline())[0:-1]
    base.append(a)
    for y in range(C):
        if a[y] == 'D':
            B = (x, y)
        elif a[y] == 'S':
            visited[x][y] = 1
            K.append((x, y))
        elif a[y] == '*':
            water.append((x, y))

while water or K:
    w_move()
    pos = k_move()
    if pos:
        break
    else:
        time += 1

if pos:
    print(time)
else:
    print('KAKTUS')