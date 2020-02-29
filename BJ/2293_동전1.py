import sys


base = []
result = [0xffff] * 10001
n, k = list(map(int, sys.stdin.readline().split()))
for i in range(n):
    base.append(int(sys.stdin.readline()))


for i in range(1, k+1):
    if i in base:
        result[i] = 1
    else:
        for idx in base:
            if i - idx > 0 and result[i-idx] != 0xffff:
                result[i] = min(result[i-idx]+1, result[i])


if result[k] == 0xffff:
    print(-1)
else:
    print(result[k])