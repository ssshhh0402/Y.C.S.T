def solution(A):
    answer = 0
    count = 1
    turned = [False for _ in range(len(A))]
    while count < max(A)+1:
        flag = False
        target = A.index(count)
        turned[target] = True
        for i in range(target):
            if A[i] > count:
                flag = True
                break
        for i in range(target+1, len(A)):
            if not turned[i]:
                flag = True
                break
        if not flag:
            answer += 1
        count += 1
    return answer


#print(solution([2, 1, 3, 5, 4]))    #3
print(solution([2, 3, 4, 1, 5]))    #2
print(solution([1, 3, 4, 2, 5]))    #3