import sys
N = int(sys.stdin.readline())
dp = [[0 for _ in range(10)] for _ in range(N+1)]
for idx in range(1, 10):
    dp[1][idx] = 1
for x in range(2, N+1):
    for y in range(10):
        if y == 0:
            dp[x][y] = (dp[x-1][y+1]) % 1000000000
        elif y == 9:
            dp[x][y] = dp[x-1][y-1] % 1000000000
        else:
            dp[x][y] = (dp[x-1][y-1] + dp[x-1][y+1]) % 1000000000
print(sum(dp[N]) % 1000000000)