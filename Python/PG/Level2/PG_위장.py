def solution(clothes):
    answer = 1
    base = {}
    for clothe in clothes:
        if clothe[1] not in base.keys():
            base[clothe[1]] = [clothe[0]]
        else:
            base[clothe[1]].append(clothe[0])
    for kind in base.keys():
        answer *= (len(base[kind])+1)
    return answer -1


print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))