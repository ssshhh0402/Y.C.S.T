def solution(n, arr1, arr2):
    answer = []
    for idx in range(n):
        temp = ''
        left = format(arr1[idx], 'b')
        right = format(arr2[idx], 'b')
        left_size = n - len(left)
        right_size = n - len(right)
        left = '0' * left_size + left
        right = '0' * right_size + right
        for i in range(n):
            if left[i] == '0' and right[i] == "0":
                temp += " "
            else:
                temp += "#"
        answer.append(temp)
    return answer

print(solution(5,[9, 20, 28, 18, 11],[30, 1, 21, 17, 28]))