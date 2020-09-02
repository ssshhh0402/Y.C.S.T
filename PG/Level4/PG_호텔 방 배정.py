import sys
sys.setrecursionlimit(10**6)
def find(target, base, used):
    if not used[target]:
        return target
    else:
        return find(base[target], base, used)


def solution(k, room_number):
    answer = []
    base = {}
    used = [0 for _ in range(k+1)]
    for idx in range(1, k+1):
        base[idx] = idx
    for room in room_number:
        if not used[room]:
            used[room] = 1
            base[room] = base[room] + 1
            answer.append(room)
        else:
            n = find(base[room], base, used)
            used[n] = 1
            base[n] = base[n] + 1
            answer.append(n)
    return answer


print(solution(10,[1,3,4,1,3,1]))
