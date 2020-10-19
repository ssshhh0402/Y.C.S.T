def find(base, i, items):
    answer = 0
    target = base
    for j in range(i+1, len(items)):
        if items[j]:
            if j == len(items) - 1:
                temps = [x for x in target['score'] if x >= int(items[j])]
                # answer.extend(temps)
                answer += len(temps)
            elif items[j] != '-':
                if items[j] in target.keys():
                    target = target[items[j]]
                else:
                    break
            else:
                for topic in target:
                    answer += (find(target[topic], j, items))
                break
    return answer


def solution(info, query):
    answer = []
    base = {}
    for informations in info:
        informations = informations.split(" ")
        now = base
        num = 0
        while num != len(informations):
            information = informations[num]
            if num == len(informations)-1:
                now['score'].append(int(information))
            elif num == len(informations)-2:
                if information not in now.keys():
                    now[information] = {'score': []}
                    now = now[information]
                else:
                    now = now[information]
            else:
                if information not in now.keys():
                    now[information] = {}
                    now = now[information]
                else:
                    now = now[information]
            num += 1

    for items in query:
        items = items.replace("and", "").split(" ")
        target = base
        temps= 0
        for item in range(len(items)):
            if items[item]:
                if item == len(items) - 1:
                    temp = [x for x in target['score'] if x >= int(items[item])]
                    #temps.extend(temp)
                    temps += len(temp)
                elif items[item] != '-':
                    if items[item] in target.keys():
                        target = target[items[item]]
                    else:
                        break
                else:
                    for key in target:
                        if key != 'score':
                            temps += find(target[key], item, items)
                    break
        answer.append(temps)
    return answer

print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"],
               ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))