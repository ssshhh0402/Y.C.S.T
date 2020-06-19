def solution(people, limit):
    answer = 0
    hPeople = sorted(people, reverse=True)
    going = [0 for _ in range(len(hPeople))]
    idx = len(hPeople) - 1
    for person in range(len(people)):
        if going[person]:
            break
        else:
            if hPeople[person] + hPeople[idx] <= limit:
                going[person] = 1
                going[idx] = 1
                idx -= 1
        answer += 1
    return answer

print(solution([70,50,80,50], 100))
print(solution([70,80,50],100))