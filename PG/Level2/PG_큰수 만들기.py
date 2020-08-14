def solution(number, k):
    answer = []
    for i, num in enumerate(number):
        while len(answer) > 0 and answer[-1] < num and k > 0:
            answer.pop()
            k -= 1
        if k == 0:
            answer += list(number[i:])
            break
        answer.append(num)
    if k > 0:
        answer = answer[:-k]
    return ''.join(answer)




# print(solution("1924", 2))
print(solution("1231234", 3))