def find(ballons, flag):
    global answer
    if len(ballons) == 1:
        if ballons[0] not in answer:
            answer.append(ballons[0])
        return
    for idx in range(len(ballons)-1):
        ballon_one = ballons[idx]
        ballon_two = ballons[idx+1]
        ballons.remove(ballon_one)
        if ballon_one > ballon_two:
            find(ballons, flag)
        else:
            if not flag:
                find(ballons, not flag)
        ballons.insert(idx, ballon_one)
        ballons.remove(ballon_two)
        if ballon_one > ballon_two:
            if not flag:
                find(ballons, not flag)
        else:
            find(ballons, flag)
        ballons.insert(idx+1, ballon_two)


def solution(a):
    global answer
    answer = []
    if len(a) == 1:
        return [a[0]]
    for idx in range(len(a)-1):
        ballon_one = a[idx]
        ballon_two = a[idx+1]
        a.remove(ballon_one)
        if ballon_one > ballon_two:
            find(a, False)
        else:
            find(a, True)
        a.insert(idx, ballon_one)
        a.remove(ballon_two)
        if ballon_one > ballon_two:
            find(a, True)
        else:
            find(a, False)
        a.insert(idx+1, ballon_two)
    return len(answer)


#print(solution([9,-1,-5]))
print(solution([-16,27,65,-2,58,-92,-71,-68,-61,-33]))
