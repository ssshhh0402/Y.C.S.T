def solution(A):
    answer = 0
    inf = 1000000000
    if A == [0 for _ in range(len(A))]:
        result = (len(A) * len(A)+1) / 2
        if result > inf:
            return -1
        else:
            return result
    for i in range(len(A)):
        sum = 0
        for j in range(i, len(A)):
            sum += A[j]
            if sum == 0:
                answer += 1
                if answer > inf:
                    return -1

    return answer


#print(solution([2,-2,3,0,4,-7]))
#print(solution([0 for _ in range(1000000000)]))
#print(solution([1 for _ in range(1000000000)]))
print(solution([0,0,0,0]))