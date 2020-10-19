def solution(boards):
    from collections import deque
    answer = 0
    N = len(boards)
    visited = [[0 for _ in range(N)] for _ in range(N)]
    visited[0][0] = 1
    dq = deque([(0, 0, 'S', 0)])

    def getCost(idi, di, icost):
        if idi == 'S':
            return icost + 100
        if idi in ['R', 'L'] and di in ['U', 'D'] or idi in ['U', 'D'] and di in ['R', 'L']:
            return icost + 600
        else:
            return icost + 100
    while dq:
        for _ in range(len(dq)):
            ix, iy, idi, icost = dq.popleft()
            if ix == N-1 and iy == N-1:
                if not answer:
                    answer = icost
                else:
                    answer = min(answer, icost)
            else:
                for dx, dy, di in [(0, 1, 'R'), (0, -1, 'L'), (1, 0, 'D'), (-1, 0, 'U')]:
                    x, y, z = ix+dx, iy+dy, getCost(idi, di, icost)
                    if 0 <= x < N and 0 <= y < N and not boards[x][y]:
                        if not visited[x][y] or visited[x][y] >= z:
                            visited[x][y] = z
                            dq.append((x, y, di, z))
    return answer


# print(solution([[0, 0, 0], [0, 0, 0], [0, 0, 0]]))
print(solution([[0, 0, 1, 0], [0, 0, 0, 0], [0, 1, 0, 1], [1, 0, 0, 0]]))