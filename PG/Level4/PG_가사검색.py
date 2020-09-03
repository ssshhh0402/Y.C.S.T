def divide(word):

    start = -1
    end = 0
    for chr in range(len(word)):
        if word[chr] == '?':
            if start < 0:
                start = chr
            else:
                end = chr
    return start, end

def find(target, words):
    answer = 0
    start, end = divide(target)
    for word in words:
        if len(word) == len(target):
            a = word[:start]
            b = target[:start]
            c = word[end+1:]
            d = target[end+1:]
            if word[: start] == target[:start] and word[end+1:] == target[end+1:]:
                answer += 1
    return answer

def solution(words, queries):
    answer = []
    for query in queries:
        n = find(query, words)
        answer.append(n)
    return answer


print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]))
