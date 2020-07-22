def solution(n):
    index = ["4", "1", "2"]
    answer = ''
    while n:
        a = n // 3
        b = n % 3
        if b == 0:
            n = a - 1
        else:
            n = a
        answer = index[b] + answer
    return answer


a = solution(1)
b = solution(2)
c = solution(3)
d = solution(4)
print(a)
print(b)
print(c)
print(d)