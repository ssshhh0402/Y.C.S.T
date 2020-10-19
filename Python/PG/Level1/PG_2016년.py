def solution(a, b):

    day = [0,31,29,31,30,31,30,31,31,30,31,30,31]
    days = ["FRI", "SAT","SUN", "MON", "TUE", "WED", "THU"]
    count = sum(day[1:a]) + (b-1)
    return days[count % 7]

print(solution(5, 24))
