def solution(N, stages):
    answer = []
    dp = [0 for _ in range(N+1)]
    check = [0 for _ in range(N+1)]
    for idx in range(1, N+1):
        total = 0
        Nclear = 0
        for stage in stages:
            if stage > idx:
                total += 1
            elif stage == idx:
                Nclear += 1
                total += 1
        if not total:
            continue
        else:
            dp[idx] = Nclear / total
    while sum(dp) != 0:
        max_dp = max(dp)
        for idx2 in range(1, len(dp)):
            if dp[idx2] == max_dp:
                answer.append(idx2)
                check[idx2] = 1
                dp[idx2] = 0
    for idx3 in range(1, N+1):
        if not check[idx3]:
            answer.append(idx3)
    return answer

print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
print(solution(4, [4, 4, 4, 4, 4]))