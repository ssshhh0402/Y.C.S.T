def solution(n):
    dp = [0 for _ in range(n+1)]
    for num in range(1, n+1):
        if num == 1:
            dp[num] = 1
        elif num == 2:
            dp[num] = 2
        else:
            dp[num] = (dp[num-1] + dp[num-2]) % 1234567
    return dp[n]


print(solution(4))
print(solution(3))