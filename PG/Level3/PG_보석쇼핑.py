def solution(gems):
    N = len(set(gems))
    answer = 0, len(gems)
    s, e = [0, 0]
    used = {}
    while s < len(gems) and e < len(gems):
        if len(used.keys()) == N:
            if e - s < answer[1] - answer[0]:
                answer = [s, e]
            else:
                used[gems[s]] -= 1
                if not used[gems[s]]:
                    del used[gems[s]]
                s += 1
        else:
            gem = gems[e]
            if gem not in used.keys():
                used[gem] = 1
            else:
                used[gem] += 1
            e += 1
    return [answer[0]+1, answer[1]]


# print(solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]))
# print(solution(["AA", "AB", "AC", "AA", "AC"]))
# print(solution(["XYZ", "XYZ", "XYZ"]))
# print(solution(["a","b","c","d"]))
# print(solution(["a","a","a","a"]))
# print(solution(["a"]))
print(solution(["a","b","a","b","c"]))