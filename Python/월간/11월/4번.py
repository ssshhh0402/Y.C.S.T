def find(route, count, used, routes):
    global answer, n
    if count == n+1:
        answer = n+1
        return
    now = route[-1]
    flag = False

    if now in routes.keys():
        for toGo in routes[now]:
            if not used[toGo][0]:
                used[toGo][0] = 1
                if toGo not in route:
                    route.append(toGo)
                    find(route, count+1, used, routes)
                else:
                    route.append(toGo)
                    find(route, count, used, routes)
                route.pop()
                flag = True
                used[toGo][0] = 0
            elif not used[toGo][1]:
                used[toGo][1] = 1
                route.append(toGo)
                if toGo not in route:
                    find(route, count+1, used, routes)
                else:
                    find(route, count, used, routes)
                route.pop()
                flag = True
                used[toGo][1] = 0
    if not flag:
        answer = max(answer, count)


def solution(t):
    global answer, n
    answer = 0
    n = 0
    routes = {}
    for route in t:
        start, end = route
        if start in routes.keys():
            routes[start].append(end)
        else:
            routes[start] = [end]
        if end in routes.keys():
            routes[end].append(start)
        else:
            routes[end] = [start]
        temps = max(start, end)
        if n < temps:
            n = temps

    used = [[0 for _ in range(n+1)] for _ in range(n+1)]
    for idx in range(n+1):
        used[idx][0] = 1
        find([idx], 1, used, routes)
        used[idx][0] = 0
    return answer


print(solution([[5, 1], [2, 5], [3, 5], [3, 6], [2, 4], [4, 0]]))
print(solution([[2, 5], [2, 0], [3, 2], [4, 2], [2, 1]]))