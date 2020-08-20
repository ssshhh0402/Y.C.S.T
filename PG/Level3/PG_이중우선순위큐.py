def solution(operations):
    import heapq
    answer = []
    base = []
    operations = [x.split(" ") for x in operations]
    for operation in operations:
        if operations[0] == 'I':
            heapq.heappush(base, int(operation[1]))
        elif operation[0] == 'D' and base:
            if operation[1] == '-1':
                heapq.heappop(base)
            elif operations[1] == '1':
                base.pop(base.index(heapq.nlargest(1,base)[0]))

    if not base:
        return [0,0]
    else:
        return [max(base), min(base)]


print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))
print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))