def find(a, b, c):
    global answer, count
    if ''.join(a).startswith('0') or ''.join(b).startswith('0'):
        return
    num_one,num_two = int(''.join(a)), int(''.join(b))
    nums = num_one + num_two
    if nums < 10:
        if not count:
            answer = [c, nums]
            count = c
        elif c < count:
            answer = [c, nums]
            count = c
        elif c == count:
            answer = [c, nums]
        return
    if count and c > count:
        return
    nums = str(nums)
    for idx in range(1, len(nums)):
        find(nums[:idx], nums[idx:], c+1)


def solution(n):
    global answer, count
    answer = []
    count = 0
    if n < 10:
        return [0, n]
    else:
        n = list(str(n))
        for idx in range(1, len(n)):
            find(n[:idx], n[idx:], 1)
    return answer


print(solution(73425))
print(solution(10007))
print(solution(9))