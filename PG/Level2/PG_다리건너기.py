def solution(bridge_length,weight, truck_weight):
    from collections import deque
    answer = 0
    truck_weight.sort()
    now = deque([(truck_weight[-1], -1)])
    now_weight = truck_weight[-1]
    truck_weight.pop()
    while truck_weight or now:
        if truck_weight:
            if now_weight + truck_weight[-1] <= weight:
                now_weight += truck_weight[-1]
                now.append((truck_weight[-1], -1))
                truck_weight.pop()
        N = len(now)
        if N:
            for _ in range(N):
                weight, time = now.popleft()
                if time + 1 == bridge_length:
                    now_weight -= weight
                else:
                    now.append((weight, time+1))
        answer += 1
    return answer


#print(solution(2, 10, [7, 4, 5, 6]))
#print(solution(100,100,[10]))
print(solution(100,100,[10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))
