def find(orders, item):
    answer = 0
    for order in orders:
        flag = True
        for char in item:
            if char not in order:
                flag = False
                break
        if flag:
            answer += 1
    return answer


def solution(orders, courses):
    import itertools
    answer = []
    base = sorted(set(list(''.join(orders))))
    for course in courses:
        temps = []
        counts = 0
        items = (itertools.combinations(base, course))
        for item in items:
            n = find(orders, item)
            if n >= 2:
                if n > counts:
                    temps = [''.join(item)]
                    counts = n
                elif n == counts:
                    temps.append(''.join(item))
        answer.extend(temps)
    return sorted(answer)


print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"],[2,3,4]))
print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))
