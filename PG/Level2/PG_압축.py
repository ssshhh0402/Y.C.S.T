def solution(msg):
    answer = []
    base = [0,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    message = 0
    while message != len(msg):
        temps = msg[message]
        answer.append(base.index(temps))
        idx = message + 1
        if idx == len(msg):
            break
        else:
            while idx != len(msg):
                temps += msg[idx]
                if temps not in base:
                    base.append(temps)
                    message = idx
                    break
                else:
                    answer.append(base.index(temps))
                    idx += 1
    return answer


print(solution("KAKAO"))
