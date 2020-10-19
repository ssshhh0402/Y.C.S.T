def solution(n, simulation_data):
    from collections import deque
    answer = 0
    waiting = deque([])
    base = deque([])
    idx = 0
    while simulation_data or waiting:
        if simulation_data:
            data = simulation_data[0]
            if data[0] == idx:
                waiting.append(data[1])
                simulation_data.pop(0)
        if base:
            for temps in range(len(base)):
                time = base.popleft()
                time -= 1
                if time:
                   base.append(time)

        if waiting:
            for times in range(len(waiting)):
                    time = waiting.popleft()
                    if len(base) == n:
                        answer += 1
                        waiting.append(time)
                    else:
                        base.append(time)
        idx += 1
    return answer

print(solution(2,[[0, 3], [2, 5], [4, 2], [5, 3]]))
print(solution(1, [[2, 3], [5, 4], [6, 3], [7, 4]]))
