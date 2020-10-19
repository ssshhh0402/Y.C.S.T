def solution(prices):
    answer = []
    for i in range(len(prices)):
        price = prices[i]
        count = 0
        for j in range(i+1, len(prices)):
            count += 1
            if prices[j] < price:
                break
        answer.append(count)
    return answer


a = solution([1,2,3,2,3])
print(a)