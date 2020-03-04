import sys

N = int(sys.stdin.readline())
base = []
for _ in range(N):
    base.append(list(map(int, sys.stdin.readline().split())))
dp = [[-1 for _ in range(N)] for _ in range(N)]

for i in range(N):
    if i == 0:
        dp[0][0] = base[0][0]
    elif i == 1:
        dp[1][0] = base[0][0] + base[1][0]
        dp[1][1] = base[0][0] + base[1][1]
    else:
        for j in range(len(base[i])):
            if j == 0:
                dp[i][j] = dp[i-1][j] + base[i][j]
            elif j == len(base[i]) - 1:
                dp[i][j] = dp[i-1][j-1] + base[i][j]
            else:
                dp[i][j] = max(dp[i-1][j-1] + base[i][j], dp[i-1][j] + base[i][j])
answer = 0
for idx in range(len(base[N-1])):
    answer = max(answer,dp[N-1][idx])

print(answer)