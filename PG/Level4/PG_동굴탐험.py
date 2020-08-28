def solution(n, path, order):
    from collections import deque
    answer = True
    base = [[] for _ in range(n)]   #n번째 인덱스에서 가는 아이들
    visited = [[0 for _ in range(n)] for _ in range(n)]
    for start, end in path:
        base[start].append(end)

    for start, end in order:
        visited[end][start] = 1
    dq = deque([0])
    for next in base[0]:
        if sum(visited[next]):
            if visited[next][0] == 1:
                visited[next][0] = 0
                dq.append(next)
                find(dq,base,visited)
        else:
            dq.append(next)
            find(dq, base, visited)


print(solution(9,[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]],[[8, 5], [6, 7],[4,1]]))
