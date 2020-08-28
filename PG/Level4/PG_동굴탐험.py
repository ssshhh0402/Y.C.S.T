def solution(n, path, order):
    from collections import deque
    global answer, visited
    answer = False
    base = [[] for _ in range(n)]
    visited = [[0 for _ in range(n)] for _ in range(n)]
    for start, end in path:
        base[start].append(end)
        base[end].append(start)
    for start, end in order:
        visited[end][start] = 1
    dq = deque([0])
    routes = []

    def find(now, base, routes):
        global visited, answer
        if len(set(now)) == len(base):
            answer = True

        start = now[-1]
        for toGo in base[start]:
            if (start, toGo) not in routes:
                if sum(visited[toGo]):
                    if visited[toGo][start] == 1:
                        visited[toGo][start] = 0
                        dq.append(toGo)
                        routes.append((start, toGo))
                        find(dq, base,routes)
                        dq.pop()
                        routes.pop()
                        visited[toGo][start] = 1
                else:
                    dq.append(toGo)
                    routes.append((start, toGo))
                    find(dq, base,routes)
                    routes.pop()
                    dq.pop()

    for next in base[0]:
        if sum(visited[next]):
            if visited[next][0] == 1:
                visited[next][0] = 0
                routes.append((0, next))
                dq.append(next)
                find(dq, base, routes)
                dq.pop()
                routes.pop()
                visited[next][0] = 1
        else:
            dq.append(next)
            routes.append((0,next))
            find(dq, base,routes)
            routes.pop()
            dq.pop()
    return answer

print(solution(9,[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]],[[8, 5], [6, 7],[4,1]]))
