import sys
N = int(sys.stdin.readline())
base = [0] * 10001
for i in range(N):
    n = int(sys.stdin.readline())
    base[n] += 1
for idx in range(1, 10001):
    if base[idx] != 0:
        for result in range(base[idx]):
            print(idx)
