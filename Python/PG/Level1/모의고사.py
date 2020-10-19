def solution(answers):
    answer = []
    a = [0, 1, 2, 3, 4, 5]
    b = [0, 2, 1, 2, 3, 2, 4, 2, 5]
    c = [0, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    score = [0, 0, 0]
    i = 0
    i_a = 1
    i_b = 1
    i_c = 1
    while i != len(answers):
        if answers[i] == a[i_a]:
            score[0] += 1
        if answers[i] == b[i_b]:
            score[1] += 1
        if answers[i] == c[i_c]:
            score[2] += 1

        i += 1
        i_a += 1
        if i_a == len(a):
            i_a = 1
        i_b += 1
        if i_b == len(b):
            i_b = 1
        i_c += 1
        if i_c == len(c):
            i_c = 1
    max_score = max(score)
    for idx in range(3):
        if score[idx] == max_score:
            answer.append(idx+1)
    return answer



result = solution([1,3,2,4,2])
print(result)