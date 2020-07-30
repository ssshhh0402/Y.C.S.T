# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
inputs = input()
answer = ''
N,M = inputs.split(' ')
for number in range(int(N), int(M)+1):
    count = 0
    for num in range(1, number):
        if number % num == 0:
            count += num
    if count == number:
        answer += (str(number) + " ")
print(answer)