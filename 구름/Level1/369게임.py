# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N = int(raw_input())
answer = 0
for number in range(N):
	num = list(str(number))
	for idx in num:
		if idx == '3' or idx == '6' or idx == '9':
			answer += 1
print(answer)