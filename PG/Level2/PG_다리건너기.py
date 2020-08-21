def solution(bridge_length,weight, truck_weight):
    from collections import deque
    answer = 0
    truck_weight.sort(reverse=True)
    now = deque([])
    now_weight = 0
    while truck_weight or now:
        N = len(now)
        if N:
            for _ in range(N):
                t_weight, time = now.popleft()
                if time + 1 == bridge_length:
                    now_weight -= t_weight
                else:
                    now.append((t_weight, time + 1))
        if truck_weight:
            if now_weight + truck_weight[-1] <= weight:
                now_weight += truck_weight[-1]
                now.append((truck_weight[-1], 0))
                truck_weight.pop()
        answer += 1
    return answer


print(solution(2, 10, [7, 4, 5, 6]))
#print(solution(100,100,[10]))
#print(solution(100,100,[10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))
