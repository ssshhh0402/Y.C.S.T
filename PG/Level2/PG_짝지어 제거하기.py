def solution(s):
    answer = 0
    N = len(s)
    base = [0 for _ in range(N)]
    while True:

        for idx in range(N):
            if not base[idx]:
                temps = 1
                while True:
                    n = idx + temps
                    if not base[n]:
                        if s[n] == s[idx]:
                            base[n] = base[idx] = 1
                    else:
                        temps += 1
    return sum(base) == 0 ? True : false

print(solution("baabaa"))
