def solution(d, budget):
    answer = 0
    d.sort()
    if sum(d) <= budget:
        answer = len(d)
    else:
        idx = 0
        for money in d:
            if idx + money <= budget:
                idx += money
                answer += 1
    return answer


print(solution([1, 3, 2, 5, 4], 9))
print(solution([2, 2, 3, 3], 10))