def solution(S):
    S = S.split(" ")
    base = []
    for s in S:
        if s.isdigit():
            base.append(int(s))
        else:
            if s == '+':
                if len(base) >= 2:
                    a = base.pop()
                    b = base.pop()
                    base.append(a+b)
                else:
                    return -1
            elif s == '-':
                if len(base) >= 2:
                    a = base.pop()
                    b = base.pop()
                    c = a - b
                    if c >= 0:
                        base.append(c)
                    else:
                        return -1
                else:
                    return -1
            elif s == "DUP":
                if len(base) >= 1:
                    a = base[-1]
                    base.append(a)
                else:
                    return -1
            elif s == "POP":
                if len(base) >= 1:
                    base.pop()
                else:
                    return -1
    return base[-1]


print(solution("5 6 + -"))
print(solution("13 DUP 4 POP 5 DUP + DUP + -"))
print(solution("3 DUP 5 - -"))