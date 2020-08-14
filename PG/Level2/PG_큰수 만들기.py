def solution(number, k):
    answer = ''
    comp = -1
    N = len(number)
    base = list(map(int, list(number)))
    target = N - k
    while len(answer) == target:
        temp = 0
        n = len(answer)
        for j in range(comp+1, k+n+1):
            if temp < base[j]:
                comp = j
                temp = base[j]
        answer += str(temp)
    return answer


# print(solution("1924", 2))
print(solution("1231234", 3))