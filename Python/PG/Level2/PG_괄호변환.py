def solution(p):
    answer = ''
    p = list(p)
    if not p:
        return answer

    def convert(params):
        answer = ''
        for param in params:
            if param == '(':
                answer += ')'
            else:
                answer += '('
        return answer

    def div(p):
        left = 0
        right = 0
        for word in range(len(p)):
            if p[word] == '(':
                left += 1
            else:
                right += 1
            if left == right:
                return p[0:word+1], p[word+1:]

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
        p = v
        if check(u):
            answer += ''.join(u)
        else:
            answer += '('
            answer += solution(v)
            answer += ')'
            answer += convert(u[1:-1])
            break
    return answer


# print(solution('(()())()'))
#print(solution(")("))
print(solution("()))((()"))