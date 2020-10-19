def solution(votes, k):
    cars = set(votes)
    base = {}
    for car in cars:
        base[car] = 0
    values = []
    for car in votes:
        base[car] += 1
    for keys in base.keys():
        values.append((keys, base[keys]))
    values.sort(key=lambda x : (-x[1],x[0]))
    flag = 0
    for idx in range(k):
        flag += values[idx][1]
    count = 0
    answer = ''
    N = len(values)
    for idx in range(N):
        if count + values[N-idx-1][1] < flag:
            count += values[N-idx-1][1]
            answer = values[N-idx-1][0]
        else:
            break
    return answer
print(solution(["AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"], 2))
print(solution(["AAD", "AAA", "AAC", "AAB"], 4))
