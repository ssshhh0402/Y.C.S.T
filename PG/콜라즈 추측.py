def solution(num):
    answer = 0
    while answer != 501:
        if num == 1:
            return answer
        else:
            if num % 2 == 0:
                num = num // 2
            else:
                num = num*3 + 1
        answer += 1
    return -1


print(solution(6))
print(solution(16))
print(solution(626331))
