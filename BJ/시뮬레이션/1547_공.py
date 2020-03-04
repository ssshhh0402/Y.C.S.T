import sys

N = int(sys.stdin.readline())
base = [0 for _ in range(4)]
base[1] = 1
result = False
answer = 0
for _ in range(N):
    a, b = map(int, sys.stdin.readline().split())
    base[a], base[b] = base[b], base[a]

for idx in range(4):
    if base[idx] == 1:
        result = True
        answer = idx
if result:
    print(answer)
else:
    print(-1)
