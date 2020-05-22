def solution(skill, skill_trees):
    answer = 0
    for skill_tree in skill_trees:
        last = -1
        checking = [0 for _ in range(len(skill))]
        for s in range(len(skill)):
            idx = skill_tree.find(skill[s])
            if idx < 0:
                continue
            elif last < idx:
                if s > 0:
                    if checking[s-1]:
                        last = idx
                        checking[s] = 1
                    else:
                        answer += 1
                        break
                else:
                    last = idx
                    checking[s] = 1
            else:
                answer += 1
                break
    return len(skill_trees) - answer


print(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))