def solution(number, k):
    answer = ''
    bk = []
    number = list(number)
    for num in number:
        if not bk:
            bk.append(num)
        else:
            bk.append(num)
            while bk:
                comp_1 = bk.pop()
                comp_2 = bk.pop()
                if comp_1 > comp_2 :
                    bk.append(comp_1)
                else:
                    bk.append(comp_2)
                    bk.append(comp_1)
            if not bk:
                bk.append(num)
    return answer



print(solution("1924", 3))
