import sys
num = -0xffff
people = 0
for _ in range(4):
    off, on = list(map(int, sys.stdin.readline().split()))
    people = people - off + on
    num = max(num, people)
print(num)