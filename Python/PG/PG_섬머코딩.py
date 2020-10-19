def solution(p):
    idx = 1
    while True:
        year = p + idx
        numbers = []
        while year:
            number = year % 10
            year = year // 10
            if number not in numbers:
                numbers.append(number)
        if len(numbers) == 4:
            return p + idx
        else:
            idx +=1

print(solution(1987))
print(solution(2015))