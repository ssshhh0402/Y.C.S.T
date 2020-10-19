def calc(cal, num1, num2):
    if cal == '+':
        return num1+num2
    elif cal == '-':
        return num1 - num2
    else:
        return num1 * num2


def find2(expression, target):
    base = []
    for idx in range(len(expression)):
        if base and base[-1] == target:
            temps = base.pop()
            numa = int(base.pop())
            items = calc(temps, numa, int(expression[idx]))
            base.append(str(items))
        else:
            base.append(expression[idx])
    return base
def find(expression):
    start = 0
    base = []
    calc = ['-','+','*']
    for i in range(len(expression)):
        if expression[i] in calc:
            base.append(''.join(expression[start:i]))
            base.append(expression[i])
            start = i+1
    base.append(''.join(expression[start:]))
    return base

def find3(expression, priority):
    base = ['-','+','*']
    answer = 0
    for item in priority:
         expression= find2(expression, item)
    return int(expression[0])

def solution(expression):
    import itertools
    answer = 0
    expression = find(expression)
    base = ['-','+','*']

    prio = list(itertools.permutations(base, 3))

    for pr in prio:
        expressions = find3(expression, pr)
        answer = max(abs(expressions), answer)
    return answer



print(solution("100-200*300-500+20"))