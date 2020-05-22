def solution(n):
    answer = 0
    bp = [1 for _ in range(n+1)]
    for idx in range(2, n+1):
        if bp[idx]:
            k = 2
            while idx * k <= n:
                bp[idx*k] = 0
                k += 1
            answer += 1
    return answer


print(solution(10))
print(solution(5))

