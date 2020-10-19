def solution(s):
    answer = 0
    s = list(s)
    base = []
    for chr in s:
        base.append(chr)
        if len(base) >= 2:
            if base[-1] == base[-2]:
                base.pop()
                base.pop()
    if len(base) == 0:
        return 1
    else:
        return 0

print(solution("baabaa"))
print(solution("cdcd"))