def initdic():
    dicts = {}
    dicts["SUN"] = 6
    dicts["MON"] = 5
    dicts["TUE"] = 4
    dicts["WED"] = 3
    dicts["THU"] = 2
    dicts["FRI"] = 1
    dicts["SAT"] = 0
    return dicts


def solution(start_date, end_date, login_dates):
    answer = -1
    weeks = initdic()
    start_info = start_date.split(" ")
    start_datas = start_info[0].split("/")
    start_m = int(start_datas[0])
    start_d = int(start_datas[1])
    start_e = start_info[1]
    end_dates = end_date.split("/")
    end_m = end_dates[0]
    end_d = end_dates[1]
    login_dates.sort()
    answer = 0
    counting = 1
    temps = login_dates[0].split("/")
    fir
    count_m = int(temps[0])
    count_d = int(temps[1])+1
    if count_m%2 != 0 and count_d >= 32:
        count_m += 1
        count_d -= 31
    elif count_m % 2 == 0 and count_d >= 31:
        count_d -= 30
        count_m += 1
    elif count_m == 2 and count_d >= 29:
        count_m += 1
        count_d -= 28
    for i in range(1, len(login_dates)):
        infos = login_dates[i].split("/")
        now_m = int(infos[0])
        now_d = int(infos[1])
        if (now_m == start_m and now_d < start_d) or now_m < start_m:
            continue
        elif (now_m == end_m and now_d > end_d) or now_m > start_m:
            break
        else:
            if(now_m == count_m) and (now_d == count_d):

                if((start_d + weeks[start_e]) % now_d != 0) and (start_d + weeks[start_e] % now_d != 1):
                    counting += 1
                count_d += 1
                if count_m % 2 != 0 and count_d >= 32:
                    count_m += 1
                    count_d -= 31
                elif count_m % 2 == 0 and count_d >= 31:
                    count_d -= 30
                    count_m += 1
                elif count_m == 2 and count_d >= 29:
                    count_m += 1
                    count_d -= 28
            else:
                answer = max(answer, counting)
                counting = 1
                count_m = now_m
                count_d = now_d+1
                if count_m % 2 != 0 and count_d >= 32:
                    count_m += 1
                    count_d -= 31
                elif count_m % 2 == 0 and count_d >= 31:
                    count_d -= 30
                    count_m += 1
                elif count_m == 2 and count_d >= 29:
                    count_m += 1
                    count_d -= 28
    return answer


solution("05/04 MON", "05/30", ["05/26","05/25","05/25","05/10","05/11","05/23","05/22","05/21","05/06","05/09","05/07","05/08"])