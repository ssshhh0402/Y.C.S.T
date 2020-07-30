# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N,M = input().split(" ")
moneys = input().split(" ")
dp = [0 for _ in range(int(N)+1)]

for idx in range(1, int(N)+1):
	if idx == 1:
		dp[1] = int(moneys[0])
	else:
		dp[idx] = dp[idx-1] + int(moneys[idx-1])
for _ in range(int(M)):
	start, end = input().split(" ")
	if start == 1:
		answer = dp[int(end)]
	elif start == end:
		answer = int(moneys[int(start)-1])
	else:
		answer = dp[int(end)] - dp[int(start)-1]
	if answer > 0:
		print('+' + str(answer))
	else:
		print(str(answer))
