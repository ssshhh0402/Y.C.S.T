import sys
X = int(sys.stdin.readline())
base = 64
count = 0

while X:
    if X==base:
        count += 1
        break
    if X % 2:
        count += 1
    X = X // 2

print(count)