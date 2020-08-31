n, k = list(map(int, input().split()))
moneys = []
dp = [0 for _ in range(k+1)]
for _ in range(n):
    a = int(input())
    moneys.append(a)

for i in range(1, k+1):
    temps = []
    for money in moneys:
        if money <= i and dp[i-money] != -1:
            temps.append(dp[i-money])
    if not temps:
        dp[i] = -1
    else:
        dp[i] = min(temps) + 1
print(dp[k])