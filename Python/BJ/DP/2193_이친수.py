import sys

n = int(sys.stdin.readline())
base = [0 for _ in range(n+1)]
for idx in range(1, n+1):
    if idx == 1 or idx == 2:
        base[idx] = 1
    else:
        base[idx] = base[idx-1] + base[idx-2]
print(base[n])
