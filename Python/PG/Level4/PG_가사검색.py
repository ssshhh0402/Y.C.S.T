import sys
sys.setrecursionlimit(10 ** 8)
def find(target, base):
    n = len(target)
    answer = 0
    if n not in base:
        return 0
    else:
        now = base[n]
    for chr in target:
        if chr != '?':
            if chr in now:
                answer = now[chr]['count']
                now = now[chr]
            else:
                answer = 0
                break
        else:
            break
    return answer

def solution(words, queries):
    answer = []
    base = {}
    re_base = {}
    for word in words:
        if len(word) in base:
            now = base[len(word)]
        else:
            base[len(word)] = {}
            now = base[len(word)]
        for chr in word:
            if chr not in now:
                now[chr] = {'count': 1}
            else:
                now[chr]['count'] += 1
            now = now[chr]
    for word in words:
        if len(word) in re_base:
            now = re_base[len(word)]
        else:
            re_base[len(word)] = {}
            now = re_base[len(word)]
        word = word[::-1]
        for chr in word:
            if chr not in now:
                now[chr] = {'count' : 1}
            else:
                now[chr]['count'] += 1
            now = now[chr]
    for query in queries:
        n = len(query)
        if n == query.count("?"):
            temps = 0
            if n in base:
                for temp in base[n]:
                    temps += base[n][temp]['count']
            answer.append(temps)
        elif not query.startswith("?"):
            answer.append(find(query, base))
        else:
            answer.append(find(query[::-1], re_base))
    return answer
print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]))
print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["????k"]))