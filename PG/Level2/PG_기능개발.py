def solution(progresses, speeds):
    answer = 0
    deploy = []
    for idx in range(len(progresses)):
        left = 100 - progresses[idx]
        if not left % speeds[idx] :
            counting = left // speeds[idx]
        else:
            counting = left // speeds[idx] + 1
        if counting > answer:
            answer = counting
            deploy.append(1)
        else:
            deploy[-1] += 1

    return deploy


print(solution([93, 30, 55], [1, 30, 5]))