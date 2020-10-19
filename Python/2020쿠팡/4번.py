def find(routes, dest, hub, flag, base):
    global answer
    if routes[-1] == dest:
        if flag:
            answer += 1
        return
    now = routes[-1]
    for toGo in base[now]:
        if now == hub:
            routes.append(toGo)
            find(routes, dest, hub, not flag, base)
            routes.pop()
        else:
            routes.append(toGo)
            find(routes, dest, hub, flag, base)
            routes.pop()

def solution(depar, hub, dest, roads):
    global answer
    answer = 0
    base = {}
    for destination in roads:
        start, end = destination[0],destination[1]
        if start not in base.keys():
            base[start] = [end]
        else:
            base[start].append(end)
    for toGo in base[depar]:
        find([toGo], dest, hub, False, base)
    if not answer:
        return answer
    else:
        return answer % 10007

print(solution("SEOUL","DAEGU","YEOSU",[["ULSAN","BUSAN"],["DAEJEON","ULSAN"],["DAEJEON","GWANGJU"],["SEOUL","DAEJEON"],["SEOUL","ULSAN"],["DAEJEON","DAEGU"],["GWANGJU","BUSAN"],["DAEGU","GWANGJU"],["DAEGU","BUSAN"],["ULSAN","DAEGU"],["GWANGJU","YEOSU"],["BUSAN","YEOSU"]]		))
print(solution("ULSAN","SEOUL","BUSAN",[["SEOUL","DAEJEON"],["ULSAN","BUSAN"],["DAEJEON","ULSAN"],["DAEJEON","GWANGJU"],["SEOUL","ULSAN"],["DAEJEON","BUSAN"],["GWANGJU","BUSAN"]]))