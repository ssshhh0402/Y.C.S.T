def solution(N, number):
    answer = 0
    base = [0]
    for idx in range(1, 9):
        base.append(int(str(N) * idx))
    dp = [set() for _ in range(9)]
    for i in range(1, 9):
        dp[i].add(base[i])
        for j in range(1,i+1):
            for item_1 in dp[j]:
                for item_2 in dp[i-j]:
                    dp[i].add(item_1 + item_2)
                    dp[i].add(item_1 - item_2)
                    dp[i].add(item_1 * item_2)
                    if item_2:
                        dp[i].add(item_1 // item_2)
            if number in dp[i]:
                return i
    return -1

print(solution(5, 12))