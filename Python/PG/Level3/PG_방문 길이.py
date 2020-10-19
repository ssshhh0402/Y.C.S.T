def solution(dirs):
    keys = {'L': (0, -1), 'R': (0, 1), 'U': (-1, 0), 'D': (1, 0)}
    dirs = list(dirs)
    visited = set()
    answer = 0
    now_x, now_y = 5, 5
    for dir in dirs:
        x, y = now_x + keys[dir][0], now_y + keys[dir][1]
        if 0 <= x <= 10 and 0 <= y <= 10:
            if (now_x, x, now_y, y) not in visited:
                visited.add((now_x, x, now_y, y))
                visited.add((x, now_x, y, now_y))
                answer += 1
            now_x, now_y = x, y
        else:
            continue

    return answer


# print(solution("ULURRDLLU"))
print(solution("LULLLLLLU"))