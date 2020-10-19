N = int(input())
for _ in range(N):
    n = int(input())
    dp = [[0, 0] for _ in range(n + 1)]

    for idx in range(n+1):
        if idx == 0:
            dp[0][0] = 1
            dp[0][1] = 0
        elif idx == 1:
            dp[1][1] = 1
            dp[1][0] = 0
        else:
            dp[idx][0] = dp[idx-1][0] + dp[idx-2][0]
            dp[idx][1] = dp[idx-1][1] + dp[idx-2][1]
    print(dp[n][0], dp[n][1])