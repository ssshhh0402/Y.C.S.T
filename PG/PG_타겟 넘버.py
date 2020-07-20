def find(numbers, finds, target):
    idx = 0
    if len(numbers) == len(finds):
        if sum(finds) == target:
            return 1
        else:
            return 0
    else:
        target_1 = finds
        target_1.append(numbers[len(finds)])
        idx += find(numbers, target_1, target)
        target_1.pop()
        target_1.append(-(numbers[len(finds)]))
        idx += find(numbers, target_1, target)
        return idx
def solution(numbers, target):
    answer = 0
    answer += find(numbers, [numbers[0]], target)
    answer += find(numbers, [-numbers[0]], target)
    return answer


print(solution([1, 2, 3, 4, 5], 3))