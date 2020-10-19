def solution(w,h):
    answer = 1
    angle = w / h
    for idx in range(0, w+1):
        print(angle)
        print(angle * idx)
        print(((angle * idx) % 1) == 0)


print(solution(8,12))
