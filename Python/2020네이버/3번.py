def find(numbers, target):
    answer = 0
    for idx in range(target):
        numA, numB = idx, target - idx
        answer += numbers[numA]
        answer += numbers[numB]
        answer += (numbers[numA] * numbers[numB])
    return answer
def solution(k):
    answer = 0
    numbers = [0, 0, 1, 1, 1, 3, 3, 1]
    dp = []
    for idx in range(k):
        newOne = find(numbers, idx)
        dp.append(newOne)
    return answer


print(solution(5))
print(solution(6))
print(solution(11))
print(solution(1))
