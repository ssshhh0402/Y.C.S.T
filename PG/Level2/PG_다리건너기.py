def solution(bridge_length, weight, truck_weights):
    from collections import deque
    answer = 0
    bridge = deque()
    bridge_time = deque()
    truck_weights = deque(truck_weights)
    while True:
        if len(bridge) == 0 and len(truck_weights) == 0:
            return answer

        for i in range(len(bridge)):
            bridge_time[i] += 1
        answer += 1

        if bridge:
            if bridge_time[0] == bridge_length:
                bridge.popleft()
                bridge_time.popleft()
        if len(truck_weights) != 0:
            if sum(bridge) + truck_weights[0] <= weight:
                bridge.append(truck_weights[0])
                bridge_time.append(0)
                truck_weights.popleft()




print(solution(2, 10, [7, 4, 5, 6]))
#print(solution(100,100,[10]))
#print(solution(100,100,[10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))
