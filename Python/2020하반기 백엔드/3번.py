import sys
sys.setrecursionlimit(10 ** 9)
def find(base, groups, count, used):
    global answer
    if not sum(base):
        answer = min(answer, count)
        return
    if count >= answer:
        return
    for group in range(len(groups)):
        if not used[group]:
            start, end = groups[group]
            used[group] = 1
            for idx in range(start, end+1):
                base[idx] = 0
            find(base, groups, count+1, used)
            for idx in range(start, end+1):
                base[idx] = 1
            used[group] = 0
    for idx in range(len(base)):
        if base[idx] == 1:
            base[idx] = 0
            find(base, groups, count+1, used)
            base[idx] = 1


def solution(n, groups):
    global answer
    answer = n
    base = [1 for _ in range(n+1)]
    N = len(groups)
    used = [0 for _ in range(N)]
    base[0] = 0
    for group in range(N):
        start, end = groups[group]
        used[group] = 1
        for idx in range(start, end+1):
            base[idx] = 0
        find(base, groups, 1, used)
        for idx in range(start, end+1):
            base[idx] = 1
        used[group] = 0
    for idx in range(n+1):
        base[idx] = 0
        find(base, groups, 1, used)
        base[idx] = 1
    return answer


print(solution(10,[[1, 5],[2, 7],[4, 8],[3, 6]]))
print(solution(7,[[6, 7],[1, 4],[2, 4]]	))
print(solution(100,[[1, 50],[1,100],[51, 100 ]]	))
