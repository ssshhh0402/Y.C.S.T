def solution(s):
    answer = 0
    N = len(s)
    if N == 1:
        return 1
    def find(arrs, number):
        idx = number
        answer = ''
        count = 1
        temps = arrs[0:number]
        while idx < len(arrs):
            if arrs[idx: idx+number] == temps:
                count += 1
                idx += number
            else:
                if count == 1:
                    answer += temps
                    count = 1
                    temps = arrs[idx: idx+number]
                    idx += number
                else:
                    answer += (str(count) + temps)
                    count = 1
                    temps = arrs[idx:idx+number]
                    idx += 1
        if count != 1:
            answer += str(count) + arrs[:-number]
        return len(answer)


    for n in range(1, (N // 2) +1):
        tep = find(s, n)
        if answer:
            answer = min(answer ,tep)
        else:
            answer = tep
    return answer


print(solution("aabbaccc"))
print(solution("ababcdcdababcdcd"))
print(solution("abcabcdede"))
