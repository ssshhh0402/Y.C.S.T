T = int(input())
for _ in range(T):
    n = int(input())
    dp = [0 for _ in range(n+1)]
    for idx in range(1,n+1):
        if idx == 1 or idx == 2 or idx == 3:
            dp[idx] = 1
        else:
            dp[idx] = dp[idx-2] + dp[idx-3]
    print(dp[n])