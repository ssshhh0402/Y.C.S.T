n = int(input())
dp = [0 for _ in range(n+1)]

for idx in range(3, n+1):
    if idx == 3 or idx == 5:
        dp[idx] = 1
    else:
        a = dp[idx-3]
        b = dp[idx-5]
        if b:
            dp[idx] = b + 1
        elif a:
            dp[idx] = a + 1

if dp[n] == 0:
    print(-1)
else:
    print(dp[n])