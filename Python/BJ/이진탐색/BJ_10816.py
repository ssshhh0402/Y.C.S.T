import sys

N = int(sys.stdin.readline())
base = {}
answer = ""
temps = list(map(int, sys.stdin.readline().split(" ")))
for temp in temps:
    if temp not in base.keys():
        base[temp] = 1
    else:
        base[temp] += 1
M = int(sys.stdin.readline())
comp = list(map(int, sys.stdin.readline().split(" ")))
for item in comp:
    if item not in base.keys():
        answer += '0 '
    else:
        answer += (str(base[item]) + " ")
print(answer)