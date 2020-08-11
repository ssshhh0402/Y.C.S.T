def solution(n, k):
    answer = []
    base = [i for i in range(1, n+1)]
    N = 1
    for idx in range(2, n+1):
        N *= idx
    print(N)

print(solution(3, 5))
