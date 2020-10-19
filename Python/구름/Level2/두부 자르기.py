N = int(input())
dp = [0 for _ in range(N+1)]
for n in range(2, N+1):
    if n == 2:
        dp[n] = 1
    else:
        dp[n] = dp[n-1] + dp[n-2]
print(dp)
