


def solution(numbers, target):
    global answer
    answer = 0
    def find(numbers, finds, target, n):
        global answer
        if n == len(numbers):
            if finds == target:
                answer += 1
        else:
            find(numbers, finds + numbers[n], target, n + 1)
            find(numbers, finds - numbers[n], target, n + 1)

    find(numbers, numbers[0], target, 1)
    find(numbers, -numbers[0], target, 1)
    return answer


print(solution([1, 1, 1, 1, 1], 3))