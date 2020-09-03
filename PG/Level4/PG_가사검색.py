# def divide(word):
#
#     start = -1
#     end = 0
#     for chr in range(len(word)):
#         if word[chr] == '?':
#             if start < 0:
#                 start = chr
#             else:
#                 end = chr
#     return start, end
#
# def find(target, words):
#     answer = 0
#     start, end = divide(target)
#     for word in words:
#         if len(word) == len(target):
#             if word[: start] == target[:start] and word[end+1:] == target[end+1:]:
#                 answer += 1
#     return answer
#
# def solution(words, queries):
#     answer = []
#     for query in queries:
#         n = find(query, words)
#         answer.append(n)
#     return answer
class Node:
    def __init__(self, w=""):
        self.word = w
        self.nList = {}
        self.length = 0

class Trie:
    def __init__(self):
        self.root = Node("")
        self.keyList = {}

    def create(self, words, reverse = False):
        for word in words:
            if reverse:
                word = word[::-1]
            if word not in self.keyList:
                self.keyList[word] = len(word)
                cur_node = self.root
                for w in word:
                    if w not in cur_node.nList:
                        cur_node.nList[w] = Node(w)
                    cur_node = cur_node.nList[w]
                cur_node.length = len(word)

    def search(self, word):
        num = 0
        cur_node = self.root
        for w in word:
            if w not in cur_node.nList:
                if w == '?':
                    stack = []
                    l = len(word)
                    nQ = word.count("?")
                    if nQ == l:
                        for i in self.keyList.values():
                            num += 1
                        break
                    for node in cur_node.nList.values():
                        stack.append((node, 1))
                    while stack:
                        cur_node, cur_depth = stack.pop()
                        if cur_node.length == len(word) and cur_depth == nQ:
                            num += 1
                        if cur_depth < nQ:
                            for node in cur_node.nList.values():
                                stack.append((node, cur_depth+1))
                    break
                else:
                    break
            cur_node = cur_node.nList[w]
        return num

def solution(words, queries):
    answer = []
    base = {}
    trie = Trie()
    trie.create(words, False)
    re_trie = Trie()
    re_trie.create(words, True)
    for query in queries:
        if query not in base:
            if query.startswith("?"):
                answer.append(re_trie.search(query[::-1]))
            else:
                answer.append(trie.search(query))
            base[query] = answer[-1]
        else:
            answer.append(base[query])
    return answer

print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?", "f????"]))
