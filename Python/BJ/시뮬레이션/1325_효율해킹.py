import sys
from collections import deque


def dfs(idx):
    global result,max_n
    visited = [0] * (N+1)
    visited[idx] = 1
    imsi = deque([idx])
    cnt = 0
    while imsi:
        a = imsi.popleft()
        for next in base[a]:
            if not visited[next]:
                visited[next] = 1
                imsi.append(next)
                cnt += 1
    if cnt > max_n:
        max_n = cnt
        result = str(idx)
    elif cnt == max_n:
        result = result + (" " + str(idx))


N, M = list(map(int, sys.stdin.readline().split()))
base = [[] for _ in range(N+1)]
result = ''
max_n = -0xfffff
for i in range(M):
    a, b = list(map(int, sys.stdin.readline().split()))
    base[b].append(a)
for idx in range(1, N+1):
    dfs(idx)
print(result)