def solution(jobs):
    answer = 0
    start, end, finished = 0, 0, []
    jobs = sorted(jobs, key=lambda x: x[1])
    while len(finished) != len(jobs):
        for job in jobs:
            if job not in finished and end <= job[1]:
                answer += (start - job[0])
                start += job[1]
                end += job[1]
                finished.append(job)
                break
    return answer


print(solution([[0, 3], [1, 9], [2, 6]]))