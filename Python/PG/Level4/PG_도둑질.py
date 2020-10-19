def solution(money):
    N = len(money)
    dp = [0 for _ in range(N)]
    dp2 = [0 for _ in range(N)]
    dp[0] = money[0]
    dp2[0] = 0
    dp[1] = max(money[1], dp[0])
    dp2[1] = money[1]
    for idx in range(2, N):
        if idx == N-1:
            dp2[idx] = max(dp2[idx-1], money[idx] + dp2[idx-2])
        else:
            dp[idx] = max(dp[idx-1], money[idx] + dp[idx-2])
            dp2[idx] = max(dp2[idx-1], money[idx] + dp2[idx-2])
    return max(max(dp), max(dp2))

print(solution([1, 2, 3, 1]))