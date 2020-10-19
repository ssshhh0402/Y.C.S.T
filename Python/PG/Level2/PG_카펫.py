def solution(brown, yellow):
    answer = []
    for y in range(1, int(yellow ** 0.5) + 1):
        if yellow % y == 0:
            if 2*(y+1) + 2 * ((yellow // y) + 1) == brown:
                answer = [yellow // y + 2, y + 2]
    return answers

print(solution(10, 2))