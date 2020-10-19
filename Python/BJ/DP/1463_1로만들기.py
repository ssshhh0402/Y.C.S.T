import sys

N = int(sys.stdin.readline())

base = [0 for _ in range(N+1)]

for idx in range(2, N+1):
    if idx == 2 or idx == 3:
        base[idx] = 1
    else:
        base[idx] = base[idx-1] + 1
        if idx % 3 == 0:
            base[idx] = min(base[idx],base[idx // 3] + 1)
        if idx % 2 == 0:
            base[idx] = min(base[idx], base[idx // 2] + 1)

print(base[N])