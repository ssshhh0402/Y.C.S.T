def solution(array, commands):
    result = []
    for i in commands:
        imsi = sorted(array[i[0]-1:i[1]])
        result.append(imsi[i[2]-1])
    return result


array = [1, 5, 2, 6, 3, 7, 4]
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
answer = solution(array, commands)
print(answer)