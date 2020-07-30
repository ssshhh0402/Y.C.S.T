# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N,M = input().split(" ")
moneys = input().split(" ")
for _ in range(int(M)):
	start, end = input().split(' ')
	answer = 0
	for day in range(int(start)-1, int(end)):
		answer += int(moneys[day])
	if answer < 0:
		print(answer)
	else:
		print("+" + str(answer))

