def solution(n, lost, reserve):
    answer = 0
    people = [1 for _ in range(n+1)]
    for person in reserve:
        people[person] += 1
    for one in lost:
        if people[one] >= 2:
            people[one] -= 1
            continue
        elif one-1 >= 1:
            if people[one-1] >= 2:
                people[one-1] -= 1
            elif one + 1 <= n:
                if people[one+1] >= 2:
                    people[one+1] -= 1
                else:
                    answer += 1
            else:
                answer += 1
            continue
        elif one + 1 <= n:
            if people[one+1] >= 2:
                people[one+1] -= 1
            else:
                answer += 1
    return n - answer


# print(solution(5, [2, 4], [1, 3, 5]))
# print(solution(5, [2, 4], [3]))
# print(solution(3, [3], [1]))
#print(solution(5, [2, 3, 5], [2, 4]))
print(solution(5, [2,3], [3,4]))