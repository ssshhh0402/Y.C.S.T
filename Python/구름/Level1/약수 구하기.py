# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N = int(raw_input())
answer = ''
for number in range(1, N + 1):
    if N % number == 0:
        answer += str(number)
        answer += " "

print(answer)
