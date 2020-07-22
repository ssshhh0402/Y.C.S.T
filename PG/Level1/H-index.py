def solution(citations):
    answer = 0
    citations = sorted(citations)
    n = len(citations)
    for i in range(n-1, -1, -1):
        count = 0
        for j in range(n):

            if citations[j] >= citations[i]:
                count += 1
        if count >= citations[i]:
            answer = citations[i]
            break
    return answer


a = solution([3,0,6,1,5])
print(a)