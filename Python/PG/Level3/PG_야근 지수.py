def solution(n, works):
    import heapq
    answer = 0
    if sum(works) <= n:
        return answer
    for idx in range(len(works)):
        works[idx] = works[idx] * -1
    heapq.heapify(works)
    for i in range(n):
        m = heapq.heappop(works)
        if m == 0:
            break
        m += 1
        heapq.heappush(works, m)
    for work in works:
        answer += ((-1 * work) ** 2)
    return answer


print(solution(4, [4, 3, 3]))