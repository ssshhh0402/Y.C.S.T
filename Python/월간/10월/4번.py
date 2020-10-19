import sys
sys.setrecursionlimit(10 ** 8)


def find(target):
    N = len(target)
    for leng in range(N-1, 0, -1):
        for start in range(0, N-leng):
            if target[start] != target[start + leng]:
                return leng
    return 0

def solution(s):
    answer = 0
    if s.count(s[0]) == len(s):
        return 0
    start = 0
    end = 1
    while start <= end and end < len(s):
        while end < len(s):
            target = s[start:end+1]
            answer += find(target)
            end += 1
        start += 1
        end = start+1
    return answer


print(solution("baby"))
print(solution("oo"))
print(solution("car"))