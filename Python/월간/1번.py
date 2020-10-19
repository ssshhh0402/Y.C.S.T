def solution(numbers):
    answer = []
    for idx in range(len(numbers)):
        base = numbers[idx]
        for idx2 in range(idx+1, len(numbers)):
            n = base + numbers[idx2]
            if n not in answer:
                answer.append(n)
    answer.sort()
    return answer


print(solution([2,1,3,4,1]))
