N = int(raw_input())

answer = 0
for idx in range(1, N+1):
    if idx % 3 == 0 or idx % 5 == 0:
        answer += idx
print(answer)