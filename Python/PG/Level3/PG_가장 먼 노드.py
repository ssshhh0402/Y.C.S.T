def solution(n, vertex):
    from collections import deque
    answer = 0
    base = [[] for _ in range(n+1)]
    for vert in vertex:
        base[vert[0]].append(vert[1])
        base[vert[1]].append(vert[0])
    dq = deque([1])
    check = [0 for _ in range(n+1)]
    check[1] = 1
    while dq:
        answer = len(dq)
        for _ in range(len(dq)):
            start = dq.popleft()
            for end in base[start]:
                if not check[end]:
                    check[end] = 1
                    dq.append(end)
    return answer

print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))