# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N = int(input())
for _ in range(N):
	sentence = input()
	if 'a' in sentence or 'e' in sentence or 'i' in sentence or 'o' in sentence or 'u' in sentence or 'A' in sentence or 'E' in sentence or 'I' in sentence or 'O' in sentence or 'U' in sentence:
		answer = ''
		for word in sentence:
			if word.lower() in ['a','e','i','o','u']:
				answer += word
		print(answer)
	else:
		print('???')
