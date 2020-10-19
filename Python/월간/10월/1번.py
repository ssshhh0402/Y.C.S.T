def toTri(n):
    answer = ''
    while True:
        a, b = n // 3, n % 3
        if a != 0:
            answer += str(b)
            n = a
        else:
            answer += str(b)
            break
    return answer
def fromTri(n):
    answer = 0
    for idx in range(len(n)):
        target = len(n) - idx - 1
        answer += int(n[target]) * (3 ** idx)
    return answer
def solution(n):
    tri = toTri(n)
    answer = fromTri(tri)
    return answer



print(solution(45))
print(solution(125))