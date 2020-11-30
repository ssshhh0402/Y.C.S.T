def solution(A):
    B = set(sorted(A))
    n = 0
    if max(A) < 0:
        return 1
    else:
        n = max(A)
    for idx in range(1, n+2):
        if idx not in B:
            return idx




print(solution([1, 3, 6, 4, 1, 2]))
print(solution([-3,-1]))
print(solution([1,2,3]))