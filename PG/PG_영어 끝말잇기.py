def solution(n,words):
    answer = []
    idx = 0
    target = 0
    continued = True
    while continued:
        for person in range(n):
            num = 3 *idx + person
            if num:
                if words[num][0] == words[num-1][-1]:
                    if words[num] in words[0:num]:
                        target=person+1
                        continued = False
                        break
                else:
                    target = person + 1
                    continued = False
                    break
        if continued:
            if (idx * 3 )+ 1 < len(words):
                idx += 1
            else:
                break
    if not target:
        answer.append(0)
        answer.append(0)
    else:
        answer.append(target)
        answer.append(idx + 1)
    return answer


print(solution(3,["tank","kick","know","wheel","land","dream","mother","robot","tank"]))

