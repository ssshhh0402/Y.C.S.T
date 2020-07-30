# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N = int(input())
answer = 0
for number in range(1, N+1):
	if not N % number:
		answer += number

print(answer)