def solution(total_sp, skills):
    graph = [0 for _ in range(100001)]
    i_max = 0
    graph_coming = [[] for _ in range(100001)]
    for skill in skills:
        i_max = max(i_max, skill[1])
        graph_coming[skill[0]].append(skill[1])
        graph[skill[1]] = skill[0]
    total = [0 for _ in range(i_max+1)]
    for idx in range(i_max, -1, -1):
        if graph_coming[idx]:
            for item in graph_coming[idx]:
                total[idx] += total[item]
        else:
            if graph[idx]:
                total[idx] = 1
    sp_sum = sum(total)
    sp_each = total_sp // sp_sum
    answer = []
    for idx in range(1, i_max+1):
        answer.append(sp_each * total[idx])
    return answer


print(solution(121,[[1, 2], [1, 3], [3, 6], [3, 4], [3, 5]]))
