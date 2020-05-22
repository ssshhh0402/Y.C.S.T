def solution(s):
    answer = 0
    base = s.split(" ")
    answer = []
    for item in range(len(base)):
        imsi = []
        for idx in range(len(base[item])):
            if idx % 2 == 0:
                imsi.append(base[item][idx].upper())
            else:
                imsi.append(base[item][idx].lower())

        answer.append(''.join(imsi))
    answer = " ".join(answer)
    return answer


print(solution("try  hel lo  world"))
