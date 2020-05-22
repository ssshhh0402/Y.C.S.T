def solution(m,n, board):
    #찾고, 지우고, 당기고 무한 반복
    delete = []
    answer = 0
    for x in range(m-1):
        for y in range(n-1):
            if board[x][y] == board[x+1][y] == board[x][y+1] == board[x+1][y+1]:
                delete.append((x,y))
                                        #2X2 탐색
    if not len(delete):
        return answer
    else:
        for item in delete:
            board[item[0]][item[1]] = 0
            board[item[0]+1][item[1]] = 0
            board[item[0]][item[1]+1] = 0
            board[item[0]+1][item[1]+1] = 0
    for x in board:
        answer += x.count(0)            # 삭제 및 갯수 확인
                                        # 당기는 부분
    for x in range(m-1,-1,-1):
        for y in range(n):
            if board[x][y] == 0:
                count = 0
                dx = x - 1
                while dx >= 0:
                    if board[dx][y] == 0:
                        for dd_x in range(dx,-1,-1):
                            board[dd_x+count][y] = board[dd_x][y]
    return answer