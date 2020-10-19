import sys
sys.setrecursionlimit(10000000)
def check(target):
    if len(target) <= 1:
        return True
    if target[0] == target[-1]:
        return check(target[1:-1])
    else:
        return False


def solution(s):

    n = len(s)
    if n == 0:
        return 0
    elif n == 1:
        return 1
    for idx in range(n, 0,-1):
        for start in range(0, n-idx+1):
            target = s[start:start+idx]
            if check(target):
                return idx

    return 1
# print(solution("abcdcba"))
print(solution("abacde"))
print(solution("a"))
print(solution("aa"))
print(solution("aaa"))
print(solution("abcde"))
print(solution("abcabcdcbae"))
print(solution("abcbaqwqabcba"))
print(solution("abaabaaaaaaa"))