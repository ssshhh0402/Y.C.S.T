from collections import deque
base = []
dq = deque([])
count = 0
used = [[ 0 for _ in range(5) ] for _ in range(5)]
for idx in range(5):
    temps = list(map(int, input().split()))
    if 1 in temps:
        dq.append((idx, temps.index(1)))

while dq:
    for _ in range(len(dq)):
        x, y = dq.popleft()
        if (x, y) == (2, 2):
            print(count)
            break
        else:
            for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                next_x, next_y = x + dx, y + dy
                if 0 <= next_x < 5 and 0 <= next_y < 5:
                    if not used[next_x][next_y]:
                        used[next_x][next_y] = 1
                        dq.append((next_x, next_y))
    count += 1