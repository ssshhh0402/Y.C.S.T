def find(idx, count, A):
    global answer
    flag = False
    for i in range(len(A) - 1):
        if A[i] == A[i+1]:
            flag = True
            break
    if flag:
        for i in range(idx+1, len(A)):
            if A[i] == 1:
                A[i] = 0
                find(i+1, count+1, A)
                A[i] = 1
            else:
                A[i] = 1
                find(i+1, count+1, A)
                A[i] = 0
    else:
        answer = count

def solution(A):
    global answer
    answer = 0
    for i in range(len(A)):
        if A[i] == 1:
            A[i] = 0
            find(i+1, 1, A)
            A[i] = 1
        else:
            A[i] = 1
            find(i+1, 1, A)
            A[i] = 0
    return answer


print(solution([1, 0, 1, 0, 1, 1]))
print(solution([1, 1, 0, 1, 1]))
print(solution([0, 1, 1, 0]))