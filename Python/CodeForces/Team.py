N = int(input())
answer = 0
for _ in range(N):
    problem = list(map(int, input().split()))
    if sum(problem) >= 2:
        answer += 1
print(answer)