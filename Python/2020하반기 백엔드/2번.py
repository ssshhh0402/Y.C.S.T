def solution(p,n):
    answer = []
    p = p.split(" ")
    if p[0] == "AM":
        flag = False
    else:
        flag = True
    time = list(map(int, p[1].split(":")))

    time[2] += n
    time[1] += time[2] // 60
    time[2] = time[2] % 60
    time[0] += time[1] // 60
    time[1] = time[1] % 60
    if time[0] >= 12:
        flag = not flag
        time[0] = time[0] % 12
    if not flag:
        if time[0] < 10:
            answer.append('0' + str(time[0]))
        else:
            answer.append(str(time[0]))
    else:
        answer.append(str(12 + time[0]))
    if time[1] < 10:
        answer.append('0' + str(time[1]))
    else:
        answer.append(str(time[1]))
    if time[2] < 10:
        answer.append('0' + str(time[2]))
    else:
        answer.append(str(time[2]))
    return ':'.join(answer)


#
print(solution("PM 01:00:00",10))
print(solution("PM 11:59:59", 1))
print(solution("AM 11:59:59", 300))
print(solution("PM 11:59:59", 300))
print(solution("AM 11:00:00", 300))
print(solution("PM 11:59:59", 300000))
print(solution("AM 11:59:59", 300000))
print(solution("PM 05:00:00", 3000))