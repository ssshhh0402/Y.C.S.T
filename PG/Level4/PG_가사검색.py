def find(target, words):
    answer = 0
    for word in words:
        if len(word) == len(target):
            flag = True
            for idx in range(len(word)):
                if target[idx] != word[idx] and target[idx] != '?':
                    flag = False
                    break
            if flag:
                answer += 1
    return answer

def solution(words, queries):
    answer = []
    for query in queries:
        n = find(query, words)
        answer.append(n)
    return answer


print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]))
