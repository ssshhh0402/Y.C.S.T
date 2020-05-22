def solution(n):
    ans = 0
    while n // 2:
        if n % 2:
            ans += 1

        n = n // 2
    return ans



print(solution(5000))