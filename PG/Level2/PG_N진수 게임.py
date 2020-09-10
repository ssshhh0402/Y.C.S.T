def divi(num, n):
    answer = []
    base = "0123456789ABCDEF"
    a, b = num // n, num % n
    if not a:
        answer.append(base[b])
    else:
        answer.extend(divi(a,n))
        answer.append(base[b])
    return answer


def find(n, target):
    answer = []
    idx = 0
    while len(answer) < target:
        answer.extend(divi(idx, n))
        idx += 1
    return answer

def solution(n,t,m,p): # n = 진법, m = 인원수, t = 미리 구할 갯수, p = 튜브의 순서
    answer = ''
    target = m * t
    base = find(n, target)
    for idx in range(t):
        answer += base[p-1 + m *idx]
    return answer


print(solution(2,4,2,1))
#print(solution(16,16,2,1))