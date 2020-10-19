def solution(arr1, arr2):
    answer = []
    for idx in range(len(arr1)):
        row = []
        for idx2 in range(len(arr1[idx])):
            row.append(arr1[idx][idx2] + arr2[idx][idx2])
        answer.append(row)
    return answer

print(solution([[1,2],[2,3]],[[3,4],[5,6]]))
print(solution([[1],[2]],[[3],[4]]))