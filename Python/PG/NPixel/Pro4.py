
def solution(n):
    answer = 0
    for i in range(1, n):
        answer += (i * (n-i) * (n-i))
    return answer


print(solution(3))
print(solution(4))