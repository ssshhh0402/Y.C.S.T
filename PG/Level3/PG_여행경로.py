def solution(tickets):
    answer = []
    base = {}
    dq = ["ICN"]
    for ticket in tickets:
        if ticket[0] not in base:
            base[ticket[0]] = [ticket[1]]
        else:
            base[ticket[0]].append(ticket[1])
    for item in base.keys():
        base[item].sort(reverse=True)
    while dq:
        now = dq[-1]
        if now not in base or len(base[now]) == 0:
            answer.append(dq.pop())
        else:
            dq.append(base[now][-1])
            base[now].pop()
    answer.reverse()
    return answer


print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]))