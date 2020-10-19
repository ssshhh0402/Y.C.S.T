def checking(base, lists, n):
    from collections import deque
    count = 0
    answer = 0
    visited = [0 for _ in range(n)]
    for start in range(n):
        temps = 1
        if not visited[start]:
            visited[start] = 1
            dq = deque([start])
            while dq:
                x = dq.popleft()
                for end in base[x]:
                    if not visited[end]:
                        if [x, end] not in lists and [end, x] not in lists:
                            visited[end] = 1
                            dq.append(end)
                            temps += 1
                if count and temps > count:
                    break
            if not count:
                count = temps
            else:
                if count == temps:
                    answer += 1
                else:
                    break
    return answer == 2



def find(base, lists, edges,n, m):
    global answer
    if len(lists) == 2:
        if checking(base, lists, n):
            for a in lists:
                answer.append(edges.index(a))
        return

    for edge in range(m+1, len(edges)):
        lists.append(edges[edge])
        find(base, lists, edges, n, edge)
        lists.pop()


def solution(n, edges):
    global answer
    answer = []
    base = {}
    for idx in range(len(edges)):
        start, end = edges[idx]
        if start not in base.keys():
            base[start] = [end]
        else:
            base[start].append(end)
        if end not in base.keys():
            base[end] = [start]
        else:
            base[end].append(start)
    for edge in range(len(edges)):
        find(base, [edges[edge]], edges, n, edge)
    return answer


print(solution(9, [[0, 2], [2, 1], [2, 4], [3, 5], [5, 4], [5, 7], [7, 6], [6, 8]]))
