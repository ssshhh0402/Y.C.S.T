def check(dx, dy, leng, board):
    temps = board[dx][dy]
    for x in range(dx, dx+leng):
        for y in range(dy, dy+leng):
            if board[x][y] != temps:
                return False
    return True


def solution(arr):
    answer = []
    base = {0: [], 1: []}
    n = leng = len(arr)
    used = [[0 for _ in range(n+1)] for _ in range(n+1)]
    while True:

        for x in range(0, n, leng):
            for y in range(0, n, leng):
                if check(x, y, leng, arr) and used[x][y] != -1:
                    for dx in range(x, x + leng):
                        for dy in range(y, y + leng):
                            used[dx][dy] = -1
                    base[arr[x][y]].append((x, y))
        if leng // 2 == 0:
            break
        else:
            leng = leng // 2
    for idx in range(2):
        answer.append(len(base[idx]))
    return answer


print(solution([[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]))
print(solution([[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]))
