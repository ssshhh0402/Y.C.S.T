import sys
from collections import deque


def getTime(a):
    a = deque(a)
    visited = [[0 for _ in range(N)] for _ in range(N)]
    for i in a:
        visited[i[0]][i[1]] = 1
    imsi_t = -1
    imsi_c = M
    while a:
        for _ in range(len(a)):
            i_x, i_y = a.popleft()
            for dx, dy in [(0, -1), (-1, 0), (0, 1), (1, 0)]:
                x, y = i_x+dx, i_y+dy
                if 0 <= x < N and 0 <= y < N and base[x][y] != 1:
                    if not visited[x][y]:
                        a.append((x,y))
                        visited[x][y] = 1
                        imsi_c += 1
        imsi_t += 1
    return imsi_t, imsi_c


def find(a, b, c):     #a = 선택된 아이들 b : 갯수 c : 위치
    global time
    if b == M:
        t, count = getTime(a)
        if count == blank_count:
            time = min(time,t)
            return

    for i in range(c+1, K):
        a.append(pos[i])
        find(a, b+1, i)
        a.pop()


N, M = list(map(int, sys.stdin.readline().split()))
base = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
pos = []
blank_count = 0
time = 0xffffff
for i in range(N):
    for j in range(N):
        if base[i][j] == 0:
            blank_count += 1
        elif base[i][j] == 2:
            pos.append((i, j))
K = len(pos)
blank_count += K
for i in range(K):
    find([pos[i]], 1, i)

if time == 0xffffff:
    print(-1)
else:
    print(time)
