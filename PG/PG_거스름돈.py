def solution(n,money):
    answer = 0
    dp = [[[0] for _ in range(len(money))] for _ in range(len(money))]
    for x in range(len(money)):
        for y in range(len(money)):
            if not x or not y:
                dp[x][y] = 1
            else:
                dp[x][y] = dp[x-1][y] + dp[x][y-1]

    return answer

print(solution(5,[1,2,5]))