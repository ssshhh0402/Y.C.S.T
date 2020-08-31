def find(target, user_id):
    temps = []
    if len(target) == target.count("*"):
        for id in user_id:
            if len(id) == len(target):
                temps.append(id)
    else:
        start = False
        end = False
        for str in range(len(target)):
            if target[str] != '*':
                if not start:
                    start = str
                    start = True
                else:
                    end = str
                    end = False

    return temps

def solution(user_id, banned_id):
    import itertools
    answer = 0
    used = []
    comb = []
    for id in banned_id:
        find(id, user_id)
    return answer
