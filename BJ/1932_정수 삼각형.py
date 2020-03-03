import sys

N = int(sys.stdin.readline())
base = []
for _ in range(N):
    base.append(list(map(int, sys.stdin.readline().split())))
print(base)