def solution(s):
    answer = 0
    N = len(s)
    if N == 1:
        return 1
    def find(arrs, number):
        count = 1
        temps = arrs[0:number]
        answer = ''
        for idx in range(number, len(arrs), number):
            if arrs[idx:idx+number] == temps:
                count += 1
            else:
                if count == 1:
                    answer += temps
                else:
                    answer += str(count) + temps
                temps = arrs[idx: idx+number]
                count = 1
        if count != 1:
            answer += str(count) + temps
        else:
            answer += temps
        return len(answer)

    for n in range(1, N // 2 + 1):
        tep = find(s, n)
        if answer:
            answer = min(answer,tep)
        else:
            answer = tep
    return answer


print(solution("aabbaccc"))
print(solution("ababcdcdababcdcd"))
print(solution("abcabcdede"))
