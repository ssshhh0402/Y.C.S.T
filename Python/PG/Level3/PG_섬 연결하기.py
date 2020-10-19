def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x:x[2])
    visited = [0 for _ in range(n)]
    visited[0] = 1
    while sum(visited) != n:
        for cost in costs:
            start, end, cos = cost
            if visited[start] or visited[end]:
                if visited[start] and visited[end]:
                    continue
                else:
                    visited[start] = 1
                    visited[end] = 1
                    answer += cos
                    break
    return answer

print(solution(4, [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]]))