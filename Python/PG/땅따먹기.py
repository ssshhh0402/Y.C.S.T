def solution(land):
    N = len(land)
    dp = [[0 for _ in range(4)] for _ in range(N)]
    for x in range(N):
        if x == 0:
            for y in range(4):
                dp[x][y] = land[x][y]
        else:
            for y in range(4):
                max_n = 0
                for f_y in range(4):
                    if y != f_y and dp[x-1][f_y] + land[x][y] > max_n:
                        max_n = dp[x-1][f_y] + land[x][y]
                dp[x][y] = max_n
    return max(dp[N-1])


a = solution([[1, 2, 3,5],[5,6,7,8],[4,3,2,1]])
print(a)
