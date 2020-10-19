def solution(x, n):
    answer = []
    item = x
    while len(answer) != n:
        answer.append(item)
        item += x
    return answer


print(solution(2, 5))
