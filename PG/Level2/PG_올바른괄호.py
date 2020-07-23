def solution(s):
    answer = True
    items = list(s)
    base = []
    for item in items:
        if item == '(':
            base.append(item)
        else:
            if len(base) == 0:
                return False
            else:
                if base[-1] =='(':
                    base.pop()
                else:
                    base.append(item)

    return len(base) == 0


print(solution("()()"))