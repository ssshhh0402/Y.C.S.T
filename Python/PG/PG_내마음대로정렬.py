def solution(strings, n):

    answer = sorted(strings, key=lambda x : (x[n], x))
    return answer


print(solution(["sun","bed","car"], 1))
print(solution(["abce","abcd","cdx"], 2))
