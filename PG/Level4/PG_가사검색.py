def find(target, base):
    n = len(target)
    if n not in base:
        return 0
    else:
        now = base[n]
    answer = 0
    for chr in target:
        if chr != '?':
            answer = now[chr]['count']
            now = now[chr]
        else:
            break
    return answer

def solution(words, queries):
    answer = []
    base = {}
    re_base = {}
    for word in words:
        idx = 0
        if len(word) in base:
            now = base[len(word)]
        else:
            base[len(word)] = {}
            now = base[len(word)]
        while idx != len(word):
            chr = word[idx]
            if chr not in now:
                now[chr] = {'count': 1}
            else:
                now[chr]['count'] += 1
            now = now[chr]
            idx += 1
    for word in words:
        idx = 0
        if len(word) in re_base:
            now = re_base[len(word)]
        else:
            re_base[len(word)] = {}
            now = re_base[len(word)]
        word = word[::-1]
        while idx != len(word):
            chr = word[idx]
            if chr not in now:
                now[chr] = {'count' : 1}
            else:
                now[chr]['count'] += 1
            now = now[chr]
            idx += 1
    for query in queries:
        n = len(query)
        if n == query.count("?"): 
            answer.append(base[n])
        elif not query.startswith("?"):
            answer.append(find(query, base))
        else:
            answer.append(find(query[::-1], re_base))
    return answer
print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]))
