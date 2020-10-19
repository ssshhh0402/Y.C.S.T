def solution(operations):
    import heapq
    base = []
    for operation in operations:
        oper, nums = operation.split(" ")
        if oper == 'I':
            heapq.heappush(base, int(nums))
        elif oper == 'D' and base:
            if nums == '-1':
                heapq.heappop(base)
            elif nums == '1':
                base.pop(base.index(heapq.nlargest(1, base)[0]))

    if not base:
        return [0,0]
    else:
        return [max(base), min(base)]


print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))
print(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))