def solution(n,money):
    answer = 0
    N = len(money)
    dp = [[[0] for _ in range(N)] for _ in range(N)]
    for x in range(len(money)):
        for y in range(len(money)):
            if not x or not y:
                dp[x][y] = 1
            else:
                dp[x][y] = dp[x-1][y] + dp[x][y-1]

    return answer

print(solution(5,[1,2,5]))