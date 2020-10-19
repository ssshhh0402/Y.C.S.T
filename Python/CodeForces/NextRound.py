n, k = list(map(int, input().split()))

scores = list(map(int,input().split()))
target = scores[k-1]
answer = 0
for score in scores:
    if score and score >= target:
        answer += 1
    else:
        break

print(answer)