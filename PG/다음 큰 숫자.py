def get(number):
    count = 0
    while number:
        if number % 2 == 1:
            count += 1
        number = number // 2
    return count


def solution(n):
    answer = 0
    comp = get(n)
    num = n
    while True:
        num += 1
        pare = get(num)
        if comp == pare:
            answer = num
            break
    return answer


result = solution(15)
print(result)