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
            base.append(items)
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
         expression= find2(expression, base[priority])
    
def solution(expression):
    import itertools
    answer = 0
    expression = find(expression)
    base = ['-','+','*']
    prio = [0,1,2]
    prio = list(itertools.permutations(prio,3))

    for pr in prio:
        expressions = find3(expression, pr)
        for item in pr:
            expression = find2(expression,base[item])
            print(expression)
    return answer



print(solution("100-200*300-500+20"))