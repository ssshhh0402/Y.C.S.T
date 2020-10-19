import collections


def solution(priorities, location):
    answer = 0
    printer = collections.deque(priorities)
    loc = collections.deque([0 for _ in range(len(priorities))])
    loc[location] = 1
    while True:
        target = printer[0]
        if target == max(printer):
            if loc[0] == 1:
                answer += 1
                return answer
            else:
                answer += 1
                loc.popleft()
                printer.popleft()
        else:
            loc.rotate(-1)
            printer.rotate(-1)


# print(solution([2, 1, 3, 2], 2))
print(solution([1, 1, 9, 1, 1, 1], 0))
