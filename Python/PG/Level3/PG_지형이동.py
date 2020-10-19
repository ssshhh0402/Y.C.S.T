def find_height(board, height,maps, table):
    dirs = [(0,1),(1,0),(0,-1),(-1,0)]
    n = len(maps)
    for x in range(n):
        for y in range(n):
            dx = x + 1
            dy = y + 1
            if dx < n and board[x][y] != board[dx][dy]:
                a, b = min(board[x][y], board[x][dy]), max(board[x][y], board[x][dy])
                table[(a,b)] = min(table[(a,b)], abs(maps[x][y] - maps[x][dy]))
            if dy < n and board[dy][x] != board[y][x]:
                a, b = min(board[dx][y],board[x][y]), max(board[dx][y],board[x][y])
                table[(a,b)] = min(table[(a,b)], abs(maps[dx][y] - maps[x][y]))


def solution(land, height):
    from collections import deque, defaultdict
    import math
    n = len(land)
    board = [[0 for _ in range(n)] for _ in range(n)]
    count = 1
    answer = 0
    for x in range(n):
        for y in range(n):
            if not board[x][y]:
                board[x][y] = count
                dq = deque([(x, y)])
                while dq:
                    start_x, start_y = dq.popleft()
                    for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                        next_x, next_y = start_x + dx, start_y + dy
                        if 0 <= next_x < n and 0 <= next_y < n:
                            if not board[next_x][next_y] and abs(land[start_x][start_y]-land[next_x][next_y]) <= height:
                                board[next_x][next_y] = count
                                dq.append((next_x, next_y))
                count += 1
    table = defaultdict(lambda: math.inf)
    find_height(board,height,land,table)
    return answer
#print(solution([[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]], 3))
print(solution([[10, 11, 10, 11], [2, 21, 20, 10], [1, 20, 21, 11], [2, 1, 2, 1]], 1))