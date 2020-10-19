# def solution(board):
#     from collections import deque
#     answer = 0
#     N = len(board)
#     dq = deque([((0, 0), (0, 1), 0)])
#     visited = []
#     while dq:
#         items = len(dq)
#         for _ in range(items):
#             left, right, time = dq.popleft()
#             if left == (N-1, N-1) or right == (N-1, N-1):
#                 if not answer:
#                     answer = time
#                 else:
#                     answer = min(answer, time)
#             else:
#                 for dx, dy in [(0,1), (1,0), (0,-1), (0,-1)]:
#                     new_left, new_right = (left[0] + dx, left[1] + dy), (right[0] + dx, right[1] + dy)
#                     if 0 <= new_left[0] < N and 0 <= new_left[1] and 0 <= new_right[0] < N and 0 <= new_right[1] < N:
#                         if (left, right, new_left, new_right) not in visited and not board[new_left[0]][new_left[1]] and not board[new_right[0]][new_right[1]]:
#                             if new_left != (0,0) and new_right != (0,1):
#                                 visited.append((left, right, new_left, new_right))
#                                 dq.append((new_left, new_right, time + 1))
#                 if left[1] == right[1]:             # 위- 아래일직선
#                     # 오른쪽 기준 회전
#                     flag_right = False
#                     flag_left = False
#                     for dx, dy in [(1, 1), (0, 1)]:
#                         new_right = (left[0] + dx, left[1] + dy)
#                         if 0 <= new_right[0] < N and 0 <= new_right[1] < N:
#                             if board[new_right[0]][new_right[1]] == 1:
#                                 flag_right = True
#                                 break
#                         else:
#                             flag_right = True
#                             break
#                     for dx, dy in [(-1,-1), (0,-1)]:
#                         new_right = (left[0] + dx, left[1] + dy)
#                         if 0 <= new_right[0] < N and 0 <= new_right[1]:
#                             if board[new_right[0]][new_right[1]] == 1:
#                                 flag_left = True
#                                 break
#                         else:
#                             flag_left = True
#                             break
#                     if not flag_right:
#                         new_right = (left[0] + 1, left[1] + 1)
#                         if (left, right, right, new_right) not in visited and 0 <= new_right[0] < N and 0 <= new_right[1] < N:
#                             if right != (0,0) and new_right != (0,1):
#                                 visited.append((left, right, right, new_right))
#                                 dq.append((right, new_right, time + 1))
#                     if not flag_left:
#                         new_left = (left[0] - 1, left[1] - 1)
#                         if (left, right, new_left, right) not in visited and 0 <= new_left[0] < N and 0 <= new_left[1] < N :
#                             if new_left != (0,0) and right != (0,1):
#                                 visited.append((left, right, new_left, right))
#                                 dq.append((new_left, right, time+1))
#                     # 왼쪽 기준 회전
#                     flag_left = False
#                     flag_right = False
#                     for dx, dy in [(0,-1), (-1, -1)]:
#                         new_right = (right[0] + dx, right[1] + dy)
#                         if 0 <= new_right[0] < N and 0 <= new_right[1] < N:
#                             if board[new_right[0]][new_right[1]] == 1:
#                                 flag_left = True
#                                 break
#                         else:
#                             flag_left = True
#                             break
#                     for dx, dy in [(0,1), (-1, 1)]:
#                         new_right = (right[0] + dx, right[1] + dy)
#                         if 0 <= new_right[0] < N and 0 <= new_right[1] < N:
#                             if board[new_right[0]][new_right[1]] == 1:
#                                 flag_right = True
#                                 break
#                         else:
#                             flag_right = True
#                             break
#                     if not flag_left:
#                         new_left = right[0] - 1, right[1] - 1
#                         if (left, right, new_left, right) not in visited and 0 <= new_left[0] < N and 0 <= new_left[1] < N:
#                             if new_left != (0,0) and right != (0,1):
#                                 visited.append((left, right, new_left, right))
#                                 dq.append((new_left, right, time + 1))
#                     if not flag_right:
#                         new_right = right[0] -1, right[1] + 1
#                         if (left, right, left, new_right) not in visited and 0 <= new_right[0] < N and 0 <= new_right[1] < N:
#                             if new_left != (0,0) and right != (0,1):
#                                 visited.append((left, right, new_left, right))
#                                 dq.append((new_left, right, time + 1))
#                 elif left[0] == right[0]:   # 좌-우 일직선
#                     #오른쪽 기준 회전
#                     flag_left = False
#                     flag_right = False
#                     for dx, dy in [(1,0),(1,1)]:
#                         new_right = (left[0] + dx, left[1] + dy)
#                         if 0 <= new_right[0] < N and 0 <= new_right[1]:
#                             if board[new_right[0]][new_right[1]] == 1:
#                                 flag_right = True
#                                 break
#                         else:
#                             flag_right = False
#                     for dx, dy in [(-1, 0),(-1,1)]:
#                         new_right = (left[0] + dx, left[1] + dy)
#                         if 0 <= new_right[0] < N and 0 <= new_right[1]:
#                             if board[new_right[0]][new_right[1]] == 1:
#                                 flag_left = True
#                                 break
#                         else:
#                             flag_left = True
#                             break
#                     if not flag_right:
#                         new_left = left[0] + 1, left[1] + 1
#                         if (left, right, new_left, right) not in visited and 0<= new_left[0] < N and 0 <= new_left[1] < N:
#                             if new_left != (0,0) and right != (0,1):
#                                 visited.append((left, right, new_left, right))
#                                 dq.append((new_left, right, time + 1))
#                     if not flag_left:
#                         new_left = left[0] + 1, left[1] + 1
#                         if (left, right, new_left, right) not in visited and 0<= new_left[0] < N and 0 <= new_left[1] < N:
#                             if new_left != (0,0) and right != (0,1):
#                                 visited.append((left, right, new_left, right))
#                                 dq.append((new_left, right, time + 1))
#                     #왼쪽 기준 회전
#                     flag_left = False
#                     flag_right = False
#                     for dx, dy in [(-1,-1),(-1,0)]:
#                         new_left = right[0] + dx, right[1] + dy
#                         if 0 <= new_left[0] < N and 0 <= new_left[1] < N:
#                             if board[new_left[0]][new_left[1]] == 1:
#                                 flag_left = True
#                                 break
#                         else:
#                             flag_left = False
#                             break
#                     for dx, dy in [(1, -1), (1, 0)]:
#                         new_right = right[0] + dx, right[1] + dy
#                         if 0 <= new_right[0] < N and 0 <= new_right[1] < N:
#                             if board[new_right[0]][new_right[1]] == 1:
#                                 flag_right = True
#                                 break
#                         else:
#                             flag_right = True
#                             break
#                     if not flag_left:
#                         new_left = right[0] -1, right[1] - 1
#                         if (left, right, new_left, right) not in visited and 0<= new_left[0] < N and 0 <= new_left[1] < N:
#                             if new_left != (0,0) and right != (0,1):
#                                 visited.append((left, right, new_left, right))
#                                 dq.append((new_left, right, time + 1))
#                     if not flag_right:
#                         new_right = right[0] + 1, right[1] - 1
#                         if (left, right, left, new_right) not in visited and 0 <= new_right[0] < N and 0 <= new_right[1] < N:
#                             if left != (0,0) and new_right != (0,1):
#                                 visited.append((left, right, left, new_right))
#                                 dq.append((left, new_right, time + 1))
#
#     return answer


def solution(board):
    from collections import deque
    N = len(board)
    dxy = [[1, 0], [0, 1]]
    visit = [[[0, 0] for _ in range(N+1)] for _ in range(N+1)]
    answer = 0
    q = deque()
    visit[0][0][1] = 1
    q.append((0,0,1,0)) # x, y, dir, cnt
    while q:
        x, y, d, cnt = q.popleft()
        if x+dxy[d][0] == N-1 and y + dxy[d][1] == N-1: #종료 조건
            return cnt
        if d == 1:
            if y-1 >= 0:
                if board[x][y-1] == 0 and visit[x][y-1][1] == 0:
                    visit[x][y-1][1] = 1
                    q.append((x,y-1, 1, cnt+1))
            if x+1 < N:
                if board[x+1][y]==0 and board[x+1][y+1]==0 :
                    if visit[x+1][y][1] == 0:
                        visit[x+1][y][1]= 1
                        q.append((x+1, y, 1, cnt+1))
                    if visit[x][y+1][0] == 0:
                        visit[x][y+1][0] = 1
                        q.append((x, y+1, 0, cnt+1))
                    if visit[x][y][0] == 0:
                        visit[x][y][0] = 1
                        q.append((x,y,0, cnt+1))
            if y+2 < N:
                if board[x][y+2] == 0 and visit[x][y+1][1] == 0:
                    visit[x][y+1][1] = 1
                    q.append((x,y+1, 1, cnt+1))
            if x-1 >= 0:
                if board[x-1][y] == 0 and board[x-1][y+1] == 0:
                    if visit[x-1][y][1] == 0:
                        visit[x-1][y][1]= 1
                        q.append((x-1, y, 1, cnt+1))
                    if visit[x-1][y+1][0] == 0:
                        visit[x-1][y+1][0] = 1
                        q.append((x-1, y+1, 0, cnt+1))
                    if visit[x-1][y][0] == 0:
                        visit[x-1][y][0] =1
                        q.append((x-1, y, 0, cnt+1))
        elif d == 0:
            if x-1 >= 0:
                if board[x-1][y] == 0 and visit[x-1][y][0] == 0:
                    visit[x-1][y][0] = 1
                    q.append((x-1,y, 0, cnt+1))
            if y+1 < N:
                if board[x][y+1] == 0 and board[x+1][y+1] == 0 :
                    if visit[x][y+1][0] == 0:
                        visit[x][y+1][0] = 1
                        q.append((x, y+1, 0, cnt+1))
                    if visit[x+1][y][1] == 0:
                        visit[x+1][y][1] = 1
                        q.append((x+1, y, 1, cnt+1))
                    if visit[x][y][1] == 0:
                        visit[x][y][1] = 1
                        q.append((x, y, 1, cnt+1))

            if x+2 < N:
                if board[x+2][y] == 0 and visit[x+1][y][0] == 0:
                    visit[x+1][y][0] = 1
                    q.append((x+1,y, 0, cnt+1))
            if y-1 >= 0:
                if board[x][y-1] == 0 and board[x+1][y-1] == 0:
                    if visit[x][y-1][0] == 0:
                        visit[x][y-1][0]= 1
                        q.append((x, y-1, 0, cnt+1))
                    if visit[x+1][y-1][1] == 0:
                        visit[x+1][y-1][1] = 1
                        q.append((x+1, y-1, 1, cnt+1))
                    if visit[x][y-1][1] == 0:
                        visit[x][y-1][1] =1
                        q.append((x, y-1, 1, cnt+1))
    return answer

print(solution([[0, 0, 0, 1, 1], [0, 0, 0, 1, 0], [0, 1, 0, 1, 1], [1, 1, 0, 0, 1], [0, 0, 0, 0, 0]]))