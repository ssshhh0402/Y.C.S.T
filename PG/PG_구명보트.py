def solution(people, limit):
    answer = 0
    people = sorted(people, reverse=True)
    going = [0 for _ in range(len(people))]
    for person in range(len(people)):
        if not going[person]:
            going[person] = 1
            for another in range(len(people)-1, person, -1):
                if people[person] + people[another] <= limit:
                    if not going[another]:
                        going[another] = 1
                        break
            answer += 1

    return answer

#
print(solution([70, 50, 80, 50], 100))
# print(solution([70, 80, 50], 100))
# print(solution([20, 80, 50, 50],100))
# print(solution([40, 40, 40], 100))