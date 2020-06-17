
def solution(n):
    answer = 0
    number = bin(int(n))[2:]
    for i in range(len(number)):
        if int(number[i]) == 1:
            answer += 3 ** (len(number)-i-1)
    return answer

print(solution(11))
print(solution(4))