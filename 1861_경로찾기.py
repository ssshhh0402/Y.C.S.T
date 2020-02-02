import sys


def find(a,b,c,d):  #a = x, b = y, c = 지나온 값, d = 경로
    global result,answer,visited
    if a == N-1 and b == N-1:
        if c > result:
            result = c
            answer = d
        return
    for i in range(4):
        next_x, next_y = a+dx[i], b+dy[i]
        if 0 <= next_x < N and 0 <= next_y < N:
            if not visited[next_x][next_y]:
                visited[next_x][next_y] = 1
                find(next_x, next_y, c+base[next_x][next_y], d+ds[i])
                visited[next_x][next_y] = 0


N = int(sys.stdin.readline())
base = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visited = [[0 for _ in range(N)] for _ in range(N)]
result = 0
answer = ''
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
ds = ['R', 'D', 'L', 'U']
find(0, 0, base[0][0], '')
print(result)
print(answer)