def solution(dartResult):
    dartResult = list(dartResult)
    base = []
    for dart in range(len(dartResult)):
        if dartResult[dart].isdigit():
            if dartResult[dart+1].isdigit():
                base.append(10)
            elif dartResult[dart-1].isdigit():
                continue
            else:
                base.append(int(dartResult[dart]))
        elif dartResult[dart] == 'D':
            base[-1] = base[-1] ** 2
        elif dartResult[dart] == 'T':
            base[-1] = base[-1] ** 3
        elif dartResult[dart] == '#':
            base[-1] = -base[-1]
        elif dartResult[dart]== '*':
            if len(base) >= 2:
                base[-1] = 2 * base[-1]
                base[-2] = 2 * base[-2]
            else:
                base[-1]= 2 * base[-1]
    answer = sum(base)
    return answer

print(solution("1D2S#10S"))
