def solution(board):
    from collections import deque
    answer = 0
    N = len(board)
    dq = deque([((0, 0), (0, 1), 0 )])
    visited = []
    while dq:
        for _ in range(len(dq)):
            left, right, time = dq.popleft()
            if left == (N-1, N-1) or right == (N-1, N-1):
                if not answer:
                    answer = time
                else:
                    answer = min(answer, time)
                continue
            else:
                for dx, dy in [(0,1), (1,0), (0,-1), (0,-1)]:
                    new_left, new_right = (left[0] + dx, left[1] + dy), (right[0] + dx, right[1] + dy)
                    if 0 <= new_left[0] < N and 0 <= new_left[1] and 0 <= new_right[0] < N and 0 <= new_right[1] < N:
                        if (left, right, new_left, new_right) not in visited and board[new_left[0]][new_left[1]] and board[new_right[0]][new_right[1]]:
                            visited.append((left, right, new_left, new_right))
                            dq.append((new_left, new_right, time + 1))
                if left[0] == right[0]:             # 위- 아래일직선
                    # 오른쪽 기준 회전
                    flag_right = False
                    flag_left = False
                    for dx, dy in [(1, 1), (0, 1)]:
                        new_right = (left[0] + dx, left[1] + dy)
                        if 0 <= new_right[0] < N and 0 <= new_right[1]:
                            if board[new_right[0]][new_right[1]] == 1:
                                flag_right = True
                                break
                        else:
                            flag_right = True
                            break
                    for dx, dy in [(-1,-1), (0,-1)]:
                        new_right = (left[0] + dx, left[1] + dy)
                        if 0 <= new_right[0] < N and 0 <= new_right[1]:
                            if board[new_right[0]][new_right[1]] == 1:
                                flag_left = True
                                break
                        else:
                            flag_left = True
                            break
                    if not flag_right:
                        new_right = (left[0] + 1, left[1] + 1)
                        if (left, right, right, new_right) not in visited:
                            visited.append((left, right, right, new_right))
                            dq.append((right, new_right, time + 1))
                    if not flag_left:
                        new_left = (left[0] - 1, left[1] - 1)
                        if (left, right, new_left, right) not in visited:
                            visited.append((left, right, new_left, right))
                            dq.append((new_left, right, time+1))
                    # 왼쪽 기준 회전
                    flag_left = False
                    flag_right = False
                    for dx, dy in [(0,-1), (-1, -1)]:
                        new_right = (right[0] + dx, right[1] + dy)
                        if 0 <= new_right[0] < N and 0<= new_right[1] < N:
                            if board[new_right[0]][new_right[1]] == 1:
                                flag_left = True
                                break
                        else:
                            flag_left = True
                            break
                    for dx, dy in [(0,1), (-1, 1)]:
                        new_right = (right[0] + dx, right[1] + dy)
                        if 0 <= new_right[0] < N and 0 <= new_right[1] < N:
                            if board[new_right[0]][new_right[1]] == 1:
                                flag_right = True
                                break
                        else:
                            flag_right = True
                            break
                    if not flag_left:
                        new_left = right[0] - 1, right[1] - 1
                        if (left, right, new_left, right) not in visited:
                            visited.append((left, right, new_left, right))
                            dq.append((new_left, right, time + 1))
                    if not flag_right:
                        new_right = right[0] -1, right[1] + 1
                        if (left, right, left, new_right) not in visited:
                            visited.append((left, right, new_left, right))
                            dq.append((new_left, right, time + 1))
                elif left[1] == right[1]:   # 좌-우 일직선
                    #오른쪽 기준 회전
                    #왼쪽 기준 회전



    return answer