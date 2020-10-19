def find(base, used, prio, now):
    global answer
    a = len(set(now))
    b = len(base)
    if len(set(now)) == len(base):
        answer = True
        return
    here = now[-1]
    for toGo in base[here]:
        if used[here][toGo] == 2:
            temps = prio[here]
            for somewhere in temps:
                used[here][somewhere] = 0
            del prio[here]
            used[here][toGo] = 1
            now.append(toGo)
            find(base, used, prio, now)
            prio[here] = temps
            used[here][toGo] = 2
            now.pop()
        elif used[here][toGo] == 0:
            used[here][toGo] = 1
            now.append(toGo)
            find(base, used, prio, now)
            used[here][toGo] = 0
            now.pop()


def solution(n, path, order):
    answer = False
    base = [[] for _ in range(n)]
    prio = {}
    used = [[0 for _ in range(n)] for _ in range(n)]
    for start, end in path:
        base[start].append(end)
        base[end].append(start)

    for start, end in order:
        used[start][end] = 2
        if start in prio.keys():
            prio[start].append(end)
        else:
            prio[start] = [end]
    find(base, used, prio, [0])
    return answer


print(solution(9,[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]],[[8, 5], [6, 7],[4,1]]))
