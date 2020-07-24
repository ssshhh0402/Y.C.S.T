def solution(n, vertex):
    answer = 0
    base = [[] for _ in range(n+1)]
    for vert in vertex:
        base[vert[0]].append(vert[1])
        base[vert[1]].append(vert[0])

    return answer

print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))