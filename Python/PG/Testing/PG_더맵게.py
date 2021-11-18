
def solution(scoville, K):
    import heapq
    heapq.heapify(scoville)
    answer = 0

    while True:
        if len(scoville) == 1:
            if scoville[0] < K:
                answer = -1
            break
        A = heapq.heappop(scoville)
        B = heapq.heappop(scoville)
        if A >= K:
            break
        else:
            heapq.heappush(scoville, A+(B*2))

        answer += 1
    return answer


print(solution([1, 2, 3, 9, 10, 12],7))