def find(removed, target):
    answer = 0
    for item in target[0]:
        if item in removed:
            answer += 1
    return target[1] - answer

def solution(k, score):
    removes = {}
    removed = []
    used = [1 for _ in range(len(score))]
    for idx in range(1, len(score)):
        sco = abs(score[idx]-score[idx-1])
        if sco in removes.keys():
            removes[sco][0].append((idx-1, idx))
            removes[sco][1] += 1
        else:
            removes[sco] = [([(idx-1, idx)]), 1]
    for scos in removes.keys():
        if find(removed, removes[scos]) >= k:
            for remove in removes[scos][0]:
                used[remove[0]] = 0
                used[remove[1]] = 0
            removed.extend(removes[scos][0])
    return sum(used)



print(solution(3, [24, 22, 20, 10, 5, 3, 2, 1]))
print(solution(2, [1300000000, 700000000, 668239490, 618239490, 568239490, 568239486, 518239486, 157658638, 157658634, 100000000, 100]))