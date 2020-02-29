def solution(numbers):
    answer = ''
    result = []
    n = len(numbers)
    for i in range(1 << n):
        imsi = []
        for j in range(n + 1):
            if i & (1 << j):
                imsi.append(str(numbers[j]))
        if len(imsi) > 0:
            a = ''.join(imsi)
            result.append(int(a))
    print(result)


solution([6,10,2])