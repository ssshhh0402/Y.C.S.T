def solution(budgets, M):
    answer = 0
    budgets.sort()
    low = budgets[0]
    high = budgets[-1]
    # if budgets[-1] * N <= M:
    #     return budgets[-1]
    def calc(budgets, money):
        temp = 0
        for budget in budgets:
            if budget < money:
                temp += budget
            else:
                temp += money
        return temp
    while high >= low:
        mid = (high + low) // 2
        temps = calc(budgets, mid)
        if temps > M:
            high = mid-1
        else:
            answer = mid
            low = mid+1
    if not answer:
        return M // len(budgets)
    else:
        return answer

print(solution([100, 120, 100, 120, 150], 400))