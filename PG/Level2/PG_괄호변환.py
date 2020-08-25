def solution(p):
    answer = ''
    base = []
    p = list(p)
    if not p:
        return answer

    def div(p):
        left = 0
        idx = 0
        for word in range(len(p)):
            if p[word] == '(':
                left += 1
            else:
                if left > 0:
                    left -= 1
                    if not left and not idx:
                        idx = word
                else:
                    break
        return p[0:idx], p[idx:]

    def check(matters):
        count = 0
        for matter in matters:
            if matter == '(':
                count += 1
            else:
                count -= 1
            if count < 0:
                return False
        if not count:
            return True
        else:
            return False

    while p:
        u, v = div(p)
        if check(u):
            base.append(u)
            p = v
        else:
            answer += '('
            for item in range(len(base)):
                if item == 0:
                    n = len(base[item])
                    answer += base[item][1:n-1]
                else:
                    answer += base[item]
            answer += ')'
    return answer


print(solution('(()())()'))
print(solution(")("))
print(solution("()))((()"))