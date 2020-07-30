# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
N = int(input())
flag = 0
for i in range(2, N):
    if not N % i:
        flag = 1
        break

if not flag:
    print("True")
else:
    print("False")
