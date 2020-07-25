def solution(tickets):
    from collections import deque
    answer = []
    base = {}
    lists = ["ICN"]
    def find(base, lists):
        if len(lists) == len(base.keys())+1:
            return lists
        now = lists[-1]
        temp = []
        for toGo in sorted(base[now],reverse=True):
            if toGo not in lists:
                lists.append(toGo)
                imsi = find(base, lists)
                if imsi:
                    temp = imsi
                lists.pop()
        return temp

    for ticket in tickets:
        if ticket[0] not in base.keys():
            base[ticket[0]] = [ticket[1]]
        else:
            base[ticket[0]].append(ticket[1])
    for toGo in sorted(base["ICN"],reverse=True):
        lists.append(toGo)
        temp = find(base, lists)
        if temp:
            answer = temp
        lists.pop()

    return answer


# print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]))