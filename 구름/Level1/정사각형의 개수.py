# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N = int(input())
answer = 0
for length in range(1, N+1):
    answer += length ** 2

print(answer)