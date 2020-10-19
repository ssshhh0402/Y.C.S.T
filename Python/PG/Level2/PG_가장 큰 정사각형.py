def solution(board):

    w = len(board[0])
    h = len(board)
    temp = 0
    for i in range(h):
        temp += sum(board[i])
    if not temp:
        return 0
    else:
        temp = 0
    for x in range(1, h):
        for y in range(1, w):
            if board[x][y] == 1:
                board[x][y] = min(board[x-1][y], board[x-1][y-1],board[x][y-1]) + 1
                if board[x][y] > temp:
                    temp = board[x][y]

    if temp == 0:
        return 1
    else:
        return temp ** 2


print(solution([[0, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [0, 0, 1, 0]]))
print(solution([[0, 0, 1, 1], [1, 1, 1, 1]]))
print(solution([[1,0],[0,0]]))
