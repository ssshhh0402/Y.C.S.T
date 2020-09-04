def find(x, y, value, board):
    flag = False
    for dx in range(x,x-3,-1):
        flag_two = 2
        for dy in range(y, y-2, -1):
            if board[dx][dy] != 0:
                if board[dx][dy] == value:
                    continue
                else:
                    flag_two -= 1

def solution(board):
    answer = 0
    blocks = {}
    n = len(board)
    checked= []
    for x in range(n-1, -1, -1):

        for y in range(n):
            if board[x][y]:
                find(x, y, board[x][y], board)
    return answer


print(solution([[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,4,0,0,0],[0,0,0,0,0,4,4,0,0,0],[0,0,0,0,3,0,4,0,0,0],[0,0,0,2,3,0,0,0,5,5],[1,2,2,2,3,3,0,0,0,5],[1,1,1,0,0,0,0,0,0,5]]))