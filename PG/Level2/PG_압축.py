def solution(msg):
    answer = []
    base = [0,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    item = msg[0]
    message = 1
    while message != len(msg):
        if item + msg[message] not in base:
            answer.append(base.index(item))
            base.append(item + msg[message])
            item = msg[message]
            message += 1
            continue
        item += msg[message]
        message += 1
    answer.append(base.index(item))
    return answer


print(solution("KAKAO"))
print(solution("TOBEORNOTTOBEORTOBEORNOT"))