def solution(arr1, arr2):
    answer = []
    for i_x in range(len(arr1)):
        items = []
        for i_y in range(len(arr2[0])):
            target = 0
            for item in range(len(arr1[0])):
                target += (arr1[i_x][item] *arr2[item][i_y])
            items.append(target)
        answer.append(items)

    return answer


# print(solution([[1, 4], [3, 2], [4, 1]],[[3, 3], [3, 3]]))
# print(solution([[2, 3, 2], [4, 2, 4], [3, 1, 4]],[[5, 4, 3], [2, 4, 1], [3, 1, 1]]))
print(solution([[1, 2, 3], [4, 5, 6]],[[1, 4], [2, 5], [3, 6]]))