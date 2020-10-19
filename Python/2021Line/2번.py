def solution(ball, order):
    from collections import deque
    answer = []
    waiting = []
    ball = deque(ball)
    for order_ball in order:
        while waiting:
            flag = False
            for waiting_ball in waiting:
                if waiting_ball == ball[0]:
                    answer.append(waiting_ball)
                    waiting.remove(waiting_ball)
                    ball.popleft()
                    flag = True
                elif waiting_ball == ball[-1]:
                    answer.append(waiting_ball)
                    waiting.remove(waiting_ball)
                    ball.pop()
                    flag = True
            if not flag:
                break
        if order_ball == ball[0] or order_ball == ball[-1]:
            answer.append(order_ball)
            ball.remove(order_ball)
        else:
            waiting.append(order_ball)

    return answer

#print(solution([1, 2, 3, 4, 5, 6],[6, 2, 5, 1, 4, 3]))
print(solution([11, 2, 9, 13, 24], [9, 2, 13, 24, 11]))
