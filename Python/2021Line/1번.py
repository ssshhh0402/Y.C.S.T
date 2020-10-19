def solution(boxes):
    answer = -1
    base = {}
    count = 0
    for box in boxes:
        for num in box:
            if num in base.keys():
                base[num] += 1
            else:
                base[num] = 1
    for 
    return answer


print(solution([[1, 2], [2, 1], [3, 3],[4, 5], [5, 6], [7, 8]]))
print(solution([[1, 2], [3, 4], [5, 6]]))
print(soluiton([[1, 2], [2, 3], [3, 1]]))