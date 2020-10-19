def solution(n, p, c):
    g = 0
    money = 0
    costs = [100,50,25]
    cost = 0
    for idx in range(n):
        g += p[idx]
        if g >= c[idx]:
            money += costs[cost] * c[idx]
            g -= c[idx]
            cost = 0
        else:
            cost += 1
            if cost == 3:
                n = idx + 1
                break
    return format(float(money) / float(n), ".2f")



print(solution(6,[5, 4, 7, 2, 0, 6],[4, 6, 4, 9, 2, 3]))
print(solution(7, [6, 2, 1, 0, 2, 4, 3]	, [3, 6, 6, 2, 3, 7, 6]	))