import itertools
def check1(target):
    count = 0;
    for idx in range(2):
        flag = True
        tg = target[0][idx]
        for other in range(1, len(target)):
            now = target[other]
            if tg not in now:
                flag = False;
                break
        if flag:
            count += 1
    if count >= 1:
        return True
    else:
        return False


def check2(target):
    flag = True
    for item in target:
        if item[0] == item[1]:
            flag = False
            break
    return flag


def find(subList):
    subs = []
    for idx in range(0, len(subList), +2):
        subs.append(subList[idx:idx+2])
    if check1(subs) & check2(subs):
        return True
    else:
        return False


def solution(a):
    answer = 0
    n = len(a)
    if n == 1:
        return 0
    if n % 2 != 0:
        n -= 1
    for i in range(n, 0, -2):
        flag = False
        temps = itertools.combinations(a, i)
        for temp in temps:
            if find(temp):
                flag = True
                break
        if flag:
            return i

    return answer


print(solution([0]))
print(solution([5,2,3,3,5,3]))
print(solution([0,3,3,0,7,2,0,2,2,0]))