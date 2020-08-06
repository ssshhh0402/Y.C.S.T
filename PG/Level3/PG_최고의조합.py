def solution(n, s):
    import itertools
    answer = 0
    comp = 0
    if n < s:
        return [-1]
    base = [i for i in range(1, s)]
    items = list(itertools.permutations(base, n))
    for item in items:
        if sum(item) == s:
            now = item[0] * item[1]
            if now > comp:
                comp = now
                answer = [item[0], item[1]]
    for item in base:
        if item + item == s:
            if item ** 2 > comp:
                comp = item ** 2
                answer = [item, item]
    return answer


# print(solution(2, 9))
print(solution(2, 8))