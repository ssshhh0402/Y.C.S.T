def solution(scoville, K):
    import heapq
    answer = 0
    heapq.heapify(scoville)
    while True:
        if len(scoville) <= 1 :
            if scoville[0] < K:
                return -1
            else:
                return answer
        else:
            a = heapq.heappop(scoville)
            b = heapq.heappop(scoville)
            if a >= K:
                break
            else:
                heapq.heappush(scoville, a + b * 2)
            answer += 1
    return -1

print(solution([1, 2, 3, 9, 10, 12], 7))
