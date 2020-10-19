def solution(n, words):
    person = 2
    times = 1
    idx = 1
    used = [words[0]]
    while True:
        if words[idx][0] != words[idx-1][-1] or words[idx] in used:
            answer = [person, times]
            break
        else:
            used.append(words[idx])
            idx += 1
            person += 1
            if person > n:
                person = 1
                times += 1
            if idx == len(words):
                answer = [0, 0]
                break
    return answer


#print(solution(3, ["tank","kick","know","wheel","land","dream","mother","robot","tank"]))
print(solution(2, ['hello', 'one', 'even', 'never', 'now', 'world', 'draw']))