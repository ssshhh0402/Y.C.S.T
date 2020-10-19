def check(results):
    for result in results:
        x, y, kind = result
        if not kind:
            if not y:
                continue
            elif [x-1, y, 1] in results or [x, y, 1] in results:
                continue
            elif [x, y-1, 0] in results:
                continue
            else:
                return False
        else:
            if [x, y-1, 0] in results or [x+1, y-1, 0] in results:
                continue
            elif [x-1, y, 1] in results and [x+1, y, 1] in results:
                continue
            else:
                return False
    return True


def solution(n, build_frame):
    answer = []
    for start, end, kind, flag in build_frame:                 #kind: 종류 => 0: 기둥 1: 보, flag : 삽입/삭제 => 0: 삭제, 1: 삽입
        if flag:
            answer.append([start, end, kind])
            if not check(answer):
                answer.remove([start, end, kind])
        else:
            answer.remove([start, end, kind])
            if not check(answer):
                answer.append([start, end, kind])
    answer.sort(key=lambda x: (x[0], x[1], x[2]))
    return answer


print(solution(5, [[1, 0, 0, 1], [1, 1, 1, 1], [2, 1, 0, 1], [2, 2, 1, 1], [5, 0, 0, 1], [5, 1, 0, 1], [4, 2, 1, 1], [3, 2, 1, 1]]))