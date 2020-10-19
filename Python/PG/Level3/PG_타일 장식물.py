def solution(N):
    dp = [[1,1] for _ in range(N+1)]
    for n in range(2, N+1):
        dp[n][0] = dp[n-1][1]
        dp[n][1] = dp[n-1][0] + dp[n][0]
    return 2 * (dp[N][0] + dp[N][1])


print(solution(6))