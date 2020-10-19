import sys
sys.setrecursionlimit(10**9)
def find(target, n):
    answer = 1
    while True:
        a, b = target // n, target % n
        if a != 0:
            if b != 0:
                answer *= int(b)
            target = a
        else:
            if b != 0:
                answer *= int(b)
            break
    return answer
def solution(N):
    value = 0
    key = 0
    for idx in range(2, 10):
        temps = find(N, idx)
        if temps >= value:
            value = temps
            key = idx
    answer = [key, value]
    return answer


print(solution(10))
print(solution(14))