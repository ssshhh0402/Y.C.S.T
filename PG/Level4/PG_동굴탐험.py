def check(prio, here):
    chk = False
    for idx in prio.keys():
        for item in prio[idx]:
            if item == here:
                return True
    return chk

def find(base, prio, used, now):
    global answer
    if len(set(now)) == len(base):
        answer = True
        return
    here = now[-1]
    for toGo in base[here]:
        if not used[here][toGo]:
            if here in prio.keys():
                used[here][toGo] = 1
                now.append(toGo)
                temps = prio[here]
                del prio[here]
                find(base, prio, used, now)
                now.pop()
                prio[here] = temps
                used[here][toGo] = 0
            elif check(prio, toGo):
                used[here][toGo] = 1
                now.append(toGo)
                find(base, prio, used, now)
                now.pop()
                used[here][toGo] = 0


def solution(n, path, order):
    answer = False
    base = [[] for _ in range(n)]
    prio = {}
    used = [[0 for _ in range(n)] for _ in range(n)]
    for start, end in path:
        base[start].append(end)
        base[end].append(start)
    for start, end in order:
        if start not in prio.keys():
            prio[start] = [end]
        else:
            prio[start].append(end)
    find(base, prio, used, [0])
    return answer


print(solution(9,[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]],[[8, 5], [6, 7],[4,1]]))
