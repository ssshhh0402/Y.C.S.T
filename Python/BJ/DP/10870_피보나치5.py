n = int(input())
dp = [0 for _ in range(n+1)]
for idx in range(n+1):
    if idx == 0:
        dp[idx] = 0
    elif idx == 1:
        dp[idx] = 1
    else:
        dp[idx] = dp[idx-1] + dp[idx-2]

print(dp[n])