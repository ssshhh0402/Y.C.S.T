def solution(n, t, m, timetable):
    answer = ''
    timetable.sort()
    print(timetable)
    if n == 1 and len(timetable) < m:
        answer = '09:00'
    else:

    return answer


print(solution(1,1,5,["08:00","08:01","08:03","07:55"]))