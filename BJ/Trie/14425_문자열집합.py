def find(target, base):
    answer = True
    temps = 0
    now = base
    for chr in target:
        if chr not in now:
            answer = False
            break
        else:
            temps = now[chr]['count']
            now = now[chr]
    if not answer:
        return 0
    else:
        return temps


N, M = map(int, input().split())
base = {}
for _ in range(N):
    word = input()
    now = base
    for chr in word:
        if chr not in now:
            now[chr] = {'count': 1}
        else:
            now[chr]['count'] += 1
        now = now[chr]
answer = 0
for _ in range(M):
    target = input()
    answer += find(target, base)
print(answer)