def solution(gems):
    answer = 0
    leng = 0
    jew = set([])
    for gem in gems:
        jew.add(gem)
    for idx in range(len(gems)):
        tems = set([gems[idx]])
        for p in range(idx+1, len(gems)):
            tems.add(gems[p])
            if len(tems) == len(jew):
                if not leng:
                    answer = [idx+1, p]
                else:
                    if leng < p - idx:
                        answer = [idx+1, p]
                leng = idx - p

    return answer


print(solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]))
