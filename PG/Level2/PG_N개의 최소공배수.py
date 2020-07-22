def solution(arr):
    answer = 0
    arr.sort()
    base = [[] for _ in range(len(arr))]
    idx = 1
    while True:
        flag = True
        for item in range(len(arr)):
            base[item].append(arr[item] * idx)
        key = base[0][-1]
        for baseItem in base:
            if key not in baseItem:

                flag = False
                break
        if flag:
            return key
        else:
            idx += 1

print(solution([6,2,8,14]))