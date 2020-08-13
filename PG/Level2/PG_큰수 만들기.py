def solution(number, k):
    answer = ''
    base = list(map(int, list(number)))
    n = len(number)
    idx = 0
    target = n - k
    while len(answer) != target:
        temp = max(base[idx:target+1])
        idx = base.index(temp) + 1
        answer += str(temp)
    return answer


print(solution("1924", 2))