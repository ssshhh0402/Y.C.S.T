def find(target):
    answer = []
    for idx in range(len(target)-1):
        if target[idx].isalpha() and target[idx+1].isalpha():
            answer.append(target[idx:idx+2].lower())
    return answer
def solution(str1, str2):
    base = []
    rywlqgkq = []
    gkqwlqgkq = set([])
    base.append(find(str1))
    base.append(find(str2))
    for item in base[0]:
        if item in base[1]:
            rywlqgkq.append(item)
    for items in base:
        for item in items:
            gkqwlqgkq.add(item)
    answer = (len(rywlqgkq) / len(gkqwlqgkq))
    return int(answer * 65536)

print(solution("FRANCE", "FRENCH"))
print(solution("handshake","shakehands"))
print(solution("aa1+aa2", "aaaa12"))