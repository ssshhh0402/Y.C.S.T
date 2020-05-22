
def solution(s):
    base = list(map(int, s.split()))
    return "{} {}".format(min(base), max(base))

print(solution("1 2 3 4"))
print(solution("-1 -2 -3 -4"))
print(solution("-1-1"))