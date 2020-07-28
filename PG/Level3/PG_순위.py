def solution(n,results):
    answer = 0
    win = [[] for _ in range(n+1)]
    lose = [[] for _ in range(n+1)]
    for result in results:
        win[result[0]].append(result[1])
        lose[result[1]].append(result[0])
    for person in range(1,n+1):
        for loser in lose[person]:
            for winner in win[loser]:
                if winner != person:
                    win[person].append(winner)
    for idx in range(1, n+1):
        if len(win[idx]) + len(lose[idx]) >= n-1:
            answer += 1
    return answer

print(solution(5, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]))