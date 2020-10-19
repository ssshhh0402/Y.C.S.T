def emptyAtm(atmLists, customer):         # 비어있는 atm
    date, time, consume = customer.split(" ")
    endDate, endTime = find(time, consume, date)
    for atm in range(len(atmLists)):
        if atmLists[atm][0] <= date and atmLists[atm][1] <= endTime:
            return atm
    return -1

def findAtm(atmLists, customer):          #꽉차 있을대 가장 빨리 끝난 아이 찾는 거
    answer = 0
    date, time, consume = customer.split(" ")
    time = 0
    for atm in range(len(atmLists)):
        if not atmLists[atm]:
            answer = atm
            break
        else:
            if atmLists[atm] < time:
                time = atmLists[atm]
                answer = atm
    return answer

def find(time, consume, date):
    time = list(map(int, time.split(':')))
    date = list(map(int, date.split('/')))
    time[2] += int(consume)
    time[1] += time[2] // 60
    time[2] = time[2] % 60
    time[0] += time[1] // 60
    time[1] = time[1] % 60
    date[1] += time[0] // 24
    time[0] = time[0] % 24
    if date[0] == 2:
        date[0] += date[1] // 28
        if date[1] % 28 == 0:
            date[1] = 1
        else:
            date[1] = date[1] % 28
    else:
        date[0] += date[1] // 30
    return (date, time)
def solution(n, customers):
    from collections import deque
    answer = 0
    count = [0 for _ in range(n)]
    atm = [[0, 0] for _ in range(n)]       #날짜, 끝난 시간
    for customer in customers:
        n = emptyAtm(atm, customer)
        if n:                       # 비어있는 아이 있음
            date, time, consume = customer.split(' ')
            endDate, endTime = find(date,time,consume)
            atm[n][0] = endDate
            atm[n][1] = endTime
        else:
            n = findAtm(atm, customer)
    return answer


print(solution(3,["10/01 23:20:45 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"]))
print(solution(2, ["02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01"]))