def solution(n, stations, w):
    answer = 0
    cover = 0
    W = 2*w+1
    for station in stations:
        if station - w > cover+1:
            answer += (station-w-1-cover)//W
            if (station-w-1-cover) % W > 0:
                answer += 1
        cover = station + w
    if cover < n:
        answer += (n-cover)//W
        if (n-cover) % W > 0:
            answer += 1
    return answer


print(solution(11,[4,11],1))
print(solution(16,[9],2))