def solution(n, edges):
    from collections import deque
    answer = 0
    base = [[0 for _ in range(n+1)] for _ in range(n+1)]
    values = [[0 for _ in range(n+1)] for _ in range(n+1)]
    for start, end in edges:
        base[start][end] = 1
    for idx in range(1,n+1):
        dq = deque([idx])
        count = 0
        while dq:
            for _ in range(len(dq)):
                now = dq.popleft()
                for toGo in range(n+1):
                    if base[now][toGo] == 1:
                        dq.append(toGo)
                        values[idx][toGo] = count + 1
            count += 1
    return answer



print(solution(4, [[1,2],[2,3],[3,4]]))
print(solution(5, [[1,5],[2,5],[3,5],[4,5]]	))
