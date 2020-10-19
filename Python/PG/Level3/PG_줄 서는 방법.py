def solution(n, k):
    from math import factorial
    answer = []
    order = list(range(1,n+1))
    while n :
        N = factorial(n-1)
        answer.append(order.pop((k-1)//N))
        n = n-1
        k = k%N
    return answer

print(solution(3, 5))
