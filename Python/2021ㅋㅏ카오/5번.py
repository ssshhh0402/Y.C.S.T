def solution(play_time, adv_time, logs):
    if play_time == adv_time:
        return "00:00:00"
    adv_hours, adv_minutes, adv_seconds = adv_time.split(':')
    adv_time = 60 * 60 * int(adv_hours) + 60 * int(adv_minutes) + int(adv_seconds)
    play_time = play_time.split(':')
    n = int(play_time[0]) * 60*60 + int(play_time[1]) * 60 + int(play_time[2])
    base = [ 0 for _ in range(n+1)]
    time_G = []

    for log in logs:
        time_start, time_end  = log.split('-')
        start_time, end_time = time_start.split(':'), time_end.split(':')
        start = int(start_time[0]) * 60 * 60 + int(start_time[1]) * 60 + int(start_time[2])
        end = int(end_time[0]) * 60 * 60 + int(end_time[1]) * 60 + int(end_time[2])
        time_G.append((start, end))
        for time in range(start, end+1):
            base[time] += 1
    temps = 0
    times = ''
    time_G.sort(key=lambda x: x[0])
    for start_time, end_time in time_G:
        temp = sum(base[start_time: start_time + adv_time+1])
        if temp > temps and start_time + adv_time <= n:
            times = start_time
            temps = temp
    answer = ''
    if not times:
        times = n - adv_time
    hours = times // 60 // 60
    times = times - hours * 60 * 60
    minutes = times // 60
    seconds = times - minutes * 60
    if hours < 10:
        hours = '0' + str(hours)
    else:
        hours = str(hours)
    if minutes < 10:
        minutes = '0' + str(minutes)
    else:
        minutes = str(minutes)
    if seconds < 10:
       seconds = '0' + str(seconds)
    else:
        seconds = str(seconds)
    answer += hours + ":" + minutes + ":" + seconds

    return answer

print(solution("02:03:55","00:14:15",["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]))
print(solution("01:00:00", "00:58:00", ["00:30:30-00:35:45","00:23:03-00:28:30"]))