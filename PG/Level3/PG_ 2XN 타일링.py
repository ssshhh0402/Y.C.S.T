def solution(n):
    dp = [0 for _ in range(n+1)]
    for idx in range(1, n+1):
        if idx == 1:
            dp[idx] = 1
        elif idx == 2:
            dp[idx] = 2
        else:
            dp[idx] = (dp[idx-1] + dp[idx-2]) % 1000000007
    return dp[n]

print(solution(4))