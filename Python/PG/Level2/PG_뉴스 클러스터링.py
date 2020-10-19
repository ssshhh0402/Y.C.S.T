def find(target):
    answer = []
    for idx in range(len(target)-1):
        if target[idx].isalpha() and target[idx+1].isalpha():
            answer.append(target[idx:idx+2].lower())
    return answer


def solution(str1, str2):
    rywlqgkq = []
    str1 = find(str1)
    str2 = find(str2)
    used = [0 for _ in range(len(str2))]
    for item in str1:
        for idx in range(len(str2)):
            if item == str2[idx] and not used[idx]:
                used[idx] = 1
                rywlqgkq.append(item)
                break

    N = len(rywlqgkq)
    M = len(str1) + len(str2) - N
    if not M:
        answer = 1
    else:
        answer = N / M
    return int(answer * 65536)

print(solution("FRANCE", "FRENCH"))
print(solution("handshake", "shake hands"))
print(solution("aa1+aa2", "aaaa12"))