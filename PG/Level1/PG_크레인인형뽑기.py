def solution(board, moves):
    answer = 0
    N = len(board)
    base = []
    for direction in moves:
        for i in range(N):
            if board[i][direction-1] != 0:
                base.append(board[i][direction-1])
                board[i][direction-1] = 0
                if len(base) >= 2:
                    if base[-1] == base[-2]:
                        base.pop()
                        base.pop()
                        answer += 1
                break
    return answer*2


a = solution([[0,0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]], [1, 5, 3, 5, 1, 2, 1, 4])
print(a)