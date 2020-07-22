def solution(n):
    answer = 0
    for start in range(1, n+1):
        su = start
        k = start + 1
        find = False
        while su <= n:
            if su == n:
                find = True
                break
            else:
                su += k
                k += 1
        if find:
            answer += 1
    return answer


print(solution(15))
