def solution():
    N = int(input())
    C = int(input())
    cases = []
    for _ in range(C):
        x, y = map(int, input().split())
        cases.append((x, y))
    dp = [[(0, (0, 0), (0, 0)) for _ in range(C)] for _ in range(2)]
    for i in range(C):
        case_x, case_y = cases[i]
        if i == 0:
            dp[0][0] = (abs(0 - case_x) + abs(0 - case_y), (case_x, case_y), (N, N))
            dp[1][0] = (abs(N - case_x) + abs(N - case_y), (0, 0), (case_x, case_y))
        else:
            for j in range(2):
                if j == 0:
                    print(dp[i-1][1][1])
                    one = dp[i-1][0] + abs(dp[i-1][1][0] - case_x) + abs(dp[i-1][1][1] - case_y)
                    two = dp[i-1][0] + abs(dp[i-1][2][0] - case_x) + abs(dp[i-1][2][1] - case_y)

solution()