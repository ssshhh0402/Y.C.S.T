# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N = (input().split(' '))
answer = 0
for number in range(int(N[0]), int(N[1])+1):
	if number % 2 != 0:
		answer += number

print(answer)