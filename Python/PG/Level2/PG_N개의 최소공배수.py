def solution(arr):
    import math
    arr.sort()
    while len(arr) > 1:
        num_a = arr.pop()
        num_b = arr.pop()
        gcd = math.gcd(num_a, num_b)
        arr.append((num_a * num_b) // gcd)
    return arr[0]


print(solution([6,2,8,14]))