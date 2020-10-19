import sys

N = int(sys.stdin.readline())
base = [0 for _ in range(N+1)]
dp = [0 for _ in range(N+1)]
for idx in range(1, N+1):
    base[idx] = int(sys.stdin.readline())

for index in range(1, N+1):
    if index == 1:
        dp[1] = base[1]
    elif index == 2:
        dp[index] = base[1]+base[2]
    else:
        dp[index] = max(dp[index-3]+base[index-1]+base[index], dp[index-2] + base[index])

print(dp[N])