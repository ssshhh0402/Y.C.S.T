def solution(triangle):
    N = len(triangle)
    for x in range(1, N):
        for y in range(x+1):
            if not y :
                triangle[x][y] = triangle[x-1][y] + triangle[x][y]
            elif y == x:
                triangle[x][y] = triangle[x-1][y-1] + triangle[x][y]
            else:
                triangle[x][y] = max(triangle[x-1][y-1] + triangle[x][y], triangle[x-1][y] + triangle[x][y])
    return max(triangle[N-1])


print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))