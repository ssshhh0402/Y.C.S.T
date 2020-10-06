def solution(maze):
    n = len(maze)
    left = [[0,1],[-1,0],[0,-1],[1,0]]
    walk = [[1,0],[0,1],[-1,0],[0,-1]]
    now_x, now_y, pos, time = 0,0,0,0
    answer = 0
    while True:
        if now_x == n-1 and now_y == n-1:
            answer = time
            break
        if pos == 0 and now_x == n -1:
            pos = 1
            continue
        elif pos == 1 and now_y == n -1:
            pos = 0
            continue
        elif pos == 2 and now_x == 0:
            pos = 3
            continue
        elif pos == 3 and now_y == 0:
            pos = 0
            continue

        wallC_x, wallC_y = now_x + left[pos][0], now_y + left[pos][1]
        if 0 <= wallC_x < n and 0 <= wallC_y < n:
            if maze[wallC_x][wallC_y]:
                now_x, now_y = now_x + walk[pos][0], now_y + walk[pos][1]
                time += 1
            else:
                pos += 1
                if pos == 4:
                    pos = 0
                now_x, now_y = wallC_x, wallC_y
                time += 1
        elif wallC_y == n:
            now_x, now_y = now_x + walk[pos][0], now_y + walk[pos][1]
            time += 1
    return answer


print(solution([[0, 1, 0, 1], [0, 1, 0, 0], [0, 0, 0, 0], [1, 0, 1, 0]]))
print(solution([[0, 1, 0, 0, 0, 0], [0, 1, 0, 1, 1, 0], [0, 1, 0, 0, 1, 0], [0, 1, 1, 1, 1, 0], [0, 1, 0, 0, 0, 0], [0, 0, 0, 1, 1, 0]]	))
print(solution([[0, 1, 0, 0, 0, 0], [0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 1, 0], [0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 0]]	))
print(solution([[0, 0, 0, 0, 0, 0], [1, 1, 1, 0, 1, 1], [0, 0, 0, 0, 0, 0], [1, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 0], [1, 1, 0, 1, 1, 0]]	))