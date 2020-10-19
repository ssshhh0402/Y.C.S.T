def solution(weight):
    weight.sort()
    answer = weight[0]
    for idx in range(1, len(weight)):
        if weight[idx] > answer + 1:
            break
        else:
            answer += weight[idx]
    return answer + 1
print(solution([3, 1, 6, 2, 7, 30, 1]))