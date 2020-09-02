n = int(input())
base = list(map(int, input().split()))
answer = 0
dp = [1 for _ in range(n)]
for i in range(n):
    for j in range(i):
        if base[j] < base[i]:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp))