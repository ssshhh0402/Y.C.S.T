def solution(orders, time):
    answer = 0
    base = {}
    for order in orders:
        n = 1
        order = list(order)
        now = base
        target = ''
        for idx in range(len(order)):
            if order[idx] not in now:
                now[order[idx]] = {'Number': n, 'count': 1, 'word': [order[idx]]}
                target += order[idx]
                now = now[order[idx]]
            else:
                now[order[idx]]['count'] += 1
                now[order[idx]]['word'].append(target+order[idx])
                target += order[idx]
            for idx2 in range(idx+1, len(order)):
                if order[idx2] not in now:
                    now[order[idx]] = {'Number': n, 'count': 1, 'word': [target+order[idx]]}
                else:
                    now[order[idx]]['count'] += 1
                    now[order[idx]]['word'].append(target+order[idx])
            n += 1
            target = order[idx]



print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"],[2,3,4]))
print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))
