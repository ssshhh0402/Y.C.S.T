from collections import deque

def solution(begin, target, words):
    answer = 0
    base = deque([begin])

    def differents(arr1, arr2):
        count = 0
        for idx in range(len(arr1)):
            if arr1[idx] != arr2[idx]:
                count += 1
            if count >= 2:
                return False
        return True
    if target not in words:
        return 0
    else:
        while target not in base or not base:
            answer += 1
            for idx in range(len(base)):
                begin = base.popleft()
                for word in words:
                    if differents(begin, word):
                        base.append(word)
    return answer


print(solution("hit", "cog", ["hot", "dot","dog","lot","log","cog"]))
print(solution("hit", "cog", ["hot","dot","dog","lot","log"]))