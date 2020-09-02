def solution(k, room_number):
    answer = []
    base = {}
    used = [0 for _ in range(k+1)]
    for idx in range(1, k+1):
        base[idx] = idx
    for room in room_number:
        if not used[room]:
            used[room] = 1
            base[room] = base[base[room]+1]
            answer.append(room)
        else:
            n = base[room]
            while True:
                if not used[n]:
                    break
                else:
                    n = base[n]
            used[n] = 1
            base[n] = base[base[n] + 1]
            answer.append(n)

    return answer



print(solution(10,[1,3,4,1,3,1]))
