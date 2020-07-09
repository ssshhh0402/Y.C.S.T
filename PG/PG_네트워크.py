from collections import deque

def solution(n, computers):
    answer = 0
    connected = [deque([]) for _ in range(n)]
    for x in range(n):
        for y in range(n):
            if computers[x][y] and x != y:
                connected[x].append(y)
    used = [0 for _ in range(n)]
    idx = 0
    while 0 in used and idx < n:
        if not used[idx]:
            items = connected[idx]
            while items:
                now = items.popleft()
                used[now] = 1
                for toGo in connected[now]:
                    if not used[toGo]:
                        used[toGo] = 1
                        items.append(toGo)
            answer += 1
        idx += 1
    return answer

print(solution(3,[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	))
print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))