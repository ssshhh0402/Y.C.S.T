def solution(A, B):
    answer = 0
    A.sort()
    B.sort()
    if min(A) >= max(B):
        return answer
    else:
        for a in A:
            for b in B:
                if a < b:
                    answer += 1
                    B.remove(b)
                    break
    return answer


print(solution([5, 1, 3, 7], [2, 2, 6, 8]))