n = int(input())
base = list(map(int, input().split()))
answer = 0
for i in range(n):
    temps = 1
    start = base[i]
    for p in range(i+1, n):
        if base[p] > start:
            temps += 1
            start = base[p]
    answer = max(answer, temps)

print(answer)