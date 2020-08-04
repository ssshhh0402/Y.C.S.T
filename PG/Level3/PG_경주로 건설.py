def solution(boards):
    from collections import deque
    answer = 0
    N = len(boards)
    visited = [[0 for _ in range(N)] for _ in range(N)]
    dq = deque([(1, 0, 'D', 100), (0, 1, 'R', 100)])
    for item in dq:
        visited[item[0]][item[1]] = 1
    while deque:
        for _ in range(len(dq)):
            ix, iy, idi, icost = dq.popleft()
            if ix == N-1 and iy == N-1:
                if not answer:
                    answer = icost
                else:
                    answer = min(answer, icost)
                continue
            for dx, dy, di in [(0,1,'R'), (0,-1,'L')]:
                x, y = ix+dx, iy+dy
                if 0 <= x < N and 0 <= y < N and not visited[x][y] and not boards[x][y]:
                    visited[x][y] = 1
                    if idi in ['R', 'L']:
                        dq.append((x,y,di,icost+100))
                    else:
                        dq.append((x,y,di,icost+500))
            for dx, dy, di in [(1,0,'D'), (-1,0,'U')]:
                x, y = ix+dx, iy+dy
                if 0 <= x < N and 0 <= y < N and not visited[x][y] and not boards[x][y]:
                    visited[x][y] = 1
                    if idi in ['D', 'U']:
                        dq.append((x, y, di, icost+100))
                    else:
                        dq.append((x, y, di, icost+500))
    return answer


print(solution([[0, 0, 0], [0, 0, 0], [0, 0, 0]]))