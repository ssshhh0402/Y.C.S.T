def find(target, base):
    answer = 0
    now = base
    for chr in target:
        answer += 1
        if now[chr]['count'] == 1:
            break
        else:
            now = now[chr]
    return answer
def solution(words):
    answer = 0
    base = {}
    for word in words:
        now = base
        for chr in word:
            if chr not in now:
                now[chr] = {'count': 1}
            else:
                now[chr]['count'] = now[chr]['count'] + 1
            now = now[chr]
    for word in words:
        answer += find(word, base)
    return answer


print(solution(['go','gone','guild']))
