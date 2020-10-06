def solution(jobs):
    import heapq
    answer, now, last = 0, 0, -1
    wait, count = [], 0
    jobs.sort(key=lambda x: x[1])
    n = len(jobs)
    while count < n:
        for job in jobs:
            if last < job[0] <= now:
                answer += (now - job[0])
                heapq.heappush(wait, job[1])
        if not wait:
            now += 1
            continue
        t = heapq.heappop(wait)
        answer += len(wait) * t
        last = now
        now += t
        count += 1
    return answer // n


print(solution([[0, 3], [1, 9], [2, 6]]))